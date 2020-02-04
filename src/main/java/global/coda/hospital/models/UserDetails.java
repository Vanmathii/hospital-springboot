package global.coda.hospital.models;

/**
 * UserDetails model.
 * @author VC
 */
public class UserDetails {
  /** The pk user id. */
  protected int pkUserId;
  /** The fk role id. */
  protected int fkRoleId;
  /** The first name. */
  protected String firstName;
  /** The last name. */
  protected String lastName;
  /** The user age. */
  protected int userAge;
  /** The user mobile number. */
  protected String userMobileNumber;
/** The user addressline 1. */
  protected String userAddressline1;
  /** The user addressline 2. */
  protected String userAddressline2;
  /** The user addressline 3. */
  protected String userAddressline3;
  /** The user name. */
  protected String userName;
  /** The password. */
  protected String password;
  /**
 * Get pkUserId.
 * @return userId of user.
 */
  public int getUserId() {
    return pkUserId;
  }
  /**
 * Set UserId to UserObject.
 * @param userId of user.
 */
  public void setUserId(int userId) {
    this.pkUserId = userId;
  }
  /**
 * Get fkRoleId.
 * @return roleId of user.
 */
  public int getRoleId() {
    return fkRoleId;
  }
  /**
 * Set rserId to UserObject.
 * @param roleId of user.
 */
  public void setRoleId(int roleId) {
    this.fkRoleId = roleId;
  }
  /**
 * get firstname.
 * @return firstname of user.
 */
  public String getFirstName() {
    return firstName;
  }
  /**
 * set firstname.
 * @param firstName of user.
 */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /**
 * get lastname.
 * @return lastname
 */
  public String getLastName() {
    return lastName;
  }
  /**
 * Set lastname to UserObject.
 * @param lastName of user.
 */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /**
 * Get UserAge.
 * @return userAge of user.
 */
  public int getUserAge() {
    return userAge;
  }
  /**
 * Set userAge to UserObject.
 * @param userAge of user.
 */
  public void setUserAge(int userAge) {
    this.userAge = userAge;
  }
  /**
   * Gets the user mobile number.
   * @return the user mobile number
   */
  public String getUserMobileNumber() {
		return userMobileNumber;
	}
	/**
	 * Sets the user mobile number.
	 * @param userMobileNumber the new user mobile number
	 */
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
  /**
* get address1.
 * @return address1 of user.
 */
  public String getAddressLine1() {
    return userAddressline1;
  }
  /**
   * Set address1 to UserObject.
   * @param userAddressline1 the new address line 1
   */
  public void setAddressLine1(String userAddressline1) {
    this.userAddressline1 = userAddressline1;
  }
  /**
 * get address2.
 * @return address2 of user.
 */
  public String getAddressLine2() {
    return userAddressline2;
  }
  /**
   * Set address2 to UserObject.
   * @param userAddressline2 the new address line 2
   */
  public void setAddressLine2(String userAddressline2) {
    this.userAddressline2 = userAddressline2;
  }
  /**
 * get address3.
 * @return address3 of user.
 */
  public String getAddressLine3() {
    return userAddressline3;
  }
  /**
   * Set address3 to UserObject.
   * @param userAddressline3 the new address line 3
   */
  public void setAddressLine3(String userAddressline3) {
    this.userAddressline3 = userAddressline3;
  }
  /**
 * get username.
 * @return address3 of user.
 */
  public String getUserName() {
    return userName;
  }
  /**
 * Set usrname to UserObject.
 * @param userName of user.
 */
  public void setUserName(String userName) {
    this.userName = userName;
  }
  /**
 * get password.
 * @return password of user.
 */
  public String getPassword() {
    return password;
  }
  /**
 * set password.
 * @param password of user.
 */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * convert object to string.
   * @return the string
   */
  @Override
  public String toString() {
    return "UserDetails [userId=" + pkUserId + ", roleId=" + fkRoleId + ", firstName=" + firstName + ","
      + " lastName=" + lastName + ", userAge=" + userAge + ", userMobNum=" + userMobileNumber + ","
      + "userAddressline1=" + userAddressline1
      + ", userAddressline2=" + userAddressline2 + ", userAddressline3=" + userAddressline3 + ","
      + " userName=" + userName + ", password=" + password + "]";
  }
}
