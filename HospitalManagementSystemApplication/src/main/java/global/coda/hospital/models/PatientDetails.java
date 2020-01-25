package global.coda.hospital.models;
/**
 * The Class PatientDetails.
 */
public class PatientDetails extends UserDetails {
  /** The patient disease. */
  private String patientDisease;
  /** The patient bloodgroup. */
  private String patientBloodgroup;
  /**
   * Gets the blood group.
   * @return the blood group
   */
  public String getBloodGroup() {
    return patientBloodgroup;
  }
  /**
   * Sets the blood group.
   * @param patientBloodgroup the new blood group
   */
  public void setBloodGroup(String patientBloodgroup) {
    this.patientBloodgroup = patientBloodgroup;
  }
  /**
   * Gets the disease.
   * @return the disease
   */
  public String getDisease() {
    return patientDisease;
  }
  /**
   * Sets the disease.
   * @param patientDisease the new disease
   */
  public void setDisease(String patientDisease) {
    this.patientDisease = patientDisease;
  }
/**
 * To string.
 * @return the string
 */
@Override
public String toString() {
	return "PatientDetails [patientDisease=" + patientDisease + ", patientBloodgroup=" + patientBloodgroup + ", pkUserId=" + pkUserId
			+ ", fkRoleId=" + fkRoleId + ", firstName=" + firstName + ", lastName=" + lastName + ", userAge=" + userAge
			+ ", userMobileNumber=" + userMobileNumber + ", userAddressline1=" + userAddressline1
			+ ", userAddressline2=" + userAddressline2 + ", userAddressline3=" + userAddressline3 + ", userName="
			+ userName + ", password=" + password + "]";
}
}
