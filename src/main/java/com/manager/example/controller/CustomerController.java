package com.manager.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.accounts.service.BillService;
import com.manager.example.shareModel.BillType;
import com.manager.example.shareModel.Status;
import com.manager.inventory.services.CustomerService;
import com.manager.inventory.services.EmployeeService;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.support.services.ComplainTMSService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService CustomerService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ComplainTMSService complainService;
	@Autowired
	BillService billService;
	
	//Complain TMS
		@RequestMapping(value={"/customer/complain-ticket"})
		public ModelAndView complain_ticket(ModelMap map,HttpSession session) {
			//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView view = new ModelAndView("customer/complain-tms");
			if(userDetails.getUserType() == 1) {
				
			}else {
				
			}
			map.addAttribute("userId",userDetails.getId());
			map.addAttribute("memberId",userDetails.getMemberId());
			map.addAttribute("userName",userDetails.getUsername());
			//map.addAttribute("resourceList",resourceService.getResourceList());
			return view;
		}
		
		@RequestMapping(value={"/customer/complain-ticket-list/{customerId}"})
		public ModelAndView complain_ticket_list(ModelMap map,HttpSession session,@PathVariable("customerId")String customerId) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView view = new ModelAndView("customer/complain-ticket-list");
			map.addAttribute("ticketList",complainService.getTicketListByCustomerId(customerId));
			//map.addAttribute("processingTicketList",complainService.getTicketListByStatus(Status.PROCESSING.name()));
			//map.addAttribute("closedTicketList",complainService.getTicketListByStatus(Status.CLOSED.name()));
			//map.addAttribute("deletedTicketList",complainService.getTicketListByStatus(Status.DELETED.name()));
			return view;
		}
		
		@RequestMapping(value={"/customer/payment-history"})
		public ModelAndView payment_history(ModelMap map,HttpSession session) {
			//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView view = new ModelAndView("customer/payment-history");
			
			map.addAttribute("userId",userDetails.getId());
			map.addAttribute("memberId",userDetails.getMemberId());
			map.addAttribute("userName",userDetails.getUsername());
			map.addAttribute("billList",billService.getBillsBillTypeAndCustomerId(BillType.Monthly_Invoice.getType(), userDetails.getMemberId()));
			//map.addAttribute("resourceList",resourceService.getResourceList());
			return view;
		}
		
		@RequestMapping(value={"/customer/invoices"})
		public ModelAndView invoices(ModelMap map,HttpSession session) {
			//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView view = new ModelAndView("customer/monthly-invoice");
			if(userDetails.getUserType() == 1) {
				
			}else {
				
			}
			map.addAttribute("userId",userDetails.getId());
			map.addAttribute("memberId",userDetails.getMemberId());
			map.addAttribute("userName",userDetails.getUsername());
			//map.addAttribute("resourceList",resourceService.getResourceList());
			return view;
		}
		
		@RequestMapping(value={"/customer/online-payment"})
		public ModelAndView online_payment(ModelMap map,HttpSession session) {
			//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView view = new ModelAndView("customer/online-payment");
			
			map.addAttribute("userId",userDetails.getId());
			map.addAttribute("memberId",userDetails.getMemberId());
			map.addAttribute("userName",userDetails.getUsername());
			//map.addAttribute("resourceList",resourceService.getResourceList());
			return view;
		}
}
