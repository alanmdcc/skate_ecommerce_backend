package com.impuls8.ecommerce.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.ChangePassword;
import com.impuls8.ecommerce.models.User;

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

public boolean addUser(User usuario) {
	Optional<User> userByName=userRepository.findByUseremail(usuario.getUserEmail());
	String cad ="";
	boolean res;
	if(userByName.isPresent()) {
		cad="El Usuario con el correo [" + usuario.getUserEmail() + 
				"] YA existe.";
		res=false;
//		throw new IllegalStateException("El Usuario con el correo [" + usuario.getUserEmail() + 
//				"] YA existe."); 	
	} else {
		cad="registro exitoso";
		res=true;
		userRepository.save(usuario);
	}//else 
	return res;
}//addUsuario

public void updateUser(ChangePassword changePassword) {
	//Primero lo busco
	Optional<User> userByName=userRepository.findByUseremail(changePassword.getUserEmail());
	if(userByName.isPresent()) {
		//me va a traer al usuario con el get
		User u = userByName.get();
		if (u.getPassword().equals(changePassword.getPassword())) {	
		u.setPassword(changePassword.getNewPassword());
		
			userRepository.save(u);
		}//password
}//if isPresent
	
	
}//updateUsuario




}//UserService
