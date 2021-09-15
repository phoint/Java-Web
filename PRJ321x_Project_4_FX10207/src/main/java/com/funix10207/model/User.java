package com.funix10207.model;

public class User {
	private String userName, userMail, userAddress, userPhone, userPwd;
	private int userRole;

	public User() {
	}

	public User(String userName, String userMail, String userPwd, int userRole) {
		this.userName = userName;
		this.userMail = userMail;
		this.userPwd = userPwd;
		this.userRole = userRole;
	}

	public User(String userName, String userMail, String userAddress, String userPhone, String userPwd, int userRole) {
		this.userName = userName;
		this.userMail = userMail;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userPwd = userPwd;
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

}
