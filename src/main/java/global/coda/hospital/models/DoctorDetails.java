package global.coda.hospital.models;

/**
 * Doctor specific details model.
 * @author VC.
 */
public class DoctorDetails extends UserDetails {
  private String specialization;
  /**
 * get doctor Specialization.
 * @return sepecialization.
 */
  public String getSpecialization() {
    return specialization;
  }
  /**
* Set doctor specialization.
* @param specialization doctor.
*/
  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }
  /**
 * convert object to string.
 */
@Override
public String toString() {
	return "DoctorDetails [specialization=" + specialization + ", pkUserId=" + pkUserId + ", fkRoleId=" + fkRoleId
			+ ", firstName=" + firstName + ", lastName=" + lastName + ", userAge=" + userAge + ", userMobileNumber="
			+ userMobileNumber + ", userAddressline1=" + userAddressline1 + ", userAddressline2=" + userAddressline2
			+ ", userAddressline3=" + userAddressline3 + ", userName=" + userName + ", password=" + password + "]";
}
}
