package com.manager.example.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.manager.security.entity.Resource;
import com.manager.security.entity.ResourceRole;
import com.manager.security.entity.Role;
import com.manager.security.entity.User;
import com.manager.security.entity.UsersRoles;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.security.services.MyUserDetailsService;
import com.manager.security.services.ResourceRoleService;
import com.manager.security.services.ResourceService;
import com.manager.security.services.RoleService;
import com.manager.security.services.UsersRolesService;

@Controller
public class SettingController {
	
	@Autowired
	MyUserDetailsService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	ResourceRoleService resourceRoleService;
	@Autowired
	UsersRolesService usersRolesService;
	
	
	@RequestMapping(value={"/user-authentication-management"})
	public ModelAndView userAuthenticationManagement(ModelMap map,HttpSession session) {
		
		ModelAndView view = new ModelAndView("setting/user-authentication-management");
		map.addAttribute("userList",userService.getUserList());
		
		return view;
	}
	
	@RequestMapping(value= {"/getUserEmployeeInfo"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getUserEmployeeInfo(String userId) {
		Map<String, Object> obj = new HashMap();
		User user = userService.findById(Long.valueOf(userId));
		List<UsersRoles> roleList = usersRolesService.findByUserId(user.getId());
		
		//obj.put("userInfo",new UserAuthModel(user.getId(), user.getMemberId(), user.getUsername(), user.getUserType(), firstName, lastName, email, contactNo, designation, enabled, userRoles));
		obj.put("roleList",roleList);
		
		return obj;
	}
	
	@RequestMapping(value={"/role-management"})
	public ModelAndView roleManagement(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("setting/role-management");
		map.addAttribute("roleList",roleService.getRoleList());
		map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	@RequestMapping(value= {"/saveRole"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveRole(Role role) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		role.setEntryTime(new Timestamp(new Date().getTime()));
		role.setEntryBy(userDetails.getId());
		obj.put("result", roleService.saveRole(role));
		obj.put("roleList",roleService.getRoleList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/editRole"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editRole(Role role) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//role.setEntryTime(new Timestamp(new Date().getTime()));
		role.setEntryBy(userDetails.getId());
		role.setEntryTime(roleService.findRole(role.getId()).getEntryTime());
		obj.put("result", roleService.saveRole(role));
		obj.put("roleList",roleService.getRoleList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/saveResource"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveResource(Resource resource) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		resource.setEntryTime(new Timestamp(new Date().getTime()));
		resource.setEntryBy(userDetails.getId());
		obj.put("result", resourceService.saveResource(resource));
		obj.put("resourceList",resourceService.getResourceList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/editResource"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editResource(Resource resource) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		resource.setEntryTime(resourceService.findResource(resource.getId()).getEntryTime());
		resource.setEntryBy(userDetails.getId());
		obj.put("result", resourceService.saveResource(resource));
		obj.put("resourceList",resourceService.getResourceList());
		
		return obj;
	}
	
	@RequestMapping(value= {"/addResourceRole"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addResourceRole(ResourceRole resourceRole) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		resourceRole.setEntryTime(new Timestamp(new Date().getTime()));
		resourceRole.setEntryBy(userDetails.getId());
		obj.put("result", resourceRoleService.saveResourceRole(resourceRole));
		//obj.put("resourceRoleList",resourceRoleService.findByRoleId(resourceRole.getRoleId()));
		obj.put("resourceRoleDetails",resourceRoleService.getResourceRoleDetailsListByRoleId(resourceRole.getRoleId()));
		return obj;
	}
	
	@RequestMapping(value= {"/editResourceRole"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editResourceRole(ResourceRole resourceRole) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		resourceRole.setEntryTime(new Timestamp(new Date().getTime()));
		resourceRole.setEntryBy(userDetails.getId());
		obj.put("result", resourceRoleService.saveResourceRole(resourceRole));
		//obj.put("resourceRoleList",resourceRoleService.findByRoleId(resourceRole.getRoleId()));
		obj.put("resourceRoleDetails",resourceRoleService.getResourceRoleDetailsListByRoleId(resourceRole.getRoleId()));
		return obj;
	}
	
	@RequestMapping(value= {"/deleteResourceRole"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteResourceRole(ResourceRole resourceRole) {
		Map<String, Object> obj = new HashMap();
		resourceRoleService.deleteById(resourceRole.getId());
		//obj.put("resourceRoleList",resourceRoleService.findByRoleId(resourceRole.getRoleId()));
		obj.put("resourceRoleDetails",resourceRoleService.getResourceRoleDetailsListByRoleId(resourceRole.getRoleId()));
		return obj;
	}
	
	@RequestMapping(value= {"/getResourceRoleDetails"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getResourceRoleDetails(String roleId){
		Map<String, Object> obj = new HashMap();
		obj.put("resourceRoleDetails",resourceRoleService.getResourceRoleDetailsListByRoleId(Long.valueOf(roleId)));
		return obj;
	}
	
}
