package com.impuls8.ecommerce.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.jwt.config.JwtFilter;
import com.impuls8.ecommerce.models.Token;
import com.impuls8.ecommerce.models.User;
import com.impuls8.ecommerce.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@RequestMapping (path="/api/login/")
@CrossOrigin(origins="*")
public class LoginUserController {

	private final UserService userService;
	
	@Autowired
	public LoginUserController( UserService userService) {
		this.userService=userService;
	}//constructor
	
	@PostMapping
	public Token login(@RequestBody User user) throws ServletException {
		if(userService.validateUsuario(user)) {
			return new Token(generateToken(user.getUserName()));
		}
		
		throw new ServletException("nombre de usuario o contrase;a incorrectos");
	}

	private String generateToken(String userName) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(userName).claim("role", "userName")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}// generateToken
	
}//LoginUserController
