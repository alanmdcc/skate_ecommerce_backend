package com.impuls8.ecommerce.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.impuls8.ecommerce.embeddedId.OrderProductQuantityId;

@Entity
@Table(name="OrderProductQuantity")
public class OrderProductQuantity {
	@EmbeddedId
	private OrderProductQuantityId orderProductQuantityId;
	private Long quantity;
	
	@ManyToOne
	@JoinColumn(name="UserOrder_idUserOrder", referencedColumnName="idUserOrder", nullable=false, insertable=false,updatable=false)
	private UserOrder userOrder;
	
//	@ManyToOne
//	@JoinColumn(name="Product_idProduct", referencedColumnName="idProduct", nullable=false, insertable=false,updatable=false)
//	private Product product;
	
	public OrderProductQuantity() {}//constructor vacío

	public OrderProductQuantity(OrderProductQuantityId orderProductQuantityId, Long quantity, UserOrder userOrder) {
		super();
		this.orderProductQuantityId = orderProductQuantityId;
		this.quantity = quantity;
		this.userOrder = userOrder;
	}

	public OrderProductQuantityId getOrderProductQuantityId() {
		return orderProductQuantityId;
	}

	public void setOrderProductQuantityId(OrderProductQuantityId orderProductQuantityId) {
		this.orderProductQuantityId = orderProductQuantityId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@Override
	public String toString() {
		return "OrderProductQuantity [orderProductQuantityId=" + orderProductQuantityId + ", quantity=" + quantity
				+ ", userOrder=" + userOrder + "]";
	}

	
	
		
}//OrderProductQuantity
