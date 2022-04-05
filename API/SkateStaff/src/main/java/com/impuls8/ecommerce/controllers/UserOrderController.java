package com.impuls8.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.UserOrder;
import com.impuls8.ecommerce.service.UserOrderService;

@RestController
@RequestMapping (path="/api/orders/")
@CrossOrigin(origins="*")
public class UserOrderController {

	private final UserOrderService userOrderService;
	
	@Autowired
	public UserOrderController(UserOrderService userOrderService) {
		this.userOrderService=userOrderService;
	}//constructor
	
	@GetMapping
	public List<UserOrder>getUserOrders() {
		return userOrderService.getUserOrders();
	}//getUserOrders
	
	@GetMapping(path="{orderId}")
	public UserOrder getUserOrder(@PathVariable("orderId") Long orderId) {
		return userOrderService.getUserOrder(orderId);	
	}//getUserOrder
	
	@DeleteMapping(path="{orderId}")
	public UserOrder deleteUserOrder(@PathVariable("orderId") Long orderId) {
		return userOrderService.deleteUserOrder(orderId);
	}//deleteUserOrder
	
	@PostMapping
	public UserOrder addUserOrder(@RequestBody UserOrder product) {
		return userOrderService.addUserOrder(product);
	}//addUserOrder
	
}//UserOrderController
