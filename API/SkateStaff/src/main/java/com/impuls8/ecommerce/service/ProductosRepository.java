package com.impuls8.ecommerce.service;

import java.util.Optional;

import com.impuls8.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductosRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<Product> findByNombre(String nombre);

}//ProductosRepository
