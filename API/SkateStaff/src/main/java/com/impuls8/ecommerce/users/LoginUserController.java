package com.impuls8.ecommerce.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/users/login")//requesmapping crea una ruta para todos los metodos (get, post, delete...)
@CrossOrigin(origins="*")//corssorigin otorga permisos a la url especificada para acceder

public class LoginUserController {

	private final LoginUserService loginUserService;
	//inyección de dependencias
	
	@Autowired//autowired ejecuta el constructor una sola vez
	public LoginUserController( LoginUserService loginUserService) {
		this.loginUserService=loginUserService;
	}//constructor
	
	@PostMapping
	public String validateUser(@RequestBody User user) {
		return loginUserService.validateUser(user);
	}//addProducto
	

}
