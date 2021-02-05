package com.manager.inventory.repository;


import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.inventory.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByCustomerId(String customerId);
	
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(customer_Id,10) AS signed )),0)+1) AS Id FROM Customer WHERE customer_Id LIKE ?1%", nativeQuery = true)
	public String findCustomerId(String yearMonth);
}
