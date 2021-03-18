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

import com.manager.accounts.entity.Ledger;
import com.manager.accounts.entity.LedgerHead;
import com.manager.accounts.service.LedgerHeadService;
import com.manager.accounts.service.LedgerService;
import com.manager.security.entityModel.MyUserDetails;


@Controller
public class AccountsController {

	
	@Autowired
	LedgerHeadService ledgerHeadService;
	@Autowired
	LedgerService ledgerService;
	
	//Create Ledger
	@RequestMapping(value={"/accounts/create-ledger"})
	public ModelAndView service_create(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/ledger-create");
		map.addAttribute("ledgerHeadList",ledgerHeadService.getLedgerHeadList());
		map.addAttribute("ledgerList",ledgerService.getLedgerList());

		return view;
	}
	
	@RequestMapping(value= {"/saveLedgerHead"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveLedgerHead(LedgerHead ledgerHead) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(!ledgerHeadService.isLedgerHeadExist(ledgerHead.getHeadName(), 0)) {
			ledgerHead.setEntryTime(new Timestamp(new Date().getTime()));
			ledgerHead.setEntryBy(userDetails.getId());
			obj.put("result", ledgerHeadService.saveLedgerHead(ledgerHead));
			obj.put("ledgerHeadList",ledgerHeadService.getLedgerHeadListOrderByParentId());
		}else {
			obj.put("result", "duplicate");
		}
		
		return obj;
	}
	
	@RequestMapping(value= {"/editLedgerHead"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editLedgerHead(LedgerHead ledgerHead) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!ledgerHeadService.isLedgerHeadExist(ledgerHead.getHeadName(), ledgerHead.getId())) {
			ledgerHead.setEntryTime(new Timestamp(new Date().getTime()));
			ledgerHead.setEntryBy(userDetails.getId());
			obj.put("result", ledgerHeadService.saveLedgerHead(ledgerHead));
			obj.put("ledgerHeadList",ledgerHeadService.getLedgerHeadListOrderByParentId());
		}else {
			obj.put("result", "duplicate");
		}
		
		
		return obj;
	}
	
	@RequestMapping(value= {"/getLedgerHeadList"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getLedgerHeadList() {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		obj.put("ledgerHeadList",ledgerHeadService.getLedgerHeadListOrderByParentId());
		return obj;
	}
	
	@RequestMapping(value= {"/saveLedger"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveLedger(Ledger ledger) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!ledgerService.isLedgerExist(ledger.getLedgerName(), 0)) {
			ledger.setEntryTime(new Timestamp(new Date().getTime()));
			ledger.setEntryBy(userDetails.getId());
			obj.put("result", ledgerService.saveLedger(ledger));
			obj.put("ledgerList",ledgerService.getLedgerList());
		}else {
			obj.put("result", "duplicate");
		}
		
		return obj;
	}
	
	@RequestMapping(value= {"/editLedger"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editLedger(Ledger ledger) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!ledgerService.isLedgerExist(ledger.getLedgerName(), ledger.getId())) {
			ledger.setEntryTime(new Timestamp(new Date().getTime()));
			ledger.setEntryBy(userDetails.getId());
			obj.put("result", ledgerService.saveLedger(ledger));
			obj.put("ledgerList",ledgerService.getLedgerList());
		}else {
			obj.put("result", "duplicate");
		}
		
		return obj;
	}
	
	@RequestMapping(value= {"/getLedgerInfo"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getLedgerInfo(String ledgerId) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		obj.put("ledgerInfo",ledgerService.findById(Long.valueOf(ledgerId)));
		return obj;
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
	
	//Not Approved Bill
		@RequestMapping(value={"/accounts/not-approved-bill"})
		public ModelAndView not_approved_bill(ModelMap map,HttpSession session) {

			ModelAndView view = new ModelAndView("accounts/not-approved-bill");
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
