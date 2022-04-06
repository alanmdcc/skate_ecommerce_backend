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
		public UserController( UserService userService) {
			this.userService=userService;
		}//constructor
		
		@GetMapping
		public List<User> getUsuarios(){
			return userService.getUsuarios();
		}
		
		@GetMapping(path="{userId}")
		public User getUser(@PathVariable("userId") Long userId) {
			return userService.getUsuario(userId);	
		}//getProducto
		
		@DeleteMapping
		public void deleteUser(@PathVariable("userId") Long userId) {
			userService.deleteUsuario(userId);
		}//deleteProducto
		
		@PostMapping
		public void addUser(@RequestBody User user) {
			userService.addUsuario(user);
		}//addProducto
		
		@PutMapping
		public void updateUser(@RequestBody ChangePassword changePassword){
			userService.updateUsuario(changePassword);
		}

}//UserController

