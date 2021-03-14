package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {

	//daily_work_report
			@RequestMapping(value={"/report/daily-work-report"})
			public ModelAndView daily_work_report(ModelMap map,HttpSession session) {

				ModelAndView view = new ModelAndView("report/daily-work-report");
				//map.addAttribute("maxId",customerService.getMaxCustomerId());
				//map.addAttribute("customerList",customerService.getCustomerList());

				return view;
			}
			
			//Sales Report
			@RequestMapping(value={"/report/sales-report"})
			public ModelAndView sales_report(ModelMap map,HttpSession session) {

				ModelAndView view = new ModelAndView("report/sales-report");
				//map.addAttribute("maxId",customerService.getMaxCustomerId());
				//map.addAttribute("customerList",customerService.getCustomerList());

				return view;
			}
			
			//Activation Report
			@RequestMapping(value={"/report/activation-report"})
			public ModelAndView activation_report(ModelMap map,HttpSession session) {

				ModelAndView view = new ModelAndView("report/activation-report");
				//map.addAttribute("maxId",customerService.getMaxCustomerId());
				//map.addAttribute("customerList",customerService.getCustomerList());

				return view;
			}
			
			//Transaction Report
			@RequestMapping(value={"/report/transaction-report"})
			public ModelAndView transaction_report(ModelMap map,HttpSession session) {

				ModelAndView view = new ModelAndView("report/transaction-report");
				//map.addAttribute("maxId",customerService.getMaxCustomerId());
				//map.addAttribute("customerList",customerService.getCustomerList());

				return view;
			}
}
