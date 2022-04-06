package com.impuls8.ecommerce.service;

import java.util.Optional;

import com.impuls8.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.nameProduct=?1")
	Optional<Product> findByNombre(String nameProduct);

}//ProductosRepository
