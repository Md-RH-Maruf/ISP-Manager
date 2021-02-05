package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupportController {

	@RequestMapping(value={"/support/activation-tms"})
	public ModelAndView activationTms(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/activation-tms");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	
	@RequestMapping(value={"/support/complain-tms"})
	public ModelAndView complainTms(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/complain-tms");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
}
