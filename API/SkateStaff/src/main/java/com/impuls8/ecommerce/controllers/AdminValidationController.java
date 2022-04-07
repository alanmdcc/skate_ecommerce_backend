package com.impuls8.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.service.UserService;

@RestController
@RequestMapping (path="/api/admin/")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class AdminValidationController {
	
	private final UserService userService;
	
	@Autowired
	public AdminValidationController(UserService userService) {
		this.userService = userService;
	}// constructor
	
	@PostMapping
    public boolean validateAdmin(@RequestBody User user)	{
		return userService.validateAdmin(user);
	}//addUsuario

}//AdminValidationController