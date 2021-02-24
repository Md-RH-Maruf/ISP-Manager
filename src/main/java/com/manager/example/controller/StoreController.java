package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

	//Create Product
		@RequestMapping(value={"/store/create-product"})
		public ModelAndView service_create(ModelMap map,HttpSession session) {

			ModelAndView view = new ModelAndView("store/product-create");
			//map.addAttribute("maxId",customerService.getMaxCustomerId());
			//map.addAttribute("customerList",customerService.getCustomerList());

			return view;
		}
		
		//create product requisition
				@RequestMapping(value={"/store/create-product-requisition"})
				public ModelAndView createProductRequisition(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-requisition");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
				
				//purchase product
				@RequestMapping(value={"/store/purchase-product"})
				public ModelAndView purchaseProuduct(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-purchase");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
				
				
				//product Requisition List
				@RequestMapping(value={"/store/product-requisition-list"})
				public ModelAndView prouductRequisitionList(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-requisition-list");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
				
				//Issue Product
				@RequestMapping(value={"/store/issue-product"})
				public ModelAndView issueProduct(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/issue-product");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
				
				//product stock
				@RequestMapping(value={"/store/product-stock"})
				public ModelAndView productStock(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-stock");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
				
				
				//product stock
				@RequestMapping(value={"/store/product-transaction"})
				public ModelAndView productTransaction(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-transaction");
					//map.addAttribute("maxId",customerService.getMaxCustomerId());
					//map.addAttribute("customerList",customerService.getCustomerList());

					return view;
				}
}
