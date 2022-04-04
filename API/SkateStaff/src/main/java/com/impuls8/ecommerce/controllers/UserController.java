package com.impuls8.ecommerce.controllers;

import java.util.ArrayList;

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
		public ArrayList<User>getUsers() {
			return userService.getUsers();
		}//getProductos
		
		@GetMapping(path="{userId}")
		public User getUser(@PathVariable("userId") Long userId) {
			return userService.getUser(userId);	
		}//getProducto
		
		@DeleteMapping
		public User deleteUser(@PathVariable("userId") Long userId) {
			return userService.deleteUser(userId);
		}//deleteProducto
		
		@PostMapping
		public String addUser(@RequestBody User user) {
			return userService.addUser(user);
		}//addProducto
		
		@PutMapping(path="{userId}")
		public User updateUser(@PathVariable("userId") Long userId,
				@RequestParam(required=false) String nombre,
				@RequestParam(required=false) String email,
				@RequestParam(required=false) String phone,
				@RequestParam(required=false) String password,
				@RequestParam(required=false) boolean isAdmin) {
				return userService.updateUser(userId, nombre, email, phone, password, isAdmin);
		}//deleteProducto

}//UserController

