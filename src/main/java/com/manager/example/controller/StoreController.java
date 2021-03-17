package com.manager.example.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
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
import com.manager.store.entity.Product;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionProductDetails;
import com.manager.store.service.CategoryService;
import com.manager.store.service.ProductRequisitionService;
import com.manager.store.service.ProductService;
import com.manager.store.service.RequisitionProductDetailsService;

@Controller
public class StoreController {

		@Autowired
		CategoryService categoryService;
		
		@Autowired
		ProductService productService;
		
		@Autowired
		ProductRequisitionService productReqService;
		@Autowired
		RequisitionProductDetailsService requistionProductDetailsService;
	//Create Product
		@RequestMapping(value={"/store/create-product"})
		public ModelAndView service_create(ModelMap map,HttpSession session) {

			ModelAndView view = new ModelAndView("store/product-create");
			map.addAttribute("categoryList",categoryService.getCategoryList());
			map.addAttribute("productList",productService.getProductList());
			//map.addAttribute("customerList",customerService.getCustomerList());

			return view;
		}
		
		@RequestMapping(value= {"/saveCategory"},method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> saveCategory(Category category) {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(!categoryService.isCategoryExist(category.getCategoryName(), 0)) {
				category.setEntryTime(new Timestamp(new Date().getTime()));
				category.setEntryBy(userDetails.getId());
				obj.put("result", categoryService.saveCategory(category));
				obj.put("categoryList",categoryService.getCategoryListOrderByParentsId());
			}else {
				obj.put("result", "duplicate");
			}
			
			return obj;
		}
		
		@RequestMapping(value= {"/editCategory"},method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> editCategory(Category category) {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!categoryService.isCategoryExist(category.getCategoryName(), category.getId())) {
				category.setEntryTime(new Timestamp(new Date().getTime()));
				category.setEntryBy(userDetails.getId());
				obj.put("result", categoryService.saveCategory(category));
				obj.put("categoryList",categoryService.getCategoryListOrderByParentsId());
			}else {
				obj.put("result", "duplicate");
			}
			
			
			return obj;
		}
		
		@RequestMapping(value= {"/getCatgoryList"},method=RequestMethod.GET)
		public @ResponseBody Map<String, Object> getCatgoryList() {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			obj.put("categoryList",categoryService.getCategoryListOrderByParentsId());
			return obj;
		}
		
		@RequestMapping(value= {"/saveProduct"},method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> saveProduct(Product product) {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!productService.isProductExist(product.getProductName(), 0)) {
				product.setEntryTime(new Timestamp(new Date().getTime()));
				product.setEntryBy(userDetails.getId());
				obj.put("result", productService.saveProduct(product));
				obj.put("productList",productService.getProductList());
			}else {
				obj.put("result", "duplicate");
			}
			
			return obj;
		}
		
		@RequestMapping(value= {"/editProduct"},method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> editProduct(Product product) {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!productService.isProductExist(product.getProductName(), product.getId())) {
				product.setEntryTime(new Timestamp(new Date().getTime()));
				product.setEntryBy(userDetails.getId());
				obj.put("result", productService.saveProduct(product));
				obj.put("productList",productService.getProductList());
			}else {
				obj.put("result", "duplicate");
			}
			
			return obj;
		}
		
		@RequestMapping(value= {"/getProductInfo"},method=RequestMethod.GET)
		public @ResponseBody Map<String, Object> getProductInfo(String productId) {
			Map<String, Object> obj = new HashMap();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			obj.put("productInfo",productService.findById(Long.valueOf(productId)));
			return obj;
		}
		
		//create product requisition
				@RequestMapping(value={"/store/create-product-requisition"})
				public ModelAndView createProductRequisition(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-requisition");
					
					map.addAttribute("maxReqNo",productReqService.getMaxRequisitionNo());
					map.addAttribute("productList",productService.getProductList());

					return view;
				}
				
				@RequestMapping(value= {"/submitProductRequisition"},method=RequestMethod.POST)
				public @ResponseBody Map<String, Object> submitProductRequisition(ProductRequisition productRequisition,String productsString) {
					Map<String, Object> obj = new HashMap();
					MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					List<RequisitionProductDetails> requisitionProductList = new ArrayList<RequisitionProductDetails>() ;
					
					productRequisition.setEntryTime(new Timestamp(new Date().getTime()));
					productRequisition.setEntryBy(userDetails.getId());
					JSONObject products = new JSONObject(productsString);
					System.out.println("list"+products.toString());
					JSONArray productList = products.getJSONArray("list");
					for(Object object: productList) {
						JSONObject jObject = (JSONObject) object;
						RequisitionProductDetails reqDetail = new RequisitionProductDetails();
						reqDetail.setRequisitionNo(productRequisition.getRequisitionNo());
						reqDetail.setProductId(jObject.getInt("productId"));
						reqDetail.setProductQuantity(jObject.getInt("quantity"));
						reqDetail.setDescription(jObject.getString("description"));
						reqDetail.setEntryTime(new Timestamp(new Date().getTime()));
						reqDetail.setEntryBy(userDetails.getId());
						requisitionProductList.add(reqDetail);
					}
					
					if(productReqService.saveProductRequisition(productRequisition) != null) {
						if(requistionProductDetailsService.saveRequisitionProducts(requisitionProductList) != null) {
							obj.put("result", "duplicate");
						}else {
							obj.put("result", "successfull");
						}
						
					}else {
						obj.put("result", "something wrong");
					}
					
					return obj;
				}
				
				//purchase product
				@RequestMapping(value={"/store/purchase-product"})
				public ModelAndView purchaseProuduct(ModelMap map,HttpSession session) {

					ModelAndView view = new ModelAndView("store/product-purchase");
					map.addAttribute("productList",productService.getProductList());
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
