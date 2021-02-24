package com.manager.example.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Employee;
import com.manager.inventory.services.CustomerService;
import com.manager.inventory.services.EmployeeService;
import com.manager.security.entity.Role;
import com.manager.security.entityModel.MyUserDetails;

@Controller
public class InventoryController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value={"/inventory/customer"})
	public ModelAndView customer(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("inventory/customer");
		map.addAttribute("maxId",customerService.getMaxCustomerId());
		map.addAttribute("customerList",customerService.getCustomerList());
		
		return view;
	}
	
	@RequestMapping(value= {"/saveCustomer"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveCustomer(Customer customer) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		customer.setCustomerId(customerService.getMaxCustomerId());
		customer.setEntryTime(new Timestamp(new Date().getTime()));
		customer.setEntryBy(userDetails.getId());
		obj.put("result", customerService.saveCustomer(customer));
		obj.put("customerList",customerService.getCustomerList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/editCustomer"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editCustomer(Customer customer) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		customer.setEntryTime(new Timestamp(new Date().getTime()));
		customer.setEntryBy(userDetails.getId());
		obj.put("result", customerService.saveCustomer(customer));
		obj.put("customerList",customerService.getCustomerList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/getCustomer"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getCustomer(String id){
		Map<String, Object> obj = new HashMap();
		obj.put("customerInfo",customerService.findById(Long.valueOf(id)));
		return obj;
	}
	
	@RequestMapping(value={"/inventory/employee"})
	public ModelAndView employee(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("inventory/employee");
		map.addAttribute("maxId",employeeService.getMaxEmployeeId());
		map.addAttribute("employeeList",employeeService.getEmployeeList());
		
		return view;
	}
	
	@RequestMapping(value= {"/saveEmployee"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveEmployee(Employee employee) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		employee.setEmployeeId(employeeService.getMaxEmployeeId());
		employee.setEntryTime(new Timestamp(new Date().getTime()));
		employee.setEntryBy(userDetails.getId());
		obj.put("result", employeeService.saveEmployee(employee));
		obj.put("employeeList",employeeService.getEmployeeList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/editEmployee"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editEmployee(Employee employee) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		employee.setEntryTime(new Timestamp(new Date().getTime()));
		employee.setEntryBy(userDetails.getId());
		obj.put("result", employeeService.saveEmployee(employee));
		obj.put("employeeList",employeeService.getEmployeeList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/getEmployee"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getEmployee(String id){
		Map<String, Object> obj = new HashMap();
		obj.put("employeeInfo",employeeService.findById(Long.valueOf(id)));
		return obj;
	}
	
	@RequestMapping(value={"/inventory/reseller-information"})
	public ModelAndView reseller_information(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("inventory/reseller-information");
		map.addAttribute("maxId",customerService.getMaxCustomerId());
		map.addAttribute("customerList",customerService.getCustomerList());
		
		return view;
	}
	
	
	@RequestMapping(value={"/inventory/service-create"})
	public ModelAndView service_create(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("inventory/service-create");
		map.addAttribute("maxId",customerService.getMaxCustomerId());
		map.addAttribute("customerList",customerService.getCustomerList());
		
		return view;
	}
	
}
