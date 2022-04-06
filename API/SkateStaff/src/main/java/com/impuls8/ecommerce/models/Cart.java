package com.impuls8.ecommerce.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productcart")
public class Cart {
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProduct")
	private Product product;

	public Cart(int quantity, User user, Product product) {
		this.quantity = quantity;
		this.user = user;
		this.product = product;
	}//Constructor

	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + ", user=" + user + ", product=" + product + "]";
	}
	
}

