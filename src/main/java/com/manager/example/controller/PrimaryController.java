package com.manager.example.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manager.example.shareModel.Designations;
import com.manager.inventory.entity.Employee;
import com.manager.inventory.services.CustomerService;
import com.manager.inventory.services.EmployeeService;
import com.manager.security.entity.Role;
import com.manager.security.entity.User;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.security.services.MyUserDetailsService;
import com.manager.security.services.RoleService;

@Controller
public class PrimaryController {
	
	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
	@Autowired
	MyUserDetailsService userService;
	@Autowired
	CustomerService customerService;
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value= {"/"})	
	public ModelAndView firstPage(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("common/firstPage");
		return view;
	}
	
	@RequestMapping(value={"/dashboard"})
	public ModelAndView dashboard(ModelMap map,HttpSession session) {
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView view = view = new ModelAndView("common/dashboard");;
		if(userDetails.getUserType() == 1) {
			view = new ModelAndView("common/customer-dashboard");
		}else {
			view = new ModelAndView("common/dashboard");
		}
		
		return view;
	}
	
	@RequestMapping(value={"/request-for-connection"})
	public ModelAndView requestForConnection(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("common/request-for-connection");
		
		return view;
	}
	
	@RequestMapping(value={"/profile"})
	public ModelAndView profile(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("common/profile");
		
		return view;
	}
	
	@RequestMapping(value={"/support/complain"})
	public ModelAndView complain(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("common/complain");
		
		return view;
	}
	
	@RequestMapping(value= {"/registerNewUser"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> registerNewUser(User user) {
		Map<String, Object> obj = new HashMap();
		user.setEntryTime(new Timestamp(new Date().getTime()));
		user.setEntryBy(1);
		user.setPassword(bCrypt.encode(user.getPassword()));
		
		
		//user.setRole(user.getUserType()==1?"ROLE_CUSTOMER":"ROLE_EMPLOYE");
		if(user.getUserType() == 1) {
			if(customerService.findByCustomerId(user.getMemberId()) != null) {
				if(userService.findByMemberId(user.getMemberId())==null) {
					user.setUserRole("ROLE_CUSROMER");
					obj.put("user", userService.saveUser(user));
					obj.put("result","success");
				}else {
					obj.put("result","something worng");
					obj.put("message","This Customer Already Have an Account");
				}
			}else {
				obj.put("result","something worng");
				obj.put("message","Customer ID is Invalid");
			}
		}else if(user.getUserType() == 2) {
			Employee employee = employeeService.findByEmployeeId(user.getMemberId());
			if(employee != null) {
				if(userService.findByMemberId(user.getMemberId())==null) {
					String role = "ROLE_"+Designations.values()[employee.getDesignation()-1].name();
					user.setUserRole(role);
					obj.put("user", userService.saveUser(user));
					obj.put("result","success");
				}else {
					obj.put("result","something worng");
					obj.put("message","This Customer Already Have an Account");
				}
			}else {
				obj.put("result","something worng");
				obj.put("message","Employee ID is Invalid");
			}
		}
		
		
		
		return obj;
	}
	
	
	
}
