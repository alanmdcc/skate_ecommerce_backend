package com.impuls8.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.ChangePassword;
import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.utils.SHAUtils;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}//userRepository constructor
	
	public List<User> getUsuarios(){
		return userRepository.findAll();
	}
	
	public User getUsuario(Long id) {
		return userRepository.findById(id).orElseThrow(
				()-> new IllegalStateException(
						"El usuario con el id [" + id + "] no existe"));
	}
	public void deleteUsuario(Long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}//if exist
	}//deleteUsuario
	
	public void updateUsuario(ChangePassword changePassword) {
		Optional<User> userByName=userRepository.findByUserName(changePassword.getUserName());
		if(userByName.isPresent()) {
			User u = userByName.get();;
			if( SHAUtils.verifyHash(changePassword.getPassword(), u.getPassword())) {
				u.setPassword(SHAUtils.createHash(changePassword.getNewPassword()));;
				userRepository.save(u);
				
			}
		}
	}


	public void addUsuario(User user) {
		Optional<User> userByName=userRepository.findByUserName(user.getUserName());
		if(userByName.isPresent()) {
			throw new IllegalStateException("El usuario con el nombre [" + user.getUserName() +
					"] Ya existe.");
		} else {
			user.setPassword(SHAUtils.createHash(user.getPassword()));
			userRepository.save(user);
		}
	}

	public boolean validateUsuario(User user) {
		boolean res = false;
		Optional<User> userByName=userRepository.findByUserName(user.getUserName());
		if(userByName.isPresent()) {
			System.out.println("si existe");
			User u = userByName.get();;
			if(SHAUtils.verifyHash(user.getPassword(), u.getPassword())) {
				res = true;
				
			}
		}
		System.out.println("no existe");
		return res;
	}
}//UserService
