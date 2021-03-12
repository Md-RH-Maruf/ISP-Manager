package com.manager.store.repository;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Service;
import com.manager.store.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	public List<Category> findByParentsId(Long parentsId);
	public List<Category> findByOrderByParentsIdAsc();
	public Category findByCategoryName(String categoryName);
	public Category findByCategoryNameAndIdNot(String category,long id);
	
	
}