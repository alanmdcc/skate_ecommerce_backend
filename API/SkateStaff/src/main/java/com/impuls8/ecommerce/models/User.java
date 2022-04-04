package com.impuls8.ecommerce.models;

public class User {

	private String userName;
	private String userEmail;
	private String userPhone;
	private String password;
	private boolean isAdmin;
	private static int total;
	private int id;

	public User(String userName, String userEmail, String userPhone, String password, boolean isAdmin) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.password = password;
		this.isAdmin = isAdmin;
		total++;
		this.id = total;
	}// contructor

	public User() {
		total++;
		this.id = total;
	}// constructor vacío

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		User.total = total;
	}

	public int getId() {
		return id;
	}// getters y setters

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", password="
				+ password + ", isAdmin=" + isAdmin + ", id=" + id + "]";
	}//toString
	
}//User
