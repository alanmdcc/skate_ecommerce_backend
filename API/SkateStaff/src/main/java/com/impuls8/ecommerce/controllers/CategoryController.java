package com.impuls8.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impuls8.ecommerce.models.Category;
import com.impuls8.ecommerce.service.CategoryService;

@RestController
@RequestMapping (path="/api/category/")
@CrossOrigin(origins="*")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}//constructor

	@GetMapping
	public List<Category> getCategories(){
		return categoryService.getCategories();
		
	}//getUsuarios

}
