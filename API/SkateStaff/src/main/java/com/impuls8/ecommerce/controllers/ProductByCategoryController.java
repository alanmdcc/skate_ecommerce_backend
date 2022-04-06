package com.impuls8.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.Product;
import com.impuls8.ecommerce.service.ProductService;

@RestController
@RequestMapping (path="/api/products/category/")
@CrossOrigin(origins="*")
public class ProductByCategoryController {

	private final ProductService productService;
	
	@Autowired
	public ProductByCategoryController(ProductService productService) {
		this.productService=productService;
	}//constructor
	
	@GetMapping(path="{category}")
	public List<Product> getProductsByCategory(@PathVariable("category") Long category) {
		return productService.getProductsByCategory(category);	
	}//getProductsByCategory
	
}//ProductByCategoryController