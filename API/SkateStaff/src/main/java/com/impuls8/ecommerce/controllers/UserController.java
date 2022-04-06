package com.impuls8.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.ChangePassword;
import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.service.UserService;

@RestController
@RequestMapping (path="/api/users/")
@CrossOrigin(origins="*")
public class UserController {

private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}//constructor

	@GetMapping
	public List<User> getUsuarios(){
		return userService.getUsers();
		
	}//getUsuarios
	
	@GetMapping(path = "{prodId}")
	public User getUsuario(@PathVariable("prodId") Long id ) {
		return userService.getUser(id);
	}//getUsuario
	
	@DeleteMapping (path = "{prodId}")
	public void deleteUsuario(@PathVariable("prodId") Long id) {
		userService.deleteUser(id);
		
	}//deleteUsuario
	
	
	@PostMapping
    public void addUsuario(@RequestBody User user)	{
		userService.addUser(user);
		
	}//addUsuario
	
	@PutMapping  
	public void updateUsuario(@RequestBody ChangePassword changePassword) {
		userService.updateUser(changePassword);
		
	}///updateUsuario

}//UserController

