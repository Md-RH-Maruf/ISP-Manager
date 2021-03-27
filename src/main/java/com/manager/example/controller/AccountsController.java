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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manager.accounts.entity.Bill;
import com.manager.accounts.entity.Ledger;
import com.manager.accounts.entity.LedgerHead;
import com.manager.accounts.entity.Transaction;
import com.manager.accounts.service.BillService;
import com.manager.accounts.service.LedgerHeadService;
import com.manager.accounts.service.LedgerService;
import com.manager.accounts.service.TransactionService;
import com.manager.example.shareModel.BillStatus;
import com.manager.example.shareModel.BillType;
import com.manager.inventory.services.CustomerService;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.security.services.MyUserDetailsService;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionProductDetails;
import com.manager.support.services.ActivationTMSService;
import com.manager.support.services.ComplainTMSService;


@Controller
public class AccountsController {

	@Autowired
	ActivationTMSService activationTmsService;
	@Autowired
	ComplainTMSService complainTmsSercice;
	@Autowired
	LedgerHeadService ledgerHeadService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	LedgerService ledgerService;
	@Autowired
	BillService billService;
	@Autowired
	CustomerService customerService;
	@Autowired
	MyUserDetailsService userDetailsService;

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
		map.addAttribute("maxId",billService.getMaxBillNo());
		map.addAttribute("ledgerList",ledgerService.getLedgerList());

