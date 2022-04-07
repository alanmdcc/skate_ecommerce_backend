package com.impuls8.ecommerce.models;

public class ChangePassword {
	
	private String username;
	private String password;
	private String newPassword;
	private boolean isAdmin;
	public ChangePassword(String username, String password, String newPassword, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.newPassword = newPassword;
		this.isAdmin = isAdmin;
	}
	public ChangePassword() {
	
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "ChangePassword [username=" + username + ", password=" + password + ", newPassword=" + newPassword
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
	
}//class ChangePassword
