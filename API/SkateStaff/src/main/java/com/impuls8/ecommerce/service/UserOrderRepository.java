package com.impuls8.ecommerce.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impuls8.ecommerce.models.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long>{

}//UserOrderRepository
