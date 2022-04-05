package com.impuls8.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impuls8.ecommerce.embeddedId.OrderProductQuantityId;
import com.impuls8.ecommerce.models.OrderProductQuantity;

public interface OrderProductQuantityRepository extends JpaRepository<OrderProductQuantity, OrderProductQuantityId>{
	@Query("SELECT u FROM OrderProductQuantity u WHERE u.orderProductQuantityId.UserOrder_idUserOrder=?1")//JPQL
	Optional<List<OrderProductQuantity>> findByOrderId (Long UserOrder_idUserOrder);
	
}//OrderProductQuantityRepository
