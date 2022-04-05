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
	private Long Usuario_idUser;
	
	@OneToMany(mappedBy="orderProductQuantityId.UserOrder_idUserOrder")
	private Set<OrderProductQuantity> orderProductQuantity;
	
	public UserOrder(Long idUserOrder, ZonedDateTime dateUserOrder, Long Usuario_idUser) {
		super();
		this.idUserOrder = idUserOrder;
		this.dateUserOrder = dateUserOrder;
		this.Usuario_idUser = Usuario_idUser;
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

	public Long getUsuario_idUser() {
		return Usuario_idUser;
	}

	public void setUsuario_idUser(Long usuario_idUser) {
		Usuario_idUser = usuario_idUser;
	}

	@Override
	public String toString() {
		return "UserOrder [idUserOrder=" + idUserOrder + ", dateUserOrder=" + dateUserOrder + ", Usuario_idUser="
				+ Usuario_idUser + "]";
	}

	
}//class UserOrder
