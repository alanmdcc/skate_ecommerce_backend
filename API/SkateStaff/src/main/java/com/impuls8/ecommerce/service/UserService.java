package com.impuls8.ecommerce.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.ChangePassword;
import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.utils.SHAutils;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}//constructor
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}//getUsuarios
	
	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(
				()-> new IllegalStateException ("El usuario con el id"+ id + "no existe."));
		
	}//getUsuario


	public void deleteUser(Long id) {
		if (userRepository.existsById(id)) {
		userRepository.deleteById(id);
		}//if exit deleteUsuario

	}//deleteUsuario

	public void addUser(User user) {
		Optional<User> userByName=userRepository.findByUsername(user.getUserName());
		if(userByName.isPresent()) {
			throw new IllegalStateException("El usuario con el nombre [" + user.getUserName() +
					"] Ya existe.");
		} else {
			user.setPassword(SHAutils.createHash(user.getPassword()));
			userRepository.save(user);
		}
	
	}//addUsuario

	public void updateUser(ChangePassword changePassword) {
		//Primero lo busco
		Optional<User> userByName=userRepository.findByUsername(changePassword.getUsername());
		if(userByName.isPresent()) {
			User u = userByName.get();;
			if( SHAutils.verifyHash(changePassword.getPassword(), u.getPassword())) {
				u.setPassword(SHAutils.createHash(changePassword.getNewPassword()));;
				userRepository.save(u);
				
			}
		}
	
	
	
	}//updateUsuario

	public boolean validateUser(User user) {
		boolean res = false;
		Optional<User> userByName=userRepository.findByUsername(user.getUserName());
		if(userByName.isPresent()) {
			User u = userByName.get();;
			if(SHAutils.verifyHash(user.getPassword(), u.getPassword())) {
				res = true;
				
			}
		}
		return res;
	}



}//UserService
