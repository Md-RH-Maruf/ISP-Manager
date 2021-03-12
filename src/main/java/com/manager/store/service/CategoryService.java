package com.manager.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.store.entity.Category;
import com.manager.store.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public Category saveCategory(Category category) {
		
		return categoryRepo.save(category);
	}
	
	public Category findByCategoryName(String categoryName) {
		return categoryRepo.findByCategoryName(categoryName);
	}
	
	public List<Category> findByParentsId(String parentsId) {
		return categoryRepo.findByParentsId(Long.valueOf(parentsId));
	}
	
	public List<Category> getCategoryListOrderByParentsId(){
		return categoryRepo.findByOrderByParentsIdAsc();
	}
	
	public List<Category> getCategoryList(){
		return categoryRepo.findAll();
	}
	
	public Category findById(long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public boolean isCategoryExist(String categoryName,long id) {
		if(categoryRepo.findByCategoryNameAndIdNot(categoryName, id) != null) {
			return true;
		}
		
		return false;
	}
}
