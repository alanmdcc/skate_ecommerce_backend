package com.impuls8.ecommerce.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.User;

@Service
public class UserService {
	
	public final ArrayList<User> lista= new ArrayList<User>();
	
	public UserService() {
		lista.add(		
				 new User("Alan Martin del Campo", "alanmdc@gmail.com",
						 "5588899", "password", false)
				);
				lista.add( new User("Andres Arellano", "andresab@gmail.com",
						 "5688789", "password", false)
						);
				lista.add( new User("Manuel Aguirre", "manuel.ag@gmail.com",
						 "5599899", "password", false)
						);
				lista.add( new User("David Martinez", "davidmtz@gmail.com",
						 "5577777", "password", false)
						);
	}//constructor
	
	public ArrayList<User> getUsers() {
		return lista;
	}//getUsers

	public User getUser(Long userId) {
	   User tmpProd =null;
		for (User user : lista) {
			if(user.getId()==userId) {
				tmpProd=user;
				break;
			}//if
		}//foreach	
		return tmpProd;
	}//getUser
	
	public User deleteUser(Long userdId) {
		User tmpProd =null;
		for (User User : lista) {
			if(User.getId()==userdId) {
				lista.remove(lista.indexOf(User));
				break;
			}//if
		}//foreach	
		return tmpProd;
	}//deleteUser
	
	public User updateUser(Long userId, String userName, String userEmail, String userPhone,
			String password, boolean isAdmin) {
		User tmpProd = null;
		for (User User : lista) {
			if(User.getId()==userId) {
				if(userName != null) User.setUserName(userName);
				if(userEmail != null) User.setUserEmail(userEmail);
				if(userPhone != null) User.setUserPhone(userPhone);
				if(password != null) User.setPassword(password);
				User.setAdmin(isAdmin);
			}//if
		}//for each
		return tmpProd;
	}//updateUser


	public String addUser(User user) {
		boolean tmpValidation = true;
		String message ="";
		for (User userLista : lista) {
			if(user.getUserEmail().equals(userLista.getUserEmail())) {
				tmpValidation = false;
				System.out.println("Correos iguales");
				message="El correo ingresado ya existe";
				break;
			}//if
		}//foreach
		if(tmpValidation) {
			lista.add(user);
			message="Se agrego un nuevo usuario con los siguientes datos: "+user.toString();
		}//if
		
		return message;
	}//addUser

}//UserService
