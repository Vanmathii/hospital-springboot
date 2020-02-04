package global.coda.hospital.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hospital.exceptions.BusinessException;
import global.coda.hospital.exceptions.InvalidUserIdException;
import global.coda.hospital.exceptions.SystemException;
import global.coda.hospital.mapper.PatientMapper;
import global.coda.hospital.models.DoctorSpecificPatients;
import global.coda.hospital.models.PatientDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientService.
 */
@Service
public class PatientService {
	private static final Logger LOGGER = LogManager.getLogger(PatientService.class);
	/** The patient mapper. */
	@Autowired
	private PatientMapper patientMapper;
	/**
	 * Instantiates a new patient service.
	 * @param patientMapper the patient mapper
	 */
	public PatientService(PatientMapper patientMapper) {
		this.patientMapper = patientMapper;
	}

	/**
	 * Gets the all patient service.
	 * @return the all patient service
	 * @throws Exception 
	 */
	public List<PatientDetails> getAllPatientService() throws Exception {
		LOGGER.trace("getAllPatientService Initiated");
		return patientMapper.getAllPatientsMapper();
	}

	/**
	 * Gets the patient by id service.
	 * @param patientId the user id
	 * @return the patient by id service
	 * @throws BusinessException 
	 * @throws SystemException 
	 * @throws Exception 
	 */
	public PatientDetails getPatientByIdService(int patientId) throws BusinessException, SystemException   {
		LOGGER.traceEntry(String.valueOf(patientId));
		try {
			if (patientId == 0) {
				throw new InvalidUserIdException();
			}
			return patientMapper.getPatientByIdMapper(patientId);
		} catch (InvalidUserIdException invalid) {
			throw new BusinessException(invalid.getMessage());
		}catch(Exception exception) {
		       throw new SystemException(exception.getMessage());
		}
	}

	/**
	 * Delete patient record service.
	 * @param patientId the user id
	 * @return the string
	 * @throws BusinessException 
	 * @throws SystemException 
	 */
	public String deletePatientRecordService(int patientId) throws BusinessException, SystemException {
	    LOGGER.traceEntry(String.valueOf(patientId));
		try {
			if (patientId == 0) {
				throw new InvalidUserIdException();
			}
			int rowsAffected = patientMapper.deleteUserMapper(patientId);
			int rowsAffectedinPatient = patientMapper.deletePatientMapper(patientId);
			if (rowsAffected == 1 && rowsAffectedinPatient == 1) {
				return "Record deleted successfully";
			} else {
				return "Record Deletion Unsuccessful";
			}
		} catch (InvalidUserIdException invalid) {
			throw new BusinessException(invalid.getMessage());
		}catch(Exception exception) {
		       throw new SystemException(exception.getMessage());
		}
	}

	/**
	 * Update patient record service.
	 * @param patient the patient
	 * @return the string
	 * @throws SystemException 
	 */
	public String updatePatientRecordService(PatientDetails patient) throws SystemException {
		LOGGER.traceEntry(patient.toString());
		try {
		int rowsAffected = patientMapper.updateUserRecordMapper(patient);
		int rowsAffectedInPatient = patientMapper.updatePatientRecordMapper(patient);
		if (rowsAffected == 1 && rowsAffectedInPatient == 1) {
			return "Record updated successfully";
		} else {
			return "Record updation Unsuccessful";
		}}catch(Exception exception) {
		       throw new SystemException(exception.getMessage());
		}
	}

	/**
	 * Creates the patient record service.
	 * @param patient the patient
	 * @return the string
	 * @throws SystemException 
	 */
	public String createPatientRecordService(PatientDetails patient) throws SystemException {
		LOGGER.traceEntry(patient.toString());
		try {
		int rowsAffected = patientMapper.createUserRecordMapper(patient);
		int rowsAffectedInPatient = patientMapper.createPatientRecordMapper(patient);
		if (rowsAffected == 1 && rowsAffectedInPatient == 1) {
			return "Record created successfully";
		} else {
			return "Record creation Unsuccessful";
		}}catch(Exception exception) {
		       throw new SystemException(exception.getMessage());
		}
	}
	/**
	 * Gets the all patientsof all doctors service.
	 * @return the all patientsof all doctors service
	 * @throws SystemException 
	 */
	public List<DoctorSpecificPatients> getAllPatientsofAllDoctorsService() throws SystemException {
		LOGGER.trace("getAllPatientsofAllDoctorsService Initiated");
		try {
		return patientMapper.getAllPatientsofAllDoctorsMapper();
		}catch(Exception exception) {
       throw new SystemException(exception.getMessage());
		}
	}
}
