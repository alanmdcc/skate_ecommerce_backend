package com.impuls8.ecommerce.models;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userorder")
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUserOrder", unique=true, nullable=false)
	private Long idUserOrder;
	private ZonedDateTime dateUserOrder;
	private Long User_idUser;
	
	@OneToMany(mappedBy="orderProductQuantityId.UserOrder_idUserOrder")
	private Set<OrderProductQuantity> orderProductQuantity;
	
	public UserOrder(Long idUserOrder, ZonedDateTime dateUserOrder, Long User_idUser) {
		super();
		this.idUserOrder = idUserOrder;
		this.dateUserOrder = dateUserOrder;
		this.User_idUser = User_idUser;
	}//constructor
	
	public UserOrder() {}//constructor vacío

	public Long getIdUserOrder() {
		return idUserOrder;
	}

	public void setIdUserOrder(Long idUserOrder) {
		this.idUserOrder = idUserOrder;
	}

	public ZonedDateTime getDateUserOrder() {
		return dateUserOrder;
	}

	public void setDateUserOrder(ZonedDateTime dateUserOrder) {
		this.dateUserOrder = dateUserOrder;
	}

	public Long getUser_idUser() {
		return User_idUser;
	}

	public void setUser_idUser(Long user_idUser) {
		User_idUser = user_idUser;
	}

	@Override
	public String toString() {
		return "UserOrder [idUserOrder=" + idUserOrder + ", dateUserOrder=" + dateUserOrder + ", User_idUser="
				+ User_idUser + "]";
	}

	
}//class UserOrder
