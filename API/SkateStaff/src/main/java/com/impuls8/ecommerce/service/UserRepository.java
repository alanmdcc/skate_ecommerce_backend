package com.impuls8.ecommerce.service;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impuls8.ecommerce.models.User;

public interface UserRepository 
extends JpaRepository<User, Long>{
	@Query ("SELECT u FROM User u WHERE u.userName=?1")
	Optional<User> findByUserName(String userName);
}//interface usuariosrepository
