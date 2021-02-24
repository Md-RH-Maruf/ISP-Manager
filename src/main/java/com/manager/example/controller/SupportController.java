package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupportController {

	@RequestMapping(value={"/support/activation-tms"})
	public ModelAndView activation_tms(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/activation-tms");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	
	@RequestMapping(value={"/support/complain-tms"})
	public ModelAndView complain_tms(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/complain-tms");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	@RequestMapping(value={"/support/tms-report-list"})
	public ModelAndView tms_report_list(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/tms-report-list");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	@RequestMapping(value={"/tms-details/{tmsNo}"})
	public ModelAndView tms_details(ModelMap map,HttpSession session,@PathVariable("tmsNo") String tmsNo) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/tms-details");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	@RequestMapping(value={"/support/connection-point"})
	public ModelAndView connection_point(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/connection-point");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	
	@RequestMapping(value={"/support/olt-mc-position"})
	public ModelAndView olt_mc_position(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/olt-mc-position");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
}
