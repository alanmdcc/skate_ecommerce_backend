package com.impuls8.ecommerce.service;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impuls8.ecommerce.models.User;
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.userName=?1") ///va a ir a buscar u de usuario
	
	Optional<User> findByUsername(String username);
		
		
	

}//ProductosRepository


