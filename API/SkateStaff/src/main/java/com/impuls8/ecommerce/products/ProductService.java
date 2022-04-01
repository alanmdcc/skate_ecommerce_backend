package com.impuls8.ecommerce.products;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.products.Product;

@Service
public class ProductService {

public final ArrayList<Product> lista= new ArrayList<Product>();
	
	public ProductService() {
		lista.add(		
				 new Product("Skate Alien Invasion", 
						"Skate con diseño de alien", 
						"alien.jpg", 1500, 1)
				);
				lista.add( new Product("Skate Octopus", 
						"Skate con diseño de pulpo", 
						"octopus.jpg", 1700, 2)
						);
				lista.add( new Product("Orange Pennyboard", 
						"Skate de color naranja", 
						"orangePenny.jpg", 1300, 1)
						);
	}//constructor

	public ArrayList<Product> getProducts() {
		return lista;
	}//getProducts

	public Product getProduct(Long prodId) {
	   Product tmpProd =null;
		for (Product product : lista) {
			if(product.getIdProduct()==prodId) {
				tmpProd=product;
				break;
			}//if
		}//foreach	
		return tmpProd;
	}//getProduct

	public Product deleteProduct(Long prodId) {
		Product tmpProd =null;
		for (Product product : lista) {
			if(product.getIdProduct()==prodId) {
				lista.remove(lista.indexOf(product));
				break;
			}//if
		}//foreach	
		return tmpProd;
	}//deleteProduct
	
	public Product udpateProduct(Long prodId, String nombre, String descripcion, String uRL_imagen, double precio) {
		Product tmpProd = null;
		for (Product product : lista) {
			if(product.getIdProduct()==prodId) {
				if(nombre != null) product.setNameProduct(nombre);
				if(descripcion != null) product.setDescriptionProduct(descripcion);
				if(uRL_imagen != null) product.setProductPicture(uRL_imagen);
				if(precio>0) product.setPriceProduct(precio);
				tmpProd = product; 
				break;
			}//if==prodId
		}//for each
		return tmpProd;
	}//updateProduct


	public Product addProduct(Product product) {
		lista.add(product);
		return product;
	}//addProduct

}
