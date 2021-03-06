package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountsController {

	//Create Ledger
	@RequestMapping(value={"/accounts/create-ledger"})
	public ModelAndView service_create(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/ledger-create");
		//map.addAttribute("maxId",customerService.getMaxCustomerId());
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}

	//Create Bill
	@RequestMapping(value={"/accounts/create-bill"})
	public ModelAndView create_bill(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/create-bill");
		//map.addAttribute("maxId",customerService.getMaxCustomerId());
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}


	//Pending Bill
	@RequestMapping(value={"/accounts/pending-bill"})
	public ModelAndView pending_bill(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/pending-bill");
		//map.addAttribute("maxId",customerService.getMaxCustomerId());
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}


	//Approved Bill
	@RequestMapping(value={"/accounts/approved-bill"})
	public ModelAndView approved_bill(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/approved-bill");
		//map.addAttribute("maxId",customerService.getMaxCustomerId());
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}


	//Cash Transaction
	@RequestMapping(value={"/accounts/cash-transaction"})
	public ModelAndView cash_transaction(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/cash-transaction");
		//map.addAttribute("maxId",customerService.getMaxCustomerId());
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}
	
	//Cash Transaction
		@RequestMapping(value={"/accounts/customer-monthly-invoice"})
		public ModelAndView customer_monthly_invoice(ModelMap map,HttpSession session) {

			ModelAndView view = new ModelAndView("accounts/customer-monthly-invoice");
			//map.addAttribute("maxId",customerService.getMaxCustomerId());
			//map.addAttribute("customerList",customerService.getCustomerList());

			return view;
		}
		
		//Customer Bill Info
				@RequestMapping(value={"/accounts/customer-bill-info"})
				public ModelAndView customer_bill_info(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("accounts/customer-bill-info");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
}
