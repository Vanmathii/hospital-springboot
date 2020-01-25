package global.coda.hospital.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hospital.exceptions.BusinessException;
import global.coda.hospital.exceptions.SystemException;
import global.coda.hospital.models.CustomResponse;
import global.coda.hospital.models.DoctorSpecificPatients;
import global.coda.hospital.models.PatientDetails;
import global.coda.hospital.services.PatientService;

/**
 * The Class PatientController.
 */
@CrossOrigin
@RestController
@RequestMapping("/patients")
public class PatientController {
	private static final Logger LOGGER = LogManager.getLogger(PatientController.class);
	/** The patient service. */
	@Autowired
	private PatientService patientService;
	/**
	 * Instantiates a new patient controller.
	 * @param patientService the patient service
	 */
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	/**
	 * Gets the all patients.
	 * @return the all patients
	 * @throws Exception 
	 */
	@GetMapping("/all")
	public CustomResponse<List<PatientDetails>> getAllPatients(@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws Exception {
		LOGGER.trace("Reading All Patients");
		List<PatientDetails> patientList = patientService.getAllPatientService();
		CustomResponse<List<PatientDetails>> response= new CustomResponse<List<PatientDetails>>();
		response.setObject(patientList);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Gets the patient by id.
	 * @param patientId the user id
	 * @return the patient by id
	 * @throws BusinessException 
	 * @throws SystemException 
	 */
	@RequestMapping(value="/id/{patientId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomResponse<PatientDetails> getPatientById(@PathVariable("patientId") int patientId,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws BusinessException, SystemException {
		LOGGER.traceEntry(String.valueOf(patientId));
		PatientDetails patient = new PatientDetails();
		patient =patientService.getPatientByIdService(patientId);
		LOGGER.info(patient.toString());
		CustomResponse<PatientDetails> response= new CustomResponse<PatientDetails>();
		response.setObject(patient);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Update patient.
	 * @param patient the patient
	 * @return the string
	 * @throws SystemException 
	 */
	@PostMapping("/updatepatient")
	public CustomResponse<String> updatePatient(@RequestBody PatientDetails patient,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		String message = patientService.updatePatientRecordService(patient);
		CustomResponse<String> response= new CustomResponse<String>();
		response.setObject(message);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Delete user.
	 * @param patientId the id
	 * @return the string
	 * @throws BusinessException 
	 * @throws SystemException 
	 */
	@PutMapping("/deleteuser/{id}")
	public CustomResponse<String> deleteUser(@PathVariable("id") int patientId,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws BusinessException, SystemException {
		LOGGER.traceEntry(String.valueOf(patientId));
		String message = patientService.deletePatientRecordService(patientId);
		CustomResponse<String> response= new CustomResponse<String>();
		response.setObject(message);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Delete patient.
	 * @param patient the patient
	 * @return the string
	 * @throws SystemException 
	 */
	@PostMapping("/createpatient")
	public CustomResponse<String> deletePatient(@RequestBody PatientDetails patient,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		LOGGER.traceEntry(patient.toString());
		String message = patientService.createPatientRecordService(patient);
		CustomResponse<String> response= new CustomResponse<String>();
		response.setObject(message);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
    }
	/**
	 * Gets the all patientsof all doctors.
	 * @return the all patientsof all doctors
	 * @throws SystemException 
	 */
	@GetMapping("/allpatients")
	public CustomResponse<List<DoctorSpecificPatients>> getAllPatientsofAllDoctors(@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		LOGGER.trace("Reading All Patients of All Doctors");
		List<DoctorSpecificPatients> doctorSpecificPatientsList = patientService.getAllPatientsofAllDoctorsService();
		CustomResponse<List<DoctorSpecificPatients>> response= new CustomResponse<List<DoctorSpecificPatients>>();
		response.setObject(doctorSpecificPatientsList);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
}
