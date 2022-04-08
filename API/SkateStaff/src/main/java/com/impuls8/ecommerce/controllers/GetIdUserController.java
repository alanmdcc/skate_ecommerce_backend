package com.impuls8.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.service.UserService;

@RestController
@RequestMapping (path="/api/iduser/")
@CrossOrigin(origins="*")
public class GetIdUserController {
	
private final UserService userService;
	
	@Autowired
	public GetIdUserController(UserService userService) {
		this.userService = userService;
	}//constructor

	@PostMapping
	public Long getIdUser(@RequestBody User user){
		return userService.getIdUser(user);
		
	}//getUsuarios

}