		return view;
	}

	@RequestMapping(value= {"/submitBill"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitBill(Bill bill,String billLedgers) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Transaction> requisitionBillList = new ArrayList<Transaction>() ;
		double totalAmount = 0;
		bill.setBillType(BillType.Create_Bill.getType());
		bill.setEntryTime(new Timestamp(new Date().getTime()));
		bill.setEntryBy(userDetails.getId());
		JSONObject products = new JSONObject(billLedgers);
		JSONArray productList = products.getJSONArray("list");
		for(Object object: productList) {
			JSONObject jObject = (JSONObject) object;
			Transaction transaction = new Transaction();
			transaction.setBillNo(bill.getBillNo());
			transaction.setDebitLedger(jObject.getString("ledgerId"));
			transaction.setCreditLedger("3");
			transaction.setAmount(jObject.getInt("amount"));
			totalAmount += jObject.getInt("amount");
			transaction.setDescription(jObject.getString("description"));
			transaction.setEntryTime(new Timestamp(new Date().getTime()));
			transaction.setEntryBy(userDetails.getId());
			requisitionBillList.add(transaction);
		}
		bill.setTotalAmount(totalAmount);
		if(activationTmsService.getActivationTMSByTmsNo(bill.getTicketId()) != null || complainTmsSercice.getComplainTMSByTmsNo(bill.getTicketId()) != null) {
			if(billService.saveBill(bill) != null) {
				if(transactionService.saveTransactions(requisitionBillList) != null) {
					obj.put("result", "successfull");
				}else {
					obj.put("result", "duplicate");
				}	
			}else {
				obj.put("result", "something wrong");
			}		
		}else {
			obj.put("result", "something wrong");
			obj.put("message", "Ticket id not valid");
		}	
		return obj;
	}


	//Pending Bill
	@RequestMapping(value={"/accounts/pending-bill"})
	public ModelAndView pending_bill(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/pending-bill");
		map.addAttribute("billList",billService.getBillsByBillTypeAndStatus(BillType.Create_Bill.getType(), BillStatus.PENDING.getType()));
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}


	@RequestMapping(value={"/accounts/pending-bill-details/{billNo}"})
	public ModelAndView pending_bill_details(ModelMap map,HttpSession session,@PathVariable("billNo") String billNo) {

		ModelAndView view = new ModelAndView("accounts/pending-bill-details");
		Bill bill = billService.findByBillNo(billNo);
		//map.addAttribute("billList",billService.getBillsByBillTypeAndStatus(BillType.Create_Bill.getType(), BillStatus.PENDING.getType()));
		session.setAttribute("billInfo",bill);
		session.setAttribute("createdBy",userDetailsService.findById(bill.getEntryBy()).getUsername());
		map.addAttribute("billDetails",transactionService.getTransactionInfoListByBillNo(billNo));

		return view;
	}

	@RequestMapping(value= {"/approveBill"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> approveBill(String billNo,String approveAmount) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Bill  bill = billService.findByBillNo(billNo);
		bill.setApproveAmount(Double.valueOf(approveAmount));
		bill.setStatus(BillStatus.APPROVED.getType());
		bill.setApproveBy((int)userDetails.getId());
		bill.setApproveDate(new java.sql.Date(new Date().getTime()));

		if(billService.saveBill(bill) != null) {
			obj.put("result","successfull");
		}else {
			obj.put("result","something wrong");
			obj.put("message","something wrong");
		}


		return obj;
	}

	@RequestMapping(value= {"/rejectBill"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> rejectBill(String billNo,String rejectedCause) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Bill  bill = billService.findByBillNo(billNo);
		bill.setRejectedCause(rejectedCause);
		bill.setStatus(BillStatus.NOT_APPROVED.getType());
		bill.setRejectedBy((int)userDetails.getId());
		bill.setRejectedDate(new java.sql.Date(new Date().getTime()));

		if(billService.saveBill(bill) != null) {
			obj.put("result","successfull");
		}else {
			obj.put("result","something wrong");
			obj.put("message","something wrong");
		}


		return obj;
	}


	//Approved Bill
	@RequestMapping(value={"/accounts/approved-bill"})
	public ModelAndView approved_bill(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/approved-bill");
		map.addAttribute("billList",billService.getBillsByBillTypeAndStatus(BillType.Create_Bill.getType(), BillStatus.APPROVED.getType()));
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}
	
	@RequestMapping(value={"/accounts/approved-bill-details/{billNo}"})
	public ModelAndView approved_bill_details(ModelMap map,HttpSession session,@PathVariable("billNo") String billNo) {

		ModelAndView view = new ModelAndView("accounts/approved-bill-details");
		Bill bill = billService.findByBillNo(billNo);
		//map.addAttribute("billList",billService.getBillsByBillTypeAndStatus(BillType.Create_Bill.getType(), BillStatus.PENDING.getType()));
		session.setAttribute("billInfo",bill);
		session.setAttribute("createdBy",userDetailsService.findById(bill.getEntryBy()).getUsername());
		map.addAttribute("billDetails",transactionService.getTransactionInfoListByBillNo(billNo));

		return view;
	}
	
	@RequestMapping(value= {"/issueBillAmount"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> issueBillAmount(String billNo) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Bill  bill = billService.findByBillNo(billNo);
		bill.setStatus(BillStatus.ISSUED.getType());
		List<Transaction> newTransactionList = new ArrayList<Transaction>();
		if(billService.saveBill(bill) != null) {
			List<Transaction> transactionList = transactionService.findByBillNo(billNo);
			for(Transaction transaction:transactionList) {
				Transaction newTransaction = new Transaction();
				newTransaction.setBillNo(transaction.getBillNo());
				newTransaction.setTransactionType(BillType.Issued_Bill.getType());
				newTransaction.setDebitLedger(transaction.getDebitLedger());
				newTransaction.setCreditLedger(transaction.getCreditLedger());
				newTransaction.setAmount(transaction.getAmount());
				newTransaction.setDescription("Issued acctual Amount");
				newTransaction.setStatus(BillStatus.ISSUED.getType());
				newTransaction.setEntryTime(new java.sql.Timestamp(new Date().getTime()));
				newTransaction.setEntryBy(userDetails.getId());
				
				newTransactionList.add(newTransaction);
			}
			if(transactionService.saveTransactions(newTransactionList) != null) {
				obj.put("result","successfull");
			}else {
				obj.put("result","something wrong");
				obj.put("message","something wrong");
			}
		}else {
			obj.put("result","something wrong");
			obj.put("message","something wrong");
		}


		return obj;
	}


	//Not Approved Bill
	@RequestMapping(value={"/accounts/not-approved-bill"})
	public ModelAndView not_approved_bill(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/not-approved-bill");
		map.addAttribute("billList",billService.getBillsByBillTypeAndStatus(BillType.Create_Bill.getType(), BillStatus.NOT_APPROVED.getType()));
		//map.addAttribute("customerList",customerService.getCustomerList());

		return view;
	}


	//Cash Transaction
	@RequestMapping(value={"/accounts/cash-transaction"})
	public ModelAndView cash_transaction(ModelMap map,HttpSession session) {

		ModelAndView view = new ModelAndView("accounts/cash-transaction");
		map.addAttribute("maxId",billService.getMaxBillNo());
		map.addAttribute("ledgerList",ledgerService.getLedgerList());

		return view;
	}

	@RequestMapping(value= {"/submitPaymentTransaction"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitPaymentTransaction(Bill bill,String billLedgers) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Transaction> requisitionBillList = new ArrayList<Transaction>() ;
		bill.setBillType(BillType.Cash_Payment.getType());
		bill.setEntryTime(new Timestamp(new Date().getTime()));
		bill.setEntryBy(userDetails.getId());
		double totalAmount = 0;
		JSONObject products = new JSONObject(billLedgers);
		System.out.println("list"+products.toString());
		JSONArray productList = products.getJSONArray("list");
		for(Object object: productList) {
			JSONObject jObject = (JSONObject) object;
			Transaction transaction = new Transaction();
			transaction.setBillNo(bill.getBillNo());
			transaction.setDebitLedger(jObject.getString("ledgerId"));
			transaction.setCreditLedger("3");
			transaction.setAmount(jObject.getInt("amount"));
			totalAmount += jObject.getInt("amount");
			transaction.setDescription(jObject.getString("description"));
			transaction.setEntryTime(new Timestamp(new Date().getTime()));
			transaction.setEntryBy(userDetails.getId());
			requisitionBillList.add(transaction);
		}

		bill.setTotalAmount(totalAmount);

		if(bill.getTicketId().isEmpty() || activationTmsService.getActivationTMSByTmsNo(bill.getTicketId()) != null || complainTmsSercice.getComplainTMSByTmsNo(bill.getTicketId()) != null) {
			if(billService.saveBill(bill) != null) {
				if(transactionService.saveTransactions(requisitionBillList) != null) {
					obj.put("result", "successfull");
				}else {
					obj.put("result", "duplicate");
				}	
			}else {
				obj.put("result", "something wrong");
			}		
		}else {
			obj.put("result", "something wrong");
			obj.put("message", "Ticket id not valid");
		}	
		return obj;
	}

	@RequestMapping(value= {"/submitReceiveTransaction"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitReceiveTransaction(Bill bill,String billLedgers) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Transaction> requisitionBillList = new ArrayList<Transaction>() ;
		bill.setBillType(BillType.Cash_Payment.getType());
		bill.setEntryTime(new Timestamp(new Date().getTime()));
		bill.setEntryBy(userDetails.getId());
		double totalAmount = 0;
		JSONObject products = new JSONObject(billLedgers);
		System.out.println("list"+products.toString());
		JSONArray productList = products.getJSONArray("list");
		for(Object object: productList) {
			JSONObject jObject = (JSONObject) object;
			Transaction transaction = new Transaction();
			transaction.setBillNo(bill.getBillNo());
			transaction.setDebitLedger(jObject.getString("ledgerId"));
			transaction.setCreditLedger("3");
			transaction.setAmount(jObject.getInt("amount"));
			totalAmount += jObject.getInt("amount");
			transaction.setDescription(jObject.getString("description"));
			transaction.setEntryTime(new Timestamp(new Date().getTime()));
			transaction.setEntryBy(userDetails.getId());
			requisitionBillList.add(transaction);
		}

		bill.setTotalAmount(totalAmount);

		if(bill.getTicketId().isEmpty() || activationTmsService.getActivationTMSByTmsNo(bill.getTicketId()) != null || complainTmsSercice.getComplainTMSByTmsNo(bill.getTicketId()) != null) {
			if(billService.saveBill(bill) != null) {
				if(transactionService.saveTransactions(requisitionBillList) != null) {
					obj.put("result", "successfull");
				}else {
					obj.put("result", "duplicate");
				}	
			}else {
				obj.put("result", "something wrong");
			}		
		}else {
			obj.put("result", "something wrong");
			obj.put("message", "Ticket id not valid");
		}	
		return obj;
	}

	//Customer Monthly Invoice
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

	@RequestMapping(value= {"/submitMonthlyInvoice"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitMonthlyInvoice(String customerId,String amount,String activeDate) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Transaction transaction = new Transaction() ;
		Bill bill = new Bill();

		bill.setBillNo(billService.getMaxBillNo());
		bill.setBillType(BillType.Monthly_Invoice.getType());
		bill.setCustomerId(customerId);
		bill.setBillDate(new java.sql.Date(new Date().getTime()));
		bill.setTotalAmount(Double.valueOf(amount));
		bill.setStatus(1);
		bill.setEntryTime(new Timestamp(new Date().getTime()));
		bill.setEntryBy(userDetails.getId());

		transaction.setBillNo(bill.getBillNo());
		transaction.setTransactionType(BillType.Monthly_Invoice.getType());
		transaction.setDebitLedger("7");
		transaction.setCreditLedger("0");
		transaction.setAmount(Double.valueOf(amount));
		transaction.setStatus(1);
		transaction.setEntryTime(new Timestamp(new Date().getTime()));
		transaction.setEntryBy(userDetails.getId());

		if(customerService.findByCustomerId(customerId) != null ) {
			if(billService.saveBill(bill) != null) {
				if(transactionService.saveTransaction(transaction) != null) {
					obj.put("result", "successfull");
				}else {
					obj.put("result", "duplicate");
				}	
			}else {
				obj.put("result", "something wrong");
			}		
		}else {
			obj.put("result", "something wrong");
			obj.put("message", "Ticket id not valid");
		}	
		return obj;
	}
}
