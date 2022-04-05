package com.impuls8.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.OrderProductQuantity;
import com.impuls8.ecommerce.service.OrderProductQuantityService;

@RestController
@RequestMapping (path="/api/ordersqty/")
@CrossOrigin(origins="*")
public class OrderProductQuantityController {

	private final OrderProductQuantityService orderProductQuantityService;
	
	@Autowired
	public OrderProductQuantityController(OrderProductQuantityService orderProductQuantityService) {
		this.orderProductQuantityService=orderProductQuantityService;
	}//constructor
	
	@GetMapping
	public List<OrderProductQuantity>getOrdersProductQuantity() {
		return orderProductQuantityService.getOrdersProductQuantity();
	}//getOrderProductQuantitys
	
	@GetMapping(path="{orderId}")
	public List<OrderProductQuantity> getOrderProductQuantity(@PathVariable("orderId") Long orderId) {
		return orderProductQuantityService.getOrderProductQuantity(orderId);	
	}//getOrderProductQuantity
	
	@PostMapping
	public OrderProductQuantity addOrderProductQuantity(@RequestBody OrderProductQuantity order) {
		return orderProductQuantityService.addOrderProductQuantity(order);
	}//addOrderProductQuantity
	
}//OrderProductQuantityController

