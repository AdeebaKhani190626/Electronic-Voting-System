package application;

import java.sql.SQLException;

public class Admin {

	private int AdminID;
	private int AdminNIC;
	private String AdminName;
	private String DOB;
	private String Address;
	private String UserName;
	private String Password;
	
	public boolean ValidateAdmin(String un, String pass) throws SQLException
	{	
		if (un.equals(UserName) && pass.equals(Password))
			return true;
		else
			return false;
	}
	
	/* Getters and Setters */
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public int getAdminNIC() {
		return AdminNIC;
	}
	public void setAdminNIC(int adminNIC) {
		AdminNIC = adminNIC;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}	
}
