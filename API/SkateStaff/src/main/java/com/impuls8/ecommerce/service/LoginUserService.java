package com.impuls8.ecommerce.service;

import java.util.Optional;


import com.impuls8.ecommerce.utils.SHAutils;

import com.impuls8.ecommerce.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.User;

@Service
public class LoginUserService {
	private final UserRepository userRepository;
	@Autowired
	public LoginUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}//constructor
	
	private  UserService userService = new UserService(null);
	
	public boolean validateUser(User user) {
		boolean res=false;
	    Optional<User> userByName=UserRepository.findByUsername(user.getUserName());
	    if(userByName.isPresent()) {
	    	User u=userByName.get();
	    	if(SHAutils.verifyHash(user.getPassword(), u.getPassword())){
	    		res=true;
	    	}//if password
	    }//isPresent
	    return res;
	}
	
}//LoginUserService
