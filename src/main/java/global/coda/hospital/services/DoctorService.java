package global.coda.hospital.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hospital.exceptions.BusinessException;
import global.coda.hospital.exceptions.InvalidUserIdException;
import global.coda.hospital.exceptions.SystemException;
import global.coda.hospital.mapper.DoctorMapper;
import global.coda.hospital.models.DoctorDetails;
import global.coda.hospital.models.DoctorSpecificPatients;

/**
 * The Class DoctorService.
 */
@Service
public class DoctorService {
	private static final Logger LOGGER = LogManager.getLogger(DoctorService.class);
	/** The doctor mapper. */
	@Autowired
	private DoctorMapper doctorMapper;
	/**
	 * Instantiates a new doctor service.
	 * @param doctorMapper the doctor mapper
	 */
	public DoctorService(DoctorMapper doctorMapper) {
		this.doctorMapper = doctorMapper;
	}
	/**
	 * Gets the all patient service.
	 * @return the all patient service
	 * @throws SystemException 
	 */
	public List<DoctorDetails> getAllDoctorService() throws SystemException {
		LOGGER.trace("Getting all doctors service Initiated");
		try {
		return doctorMapper.getAllDoctorsMapper();
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			throw new SystemException(exception.getMessage());
		}
	}

	/**
	 * Gets the patient by id service.
	 * @param doctorId the user id
	 * @return the patient by id service
	 * @throws BusinessException 
	 * @throws SystemException 
	 */
	public DoctorDetails getPatientByIdService(int doctorId) throws BusinessException, SystemException {
		LOGGER.traceEntry(String.valueOf(doctorId));
		try {
			if(doctorId==0) {
				throw new InvalidUserIdException();
			}
		return doctorMapper.getDoctorByIdMapper(doctorId);
		}catch (InvalidUserIdException invalid) {
			throw new BusinessException(invalid.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			throw new SystemException(exception.getMessage());
		}
	}
	/**
	 * Delete patient record service.
	 * @param doctorId the user id
	 * @return the string
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public String deletePatientRecordService(int doctorId) throws BusinessException, SystemException {
		LOGGER.traceEntry(String.valueOf(doctorId));
		try {
			if (doctorId == 0) {
				throw new InvalidUserIdException();
			}
			int rowsAffected = doctorMapper.deleteUserMapper(doctorId);
			int rowsAffectedIndoctor = doctorMapper.deleteDoctorMapper(doctorId);
			if (rowsAffected == 1 && rowsAffectedIndoctor == 1) {
				return "Record deleted successfully";
			} else {
				return "Record Deletion Unsuccessful";
			}
		} catch (InvalidUserIdException invalid) {
			throw new BusinessException(invalid.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			throw new SystemException(exception.getMessage());
		}
	}
	/**
	 * Update patient record service.
	 * @param doctor the doctor
	 * @return the string
	 * @throws BusinessException 
	 * @throws SystemException 
	 */
	public String updatePatientRecordService(DoctorDetails doctor) throws BusinessException, SystemException {
		LOGGER.traceEntry(doctor.toString());
		try {
		int rowsAffected = doctorMapper.updateUserRecordMapper(doctor);
		int rowsAffectedIndoctor = doctorMapper.updateDoctorRecordMapper(doctor);
		if (rowsAffected == 1 && rowsAffectedIndoctor == 1) {
			return "Record updated successfully";
		} else {
			return "Record updation Unsuccessful";
		}
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			throw new SystemException(exception.getMessage());
		}
	}
	/**
	 * Creates the patient record service.
	 * @param doctor the doctor
	 * @return the string
	 * @throws SystemException 
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public String createPatientRecordService(DoctorDetails doctor) throws SystemException {
		LOGGER.traceEntry(doctor.toString());
		try {
		int rowsAffected = doctorMapper.createUserRecordMapper(doctor);
		int rowsAffectedIndoctor = doctorMapper.createDoctorRecordMapper(doctor);
		if (rowsAffected == 1 && rowsAffectedIndoctor == 1) {
			return "Record created successfully";
		} else {
			return "Record creation Unsuccessful";
		}} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			throw new SystemException(exception.getMessage());
		}
	}
	/**
	 * Gets the all patientsof doctor service.
	 * @param doctorId the id
	 * @return the all patientsof doctor service
	 * @throws SystemException 
	 */
	public List<DoctorSpecificPatients> getAllPatientsofDoctorService(int doctorId) throws SystemException {
		LOGGER.trace("Getting all patients of doctors service Initiated", String.valueOf(doctorId));
		try {
		return doctorMapper.getAllPatientsofDoctorMapper(doctorId);
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			throw new SystemException(exception.getMessage());
		}

	}
}
