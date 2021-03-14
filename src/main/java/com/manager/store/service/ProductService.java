package com.manager.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.store.entity.Category;
import com.manager.store.entity.Product;
import com.manager.store.repository.CategoryRepository;
import com.manager.store.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}
	
	public Product findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}
	
	public List<Product> findByCategoryId(String categoryId) {
		return productRepo.findByCategoryId(Long.valueOf(categoryId));
	}
	
	public List<Product> getProductListByActiveStatus(String activeStatus){
		return productRepo.findByActiveStatus(Integer.valueOf(activeStatus));
	}
	
	public List<Product> getProductList(){
		return productRepo.findAll();
	}
	
	public Product findById(long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public boolean isProductExist(String productName,long id) {
		if(productRepo.findByProductNameAndIdNot(productName, id) != null) {
			return true;
		}
		
		return false;
	}
}
