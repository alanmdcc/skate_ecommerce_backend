package com.impuls8.ecommerce.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.UserOrder;

@Service
public class UserOrderService {

	private final UserOrderRepository userOrderRepository;
	
	@Autowired
	public UserOrderService(UserOrderRepository userOrderRepository) {
		this.userOrderRepository = userOrderRepository;
	}//constructor

	public List<UserOrder> getUserOrders() {
		return userOrderRepository.findAll();
	}//getUserOrder

	public UserOrder getUserOrder(Long id) {
		return userOrderRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("La orden con el id " + id + " no existe.") );
	}//getUserOrder

	public UserOrder deleteUserOrder(Long id) {
		UserOrder tmpOrder = null;
		if(userOrderRepository.existsById(id)) {
			tmpOrder = userOrderRepository.findById(id).get();
			userOrderRepository.deleteById(id);
		}
		return tmpOrder;
	}//deleteUserOrder

	public UserOrder addUserOrder(UserOrder order) {
		ZonedDateTime timestamp =  ZonedDateTime.now(ZoneId.systemDefault());
		order.setDateUserOrder(timestamp);
		userOrderRepository.save(order);
		return order;
	}//addUserOrder
	
}//UserOrderService
