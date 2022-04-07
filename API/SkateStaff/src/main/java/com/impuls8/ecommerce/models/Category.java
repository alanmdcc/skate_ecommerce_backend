package com.impuls8.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCategory", unique=true, nullable=false)
	private Long idCategory;
	private String categoryName;
	
//	@OneToMany(mappedBy="idProduct")
//	private Set<Product> product;
	
	public Category() {	}//constructor vacío

	public Category(Long idCategory, String categoryName) {
		super();
		this.idCategory = idCategory;
		this.categoryName = categoryName;
	}//constructor

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", categoryName=" + categoryName + "]";
	}//toString
	
	

}//class Category
