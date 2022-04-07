package com.impuls8.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impuls8.ecommerce.models.Category;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}//constructor
	
	
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}//getProducts

}
