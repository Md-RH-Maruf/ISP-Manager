package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value={"/index.html"})
	public ModelAndView home(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/index");
		return view;
	}
	
	@RequestMapping(value="/buttons.html")
	public ModelAndView buttons(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/buttons");
		return view;
	}
	
	@RequestMapping(value="/cards.html")
	public ModelAndView cards(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/cards");
		return view;
	}
	
	@RequestMapping(value="/utilities-color.html")
	public ModelAndView utilitiesColor(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/utilities-color");
		return view;
	}
	
	@RequestMapping(value="/utilities-border.html")
	public ModelAndView utilitiesBorder(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/utilities-border");
		return view;
	}
	
	@RequestMapping(value="/utilities-animation.html")
	public ModelAndView utilitiesAnimation(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/utilities-animation");
		return view;
	}
	
	@RequestMapping(value="/utilities-other.html")
	public ModelAndView utilitiesOther(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/utilities-other");
		return view;
	}

	@RequestMapping(value="/login")
	public ModelAndView login(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/login");
		return view;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/register");
		return view;
	}
	
	@RequestMapping(value="/logout-success")
	public ModelAndView logoutSuccess(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/login");
		return view;
	}
	
	@RequestMapping(value="/forgot-password")
	public ModelAndView forgotPassword(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/forgot-password");
		return view;
	}
	
	@RequestMapping(value="/404.html")
	public ModelAndView erroPage404(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/404");
		return view;
	}
	
	@RequestMapping(value="/blank.html")
	public ModelAndView blank(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/blank");
		return view;
	}
	
	@RequestMapping(value="/charts.html")
	public ModelAndView charts(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/charts");
		return view;
	}
	
	@RequestMapping(value="/tables.html")
	public ModelAndView tables(ModelMap map,HttpSession session) {
		ModelAndView view = new ModelAndView("default/tables");
		return view;
	}
}
