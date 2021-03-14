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
import com.manager.store.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findByCategoryId(Long categoryId);
	public List<Product> findByActiveStatus(int activeStatus);
	public Product findByProductName(String productName);
	public Product findByProductNameAndIdNot(String productName,long id);
	
	
}