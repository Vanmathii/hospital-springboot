package global.coda.hospital.models;

import java.util.List;

/**
 * The Class DoctorSpecificPatients.
 */
public class DoctorSpecificPatients {
	/** The user id. */
	private int userId;
	/** The name. */
	private String name;
	/** The specialization. */
	private String specialization;
	private List<PatientDetails> patientList;
 	/** The first name. */
 	private String firstName;
 	/** The user age. */
 	private int userAge;
 	/** The user mobile number. */
 	private String userMobileNumber;
 	/** The user address line 1. */
 	private String userAddressLine1;
 	/** The user address line 2. */
 	private String userAddressLine2;
 	/** The user address line 3. */
 	private String userAddressLine3;
 	/** The patient disease. */
 	private String patientDisease;
 	/** The patient blood group. */
 	private String patientBloodGroup;
	/**
	 * Gets the user id.
	 * @return the user id.
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * Sets the user id.
	 * @param userId the new user id.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * Gets the name.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name.
	 * @param name the new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the specialization.
	 * @return the specialization.
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * Sets the specialization.
	 * @param specialization the new specialization.
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/**
	 * Gets the patient list.
	 * @return the patient list
	 */
	public List<PatientDetails> getPatientList() {
		return patientList;
	}
	/**
	 * Sets the patient list.
	 * @param patientList the new patient list
	 */
	public void setPatientList(List<PatientDetails> patientList) {
		this.patientList = patientList;
	}
	/**
	 * To string.
	 * @return the string.
	 */
	@Override
	public String toString() {
		return "DoctorSpecificPatients [userId=" + userId + ", name=" + name + ", specialization=" + specialization
				+ ", patientList=" + patientList + ", firstName=" + firstName + ", userAge=" + userAge
				+ ", userMobileNumber=" + userMobileNumber + ", userAddressLine1=" + userAddressLine1
				+ ", userAddressLine2=" + userAddressLine2 + ", userAddressLine3=" + userAddressLine3
				+ ", patientDisease=" + patientDisease + ", patientBloodGroup=" + patientBloodGroup + "]";
	}
}
