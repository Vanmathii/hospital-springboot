package global.coda.hospital.models;

public class LoginDetails {
String userName;
String password;
int role;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
@Override
public String toString() {
	return "LoginDetails [userName=" + userName + ", password=" + password + ", role=" + role + "]";
}

}
