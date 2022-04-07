package com.impuls8.ecommerce.models;

public class ChangePassword {
	
	private String userEmail;
	private String password;
	private String newPassword;
	
	
	public ChangePassword(String userEmail, String password, String newPassword) {
		
		this.userEmail = userEmail;
		this.password = password;
		this.newPassword = newPassword;
	}//ChangePassword


	public ChangePassword() {
		
	}//ChangePassword


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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


	@Override
	public String toString() {
		return "ChangePassword [username=" + userEmail + ", password=" + password + ", newPassword=" + newPassword + "]";
	}
	
	
	
      
	
	
	
	
}//class ChangePassword
