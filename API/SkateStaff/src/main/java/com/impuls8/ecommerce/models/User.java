package com.impuls8.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class User {
	@Id//indica que el private long es un id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //campo para identificar (autoincrement)
	@Column(name="idUser", unique=true, nullable=false)//(PK, NN - not null)
	
	private Long idUser;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String password;
	private boolean isAdmin;
	public User(Long idUser, String userName, String userEmail, String userPhone, String password, boolean isAdmin) {
		this.idUser = idUser;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
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
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	
	
}//User
