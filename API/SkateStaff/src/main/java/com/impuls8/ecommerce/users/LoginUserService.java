package com.impuls8.ecommerce.users;

import org.springframework.stereotype.Service;

@Service
public class LoginUserService {
	

private  UserService userService = new UserService();
	
	public String validateUser(User user) {
		User tmpUser =null;
		   String message="El usuario no est� registrado";
			for (User userLista : userService.lista) {
				if(userLista.getUserEmail().equals(user.getUserEmail())){
					tmpUser=userLista;
					if(tmpUser.getPassword().equals(user.getPassword())) {
						message="Inicio de sesi�n exitoso";
						break;
					}//if
					message="Email no coincide con la contrase�a";
					break;
				}//if
			}//foreach	
			return message;
	}//validateUser
	
}//class LoginUserService
