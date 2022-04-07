package com.impuls8.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.impuls8.ecommerce.models.Product;
import com.impuls8.ecommerce.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}//constructor
	
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}//getProducts
	
	public Product getProduct(Long id) {
		
		return productRepository.findById(id).orElseThrow(
				()-> new IllegalStateException ("El product con el id"+ id + "no existe."));
		
	}//getProduct


	public Product deleteProduct(Long id) {
		Product tmpProduct = null;
		if (productRepository.existsById(id)) {
			tmpProduct = productRepository.findById(id).get();
			productRepository.deleteById(id);
		}//exit
		return tmpProduct;
	}//deleteProduct


	public boolean addProduct(Product product) {
		boolean tmpBool = false;
		Optional<Product> prodByName=productRepository.findByNombre(product.getNameProduct());
		if(prodByName.isPresent()) {
//			throw new IllegalStateException("El Product con el nombre [" + product.getNameProduct() + 
//					"] YA existe."); 	
		} else {
			productRepository.save(product);
			tmpBool = true;
		}//else 
		return tmpBool;
	}//addProduct


	


	public Product updateProduct(Long id, String nombre, String descripcion, String uRL_imagen, Double precio) {
		Product tmpProduct=null;
		if (productRepository.existsById(id)) {
			tmpProduct = productRepository.findById(id).get();
			if (nombre!=null)tmpProduct.setNameProduct(nombre);
			if (descripcion!=null)tmpProduct.setDescriptionProduct(descripcion);
			if (uRL_imagen!=null)tmpProduct.setProductPicture(uRL_imagen);
			if (precio!=null && precio.doubleValue()>0) tmpProduct.setPriceProduct(precio.doubleValue());
			productRepository.save(tmpProduct);
		}else {
			System.out.println("No existe el product con el id"+id);
		}//else //if
			
		
		return tmpProduct;
	}


	public List<Product> getProductsByCategory(Long category) {
		return productRepository.findByCategory(category).orElseThrow(
				()-> new IllegalStateException ("El product con el id"+ category + "no existe."));
	}//getProductsBYCategory

	

}//ProductService
