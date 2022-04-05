package com.impuls8.ecommerce.embeddedId;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductQuantityId implements Serializable{
	private Long UserOrder_idUserOrder;
	private Long Product_idProduct;
	
	public OrderProductQuantityId(Long userOrder_idUserOrder, Long product_idProduct) {
		super();
		UserOrder_idUserOrder = userOrder_idUserOrder;
		Product_idProduct = product_idProduct;
	}
	
	public OrderProductQuantityId() {}//constructor vacío

	public Long getUserOrder_idUserOrder() {
		return UserOrder_idUserOrder;
	}

	public void setUserOrder_idUserOrder(Long userOrder_idUserOrder) {
		UserOrder_idUserOrder = userOrder_idUserOrder;
	}

	public Long getProduct_idProduct() {
		return Product_idProduct;
	}

	public void setProduct_idProduct(Long product_idProduct) {
		Product_idProduct = product_idProduct;
	}

	@Override
	public String toString() {
		return "OrderProductQuantityId [UserOrder_idUserOrder=" + UserOrder_idUserOrder + ", Product_idProduct="
				+ Product_idProduct + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Product_idProduct, UserOrder_idUserOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductQuantityId other = (OrderProductQuantityId) obj;
		return Objects.equals(Product_idProduct, other.Product_idProduct)
				&& Objects.equals(UserOrder_idUserOrder, other.UserOrder_idUserOrder);
	}
	
}//OrderProductQuantityId
