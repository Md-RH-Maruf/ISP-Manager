package com.manager.inventory.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.manager.inventory.entity.Customer;
import com.manager.inventory.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	DecimalFormat df = new DecimalFormat("00");
	public String getMaxCustomerId() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "CM-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+customerRepo.findCustomerId(yearMonth);
	}
	
	public Customer saveCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	public Customer findById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}
	
	public Customer findByCustomerId(String customerId) {
		return customerRepo.findByCustomerId(customerId);
	}
	
	public List<Customer> getCustomerList(){
		return customerRepo.findAll();
	}
}
