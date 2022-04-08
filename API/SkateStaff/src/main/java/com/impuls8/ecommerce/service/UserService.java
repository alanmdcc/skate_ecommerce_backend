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

public boolean addUser(User usuario) {
	Optional<User> userByName=userRepository.findByUseremail(usuario.getUserEmail());
	String cad ="";
	boolean res;
	if(userByName.isPresent()) {
		cad="El Usuario con el correo [" + usuario.getUserEmail() + 
				"] YA existe.";
		res=false;
	} else {
		cad="registro exitoso";
		res=true;
		usuario.setPassword(SHAutils.createHash(usuario.getPassword()));
		userRepository.save(usuario);
	}//else 
	return res;
}//addUsuario

	public void updateUser(ChangePassword changePassword) {
		Optional<User> userByName=userRepository.findByUseremail(changePassword.getUserEmail());
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
		Optional<User> userByName=userRepository.findByUseremail(user.getUserEmail());
		if(userByName.isPresent()) {
			User u = userByName.get();;
			if(SHAutils.verifyHash(user.getPassword(), u.getPassword())) {
				res = true;
				
			}
		}
		return res;
	}

	public boolean validateAdmin(User user) {
		User tmpUser = userRepository.findByUseremail(user.getUserEmail()).orElseThrow(
				()-> new IllegalStateException ("El usuario con el email "+ user.getUserEmail() + " no existe."));
		return tmpUser.isAdmin();
	}//validateAdmin

	public Long getIdUser(User user) {
		User tmpUser = userRepository.findByUseremail(user.getUserEmail()).orElseThrow(
				()-> new IllegalStateException ("El usuario con el email "+ user.getUserEmail() + " no existe."));
		return tmpUser.getId();
	}



}//UserService
