package com.impuls8.ecommerce.models;

public class Product {

	private String nameProduct;
	private String descriptionProduct;
	private String productPicture;
	private double priceProduct;
	private int idProduct;
	private int idCategory;
	private static int total=0;
	public Product(String nameProduct, String descriptionProduct, String productPicture, double priceProduct,
			 int idCategory) {
		super();
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.productPicture = productPicture;
		this.priceProduct = priceProduct;
		total++;
		this.idProduct = total;
		this.idCategory = idCategory;
	}
	
	public Product() {
		total++;
		this.idProduct = total;
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
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		Product.total = total;
	}
	public int getIdProduct() {
		return idProduct;
	}
	
	@Override
	public String toString() {
		return "Product [nameProduct=" + nameProduct + ", descriptionProduct=" + descriptionProduct
				+ ", productPicture=" + productPicture + ", priceProduct=" + priceProduct + ", idProduct=" + idProduct
				+ ", idCategory=" + idCategory + "]";
	}//toString
	
}//Product
