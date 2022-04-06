package com.impuls8.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idProduct", unique=true, nullable=false)
    
	private Long idProduct;
	private String nameProduct;
	private String descriptionProduct;
	private String productPicture;
	private double priceProduct;
	@Column(name="Category_idCategory", unique=true, nullable=false)
	private int idCategory;
	public Product(String nameProduct, String descriptionProduct, String productPicture, double priceProduct,
			 int idCategory) {
		super();
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.productPicture = productPicture;
		this.priceProduct = priceProduct;
		this.idProduct = idProduct;
		this.idCategory = idCategory;
	}
	
	public Product() {
		
	}//constructor
	
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getDescriptionProduct() {
		return descriptionProduct;
	}
	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}
	public String getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}
	public double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public Long getIdProduct() {
		return idProduct;
	}
	
	@Override
	public String toString() {
		return "Product [nameProduct=" + nameProduct + ", descriptionProduct=" + descriptionProduct
				+ ", productPicture=" + productPicture + ", priceProduct=" + priceProduct + ", idProduct=" + idProduct
				+ ", idCategory=" + idCategory + "]";
	}//toString
	
}//Product
