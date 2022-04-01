package com.impuls8.ecommerce.users;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {
	

	private  UserService userService;
	
	public ArrayList<User> getUser() {
		return userService.lista;
	}

	public String getUser( String password,String email) {
		   User tmpProd =null;
		   String message="El usuario no está registrado";
			for (User user : userService.lista) {
				if(user.getUserEmail()==email ) {
					tmpProd=user;
					if(user.getPassword()==password) {
						tmpProd=user;
						message="Inicio de sesión exitoso";
						break;
					}//if
				}//if
				
				
			}//foreach	
			return message;
		}//getUser
	
}
