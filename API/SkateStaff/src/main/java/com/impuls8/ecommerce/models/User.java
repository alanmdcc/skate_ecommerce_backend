package com.impuls8.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idUser", unique=true, nullable=false)
	private Long id;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String password;
	private boolean isAdmin;

	public User(String userName, String userEmail, String userPhone, String password, boolean isAdmin) {
		super();
		this.id= id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.password = password;
		this.isAdmin = isAdmin;
	}// contructor

	public User() {
		
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

	public Long getId() {
		return id;
	}// getters y setters

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", password="
				+ password + ", isAdmin=" + isAdmin + ", id=" + id + "]";
	}//toString
	
}//User
