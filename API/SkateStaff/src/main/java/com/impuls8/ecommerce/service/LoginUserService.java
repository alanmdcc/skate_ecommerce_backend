package com.impuls8.ecommerce.service;

import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.User;

@Service
public class LoginUserService {
	
	private  UserService userService = new UserService();
	
	public String validateUser(User user) {
		User tmpUser =null;
		   String message="El usuario no está registrado";
			for (User userLista : userService.lista) {
				if(userLista.getUserEmail().equals(user.getUserEmail())){
					tmpUser=userLista;
					if(tmpUser.getPassword().equals(user.getPassword())) {
						message="Inicio de sesión exitoso";
						break;
					}//if
					message="Email no coincide con la contraseña";
					break;
				}//if
			}//foreach	
			return message;
	}//validateUser
	
}//LoginUserService
