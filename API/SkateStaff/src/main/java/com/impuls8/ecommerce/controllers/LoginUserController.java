package com.impuls8.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.service.LoginUserService;



@RestController
@RequestMapping (path="/api/users/login")
@CrossOrigin(origins="*")
public class LoginUserController {

	private final LoginUserService loginUserService;
	
	@Autowired
	public LoginUserController( LoginUserService loginUserService) {
		this.loginUserService=loginUserService;
	}//constructor
	
	@PostMapping
	public boolean validateUser(@RequestBody User user) {
		return loginUserService.validateUser(user);
	}//addProducto
	
}//LoginUserController
