package com.impuls8.ecommerce.products;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/products/")//requesmapping crea una ruta para todos los metodos (get, post, delete...)
@CrossOrigin(origins="*")//corssorigin otorga permisos a la url especificada para acceder


public class ProductController {

	private ProductService productService;
	//inyección de dependencias
	
	@Autowired//autowired ejecuta el constructor una sola vez
	public ProductController(ProductService productService) {
		this.productService=productService;
	}//constructor
	
	@GetMapping
	public ArrayList<Product>getProducts() {
		
    return productService.getProducts();

	}//getProducts
	
	@GetMapping(path="{prodId}")//se especifica que la ruta contendrá un id de product
	public Product getProduct(@PathVariable("prodId") Long prodId) {
		return productService.getProduct(prodId);	
	}//getProduct
	
	@DeleteMapping
	public Product deleteProduct(@PathVariable("prodId") Long prodId) {
		return productService.deleteProduct(prodId);
	}//deleteProduct
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}//addProduct
	
	@PutMapping(path="{prodId}")
	public Product updateProduct(@PathVariable("prodId") Long prodId,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String URL_imagen,
			@RequestParam(required=false) double precio) {
			return productService.udpateProduct(prodId,nombre,descripcion,URL_imagen,precio);
	}//deleteProduct
}//class
