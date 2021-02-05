package com.manager.inventory.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.inventory.entity.Employee;
import com.manager.inventory.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	DecimalFormat df = new DecimalFormat("00");
	public String getMaxEmployeeId() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "EM-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+employeeRepo.getMaxEmployeeId(yearMonth);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee findById(Long id) {
		return employeeRepo.findById(id).orElse(null);
	}
	
	public Employee findByEmployeeId(String employeeId) {
		return employeeRepo.findByEmployeeId(employeeId);
	}
	
	public List<Employee> getEmployeeList(){
		return employeeRepo.findAll();
	}
}
