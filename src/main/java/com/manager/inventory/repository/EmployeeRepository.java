package com.manager.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.inventory.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByEmployeeId(String employeeId);
	
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(employee_Id,10) AS signed )),0)+1) AS Id FROM tb_employee_info WHERE employee_Id LIKE ?1%", nativeQuery = true)
	public String getMaxEmployeeId(String yearMonth);
}
