package global.coda.hospital.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import global.coda.hospital.models.DoctorDetails;
import global.coda.hospital.models.DoctorSpecificPatients;
import global.coda.hospital.services.DoctorService;

/**
 * The Class DoctorController.
 */
@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	private static final Logger LOGGER = LogManager.getLogger(DoctorController.class);
	/** The doctor service. */
	@Autowired
	private DoctorService doctorService;
	/**
	 * Instantiates a new doctor controller.
	 * @param doctorService the doctor service
	 */
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	/**
	 * Gets the all patients.
	 * @return the all patients
	 * @throws SystemException 
	 */
	@GetMapping("/all")
	public CustomResponse<List<DoctorDetails>> getAllDoctors(@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		LOGGER.traceEntry("Gettting All patient details");
		List<DoctorDetails> doctorList = doctorService.getAllDoctorService();
		CustomResponse<List<DoctorDetails>> response= new CustomResponse<List<DoctorDetails>>();
		response.setObject(doctorList);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Gets the patient by id.
	 * @param doctorId the user id
	 * @return the patient by id
	 * @throws BusinessException 
	 * @throws SystemException 
	 */
	@GetMapping("/id/{userId}")
	public CustomResponse<DoctorDetails> getDoctorById(@PathVariable("userId") int doctorId,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws BusinessException, SystemException {
		LOGGER.traceEntry(String.valueOf(doctorId));
		DoctorDetails doctorDetails = new DoctorDetails();
		doctorDetails = doctorService.getPatientByIdService(doctorId);
		CustomResponse<DoctorDetails> response= new CustomResponse<DoctorDetails>();
		response.setObject(doctorDetails);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Update patient.
	 * @param doctor the doctor
	 * @return the string
	 * @throws SystemException 
	 * @throws BusinessException 
	 */
	@PostMapping("/update")
	public CustomResponse<String> updateDoctor(@RequestBody DoctorDetails doctor,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws BusinessException, SystemException {
		LOGGER.traceEntry(doctor.toString());
		String message = doctorService.updatePatientRecordService(doctor);
		CustomResponse<String> response= new CustomResponse<String>();
		response.setObject(message);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Delete user.
	 * @param doctorId the id
	 * @return the string
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@PutMapping("/delete/{id}")
	public CustomResponse<String> deleteDoctor(@PathVariable("id") int doctorId,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws BusinessException, SystemException {
		LOGGER.traceEntry(String.valueOf(doctorId));
		String message = doctorService.deletePatientRecordService(doctorId);
		CustomResponse<String> response= new CustomResponse<String>();
		response.setObject(message);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Delete patient.
	 * @param doctor the doctor
	 * @return the string
	 * @throws SystemException 
	 */
	@PostMapping("/create")
	public CustomResponse<String> createDoctor(@RequestBody DoctorDetails doctor,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		LOGGER.traceEntry(doctor.toString());
		String message = doctorService.createPatientRecordService(doctor);
		CustomResponse<String> response= new CustomResponse<String>();
		response.setObject(message);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
		
    }
	/**
	 * Gets the all patientsof all doctors.
	 * @param doctorId the id
	 * @return the all patientsof all doctors
	 * @throws SystemException 
	 */
	@GetMapping("/allpatients/{id}")
	public CustomResponse<List<DoctorSpecificPatients>> getAllPatientsofDoctor(@PathVariable("id") int doctorId,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		LOGGER.traceEntry(String.valueOf(doctorId));
		List<DoctorSpecificPatients> doctorPatientList = doctorService.getAllPatientsofDoctorService(doctorId);
		CustomResponse<List<DoctorSpecificPatients>> response= new CustomResponse<List<DoctorSpecificPatients>>();
		response.setObject(doctorPatientList);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
	/**
	 * Gets the all doctors all patients.
	 * @return the all doctors all patients
	 * @throws SystemException 
	 */
	@GetMapping("/allpatients/")
	public CustomResponse<List<DoctorSpecificPatients>> getAllDoctorsAllPatients(@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws SystemException {
		LOGGER.trace("Reading All Patients of All Doctors");
		List<DoctorSpecificPatients> doctorPatientList = doctorService.getAllPatientsofDoctorService(0);
		CustomResponse<List<DoctorSpecificPatients>> response= new CustomResponse<List<DoctorSpecificPatients>>();
		response.setObject(doctorPatientList);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
}
