package com.impuls8.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.OrderProductQuantity;

@Service
public class OrderProductQuantityService {

	private final OrderProductQuantityRepository orderProductQuantityRepository;
	
	@Autowired
	public OrderProductQuantityService(OrderProductQuantityRepository orderProductQuantityRepository) {
		this.orderProductQuantityRepository = orderProductQuantityRepository;
	}//constructor

	public List<OrderProductQuantity> getOrdersProductQuantity() {
		return orderProductQuantityRepository.findAll();
	}//getOrdersProductQuantity

	public List<OrderProductQuantity> getOrderProductQuantity(Long id) {
		return orderProductQuantityRepository.findByOrderId(id).orElseThrow(
				()-> new IllegalStateException("La orden con el id " + id + " no existe.") );
	}//getOrderProductQuantity

	public OrderProductQuantity addOrderProductQuantity(OrderProductQuantity order) {
		orderProductQuantityRepository.save(order);
		return order;
	}//addOrderProductQuantity
	
}//OrderProductQuantityService
