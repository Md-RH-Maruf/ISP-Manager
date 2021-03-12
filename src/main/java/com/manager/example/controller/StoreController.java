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

import com.manager.security.entityModel.MyUserDetails;
import com.manager.store.entity.Category;
import com.manager.store.service.CategoryService;
import com.manager.support.entity.McInformation;

@Controller
public class StoreController {

		@Autowired
		CategoryService categoryService;
	
	//Create Product
		@RequestMapping(value={"/store/create-product"})
		public ModelAndView service_create(ModelMap map,HttpSession session) {

			ModelAndView view = new ModelAndView("store/product-create");
			map.addAttribute("categoryList",categoryService.getCategoryList());
			//map.addAttribute("customerList",customerService.getCustomerList());

			return view;
		}
		
		@RequestMapping(value= {"/saveCategory"},method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> saveCategory(Category category) {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			category.setEntryTime(new Timestamp(new Date().getTime()));
			category.setEntryBy(userDetails.getId());
			obj.put("result", categoryService.saveCategory(category));
			obj.put("categoryList",categoryService.getCategoryList());
			return obj;
		}
		
		@RequestMapping(value= {"/getCatgoryList"},method=RequestMethod.GET)
		public @ResponseBody Map<String, Object> getCatgoryList() {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			obj.put("categoryList",categoryService.getCategoryListOrderByParentsId());
			return obj;
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
