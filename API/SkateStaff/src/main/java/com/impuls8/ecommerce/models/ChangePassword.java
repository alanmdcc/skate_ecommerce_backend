package com.impuls8.ecommerce.models;

public class ChangePassword {
	private String userName;
	private String password;
	private String newPassword;
	private boolean isAdmin;
	public ChangePassword(String userName, String password, String newPassword, boolean isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.newPassword = newPassword;
		this.isAdmin = isAdmin;
	}
	
	public ChangePassword() {
	
	}

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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "ChangePassword [userName=" + userName + ", password=" + password + ", newPassword=" + newPassword
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
}
