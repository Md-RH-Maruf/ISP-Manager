package com.manager.example.controller;

import java.rmi.activation.ActivateFailedException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.manager.example.shareModel.ConnectionStatus;
import com.manager.example.shareModel.ShareMethods;
import com.manager.example.shareModel.Status;
import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Employee;
import com.manager.inventory.services.CustomerService;
import com.manager.inventory.services.EmployeeService;
import com.manager.inventory.services.PackageService;
import com.manager.security.entity.User;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.security.services.MyUserDetailsService;
import com.manager.support.entity.ActivationTMS;
import com.manager.support.entity.Comment;
import com.manager.support.entity.ComplainTMS;
import com.manager.support.entity.ConnectionPoint;
import com.manager.support.entity.McInformation;
import com.manager.support.entity.OltInformation;
import com.manager.support.entity.PPPoEInfo;
import com.manager.support.entity.SupportTeam;
import com.manager.support.entity.WorkTeam;
import com.manager.support.services.ActivationTMSService;
import com.manager.support.services.CommentService;
import com.manager.support.services.ComplainTMSService;
import com.manager.support.services.ConnectionPointService;
import com.manager.support.services.McInfoService;
import com.manager.support.services.OltInfoService;
import com.manager.support.services.PPPoEService;
import com.manager.support.services.SupportTeamService;
import com.manager.support.services.WorkTeamService;

@Controller
public class SupportController {
	@Autowired
	ShareMethods shareMethods;
	@Autowired
	MyUserDetailsService userService;
	@Autowired
	ConnectionPointService connPointService;
	@Autowired
	OltInfoService oltInfoService;
	@Autowired
	McInfoService mcInfoService;
	@Autowired
	ActivationTMSService activationService;
	@Autowired
	PackageService packageService;
	@Autowired
	ComplainTMSService complainService;
	@Autowired
	CustomerService customerService;
	@Autowired
	PPPoEService pppoeService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	SupportTeamService supportTeamService;
	@Autowired
	WorkTeamService workTeamService;
	@Autowired
	CommentService commentService;
	@Autowired
	PPPoEService ppoeInfoService;
	

	//Activation TMS
	@RequestMapping(value={"/support/activation-tms"})
	public ModelAndView activation_tms(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/activation-tms");
		map.addAttribute("packageList",packageService.getServiceList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}

	@RequestMapping(value= {"/submitActivationTMSRequest"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitActivationTMSRequest(Customer customer,ActivationTMS activationTms) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		customer.setCustomerId(customerService.getMaxCustomerId());
		customer.setEntryTime(new Timestamp(new Date().getTime()));
		customer.setEntryBy(userDetails.getId());

		if(customerService.saveCustomer(customer)!=null) {
			activationTms.setTmsNo(activationService.getMaxTMSNo());
			activationTms.setCustomerId(customer.getCustomerId());
			activationTms.setSubject("Activation: "+userDetails.getUsername());
			activationTms.setEntryTime(new Timestamp(new Date().getTime()));
			activationTms.setPriority("LOW");
			activationTms.setStatus("OPEN");
			activationTms.setLastFollowupBy((int)userDetails.getId());
			activationTms.setLastFollowupTime(new Timestamp(new Date().getTime()));
			activationTms.setEntryBy(userDetails.getId());
			if(activationService.saveActivationTMS(activationTms) != null) {
				obj.put("result", "successfull");
			}
		}else {
			obj.put("result","something wrong");
		}

		return obj;
	}
	
	@RequestMapping(value={"/support/activation-ticket-list"})
	public ModelAndView activation_ticket_list(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/activation-ticket-list");
		map.addAttribute("openTicketList",activationService.getTicketListByStatus(Status.OPEN.name()));
		map.addAttribute("processingTicketList",activationService.getTicketListByStatus(Status.PROCESSING.name()));
		map.addAttribute("closedTicketList",activationService.getTicketListByStatus(Status.CLOSED.name()));
		map.addAttribute("deletedTicketList",activationService.getTicketListByStatus(Status.DELETED.name()));
		return view;
	}

	
	@RequestMapping(value={"/activation-tms-details/{tmsNo}"})
	public ModelAndView tms_details(ModelMap map,HttpSession session,@PathVariable("tmsNo") String tmsNo) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/activation-tms-details");
		map.addAttribute("tmsNo",tmsNo);
		map.addAttribute("connectionPointList",connPointService.getConnectionPointList());
		map.addAttribute("employeeList",employeeService.getEmployeeList());
		map.addAttribute("packageList",packageService.getServiceList());
		return view;
	}
	
	@RequestMapping(value= {"/getActivationTmsDetails"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getActivationTmsDetails(String tmsNo){
		Map<String, Object> obj = new HashMap();
		
		ActivationTMS activationTms = activationService.getActivationTMSByTmsNo(tmsNo);
		
		Customer customer = customerService.findByCustomerId(activationTms.getCustomerId());
		User user = userService.findById(activationTms.getEntryBy());
		obj.put("activationTms",activationTms);
		obj.put("customer",customer);
		obj.put("user",user);
		obj.put("workTeamList",workTeamService.getWorkTeamsByTmsNo(tmsNo));
		obj.put("supportNameList",supportTeamService.getSupportTeamsByTmsNo(tmsNo));
		obj.put("commentList",commentService.getCommentsByTmsNo(tmsNo));
		return obj;
	}
	
	@RequestMapping(value= {"/updateActivationTMS"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateActivationTMS(ActivationTMS activationTms,Customer customer,String status) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ActivationTMS updateActivationTms = activationService.getActivationTMSByTmsNo(activationTms.getTmsNo());
		updateActivationTms.setActivationStatus(activationTms.getActivationStatus());
		updateActivationTms.setStatus(activationTms.getStatus());
		updateActivationTms.setPriority(activationTms.getPriority());
		updateActivationTms.setOwner(activationTms.getOwner());
		updateActivationTms.setLastFollowupBy((int)userDetails.getId());
		updateActivationTms.setLastFollowupTime(new Timestamp(new Date().getTime()));
		
		
		Customer updateCustomer = customerService.findByCustomerId(customer.getCustomerId());
		updateCustomer.setLatLong(customer.getLatLong());
		updateCustomer.setOnuMac(customer.getOnuMac());
		updateCustomer.setOnuInterface(customer.getOnuInterface());
		updateCustomer.setIpAddress(customer.getIpAddress());
		updateCustomer.setClientMac(customer.getClientMac());
		if(activationTms.getActivationStatus().equals("2")) {
			
			updateCustomer.setServiceStartDate(new java.sql.Date(new Date().getTime()));
			updateCustomer.setExpireDate(new java.sql.Date(shareMethods.addMonth(new Date(), 1).getTime()));
			updateCustomer.setConnectionStatus(ConnectionStatus.values()[0].name());
			updateCustomer.setActiveStatus(1);
			
			
			PPPoEInfo ppoeInfo = new PPPoEInfo();
			ppoeInfo.setCustomerId(updateCustomer.getCustomerId());
			ppoeInfo.setPppoeId(updateCustomer.getCustomerId()+"_"+updateCustomer.getName());
			ppoeInfo.setPassword(updateCustomer.getCustomerId());
			ppoeInfo.setEntryBy((int)userDetails.getId());
			ppoeInfo.setEntryTime(new Timestamp(new Date().getTime()));
			ppoeInfoService.savePPPoEInfo(ppoeInfo);
			
		}else if(activationTms.getActivationStatus().equals("3")) {
			//activationService.deleteActivationTMS(updateActivationTms);
			customerService.deleteCustomer(customer);
			obj.put("result","deleted");
			return obj;
		}
		
		
		if(activationService.saveActivationTMS(updateActivationTms) != null) {
			if(customerService.saveCustomer(updateCustomer) != null) {
				obj.put("result","successfull");
			}else {
				obj.put("result","something wrong");
			}
		}else {
			obj.put("result","something wrong");
		}
		//workTeam.setEntryTime(new Timestamp(new Date().getTime()));
		//workTeam.setEntryBy(userDetails.getId());
		//obj.put("result", workTeamService.saveWorkTeam(workTeam));
		//obj.put("workTeamList",workTeamService.getWorkTeamsByTmsNo(workTeam.getTicketId()));
		return obj;
	}
	
	@RequestMapping(value= {"/addWorkTeam"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addWorkTeam(WorkTeam workTeam) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		workTeam.setEntryTime(new Timestamp(new Date().getTime()));
		workTeam.setEntryBy(userDetails.getId());
		obj.put("result", workTeamService.saveWorkTeam(workTeam));
		obj.put("workTeamList",workTeamService.getWorkTeamsByTmsNo(workTeam.getTicketId()));
		return obj;
	}
	
	@RequestMapping(value= {"/addSupportName"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addSupportName(SupportTeam supportTeam) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		supportTeam.setEntryTime(new Timestamp(new Date().getTime()));
		supportTeam.setEntryBy(userDetails.getId());
		obj.put("result", supportTeamService.saveSupportTeam(supportTeam));
		obj.put("supportNameList",supportTeamService.getSupportTeamsByTmsNo(supportTeam.getTicketId()));
		return obj;
	}
	
	@RequestMapping(value= {"/addComment"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addComment(Comment commentInfo) {
		System.out.println("comment="+commentInfo.getCommentString());
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		commentInfo.setEntryTime(new Timestamp(new Date().getTime()));
		commentInfo.setEntryBy(userDetails.getId());
		obj.put("result", commentService.saveComment(commentInfo));
		obj.put("commentList",commentService.getCommentsByTmsNo(commentInfo.getTicketId()));
		return obj;
	}

	//Complain TMS
	@RequestMapping(value={"/support/complain-tms"})
	public ModelAndView complain_tms(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/complain-tms");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}

	@RequestMapping(value= {"/submitComplainTMS"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitComplainTMS(ComplainTMS complainTms) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		complainTms.setTmsNo(complainService.getMaxTMSNo());
		complainTms.setLastFollowupTime(new Timestamp(new Date().getTime()));
		complainTms.setLastFollowupBy((int)userDetails.getId());
		complainTms.setEntryTime(new Timestamp(new Date().getTime()));
		complainTms.setEntryBy(userDetails.getId());
		obj.put("result", complainService.saveComplainTMS(complainTms));
		return obj;
	}

	@RequestMapping(value= {"/getComplainTmsDetails"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getComplainTmsDetails(String tmsNo){
		Map<String, Object> obj = new HashMap();
		
		ComplainTMS complainTms = complainService.getComplainTMSByTmsNo(tmsNo);
		
		Customer customer = customerService.findByCustomerId(complainTms.getCustomerId());
		User user = userService.findById(complainTms.getEntryBy());
		obj.put("complainTms",complainTms);
		obj.put("customer",customer);
		obj.put("user",user);
		obj.put("workTeamList",workTeamService.getWorkTeamsByTmsNo(tmsNo));
		obj.put("supportNameList",supportTeamService.getSupportTeamsByTmsNo(tmsNo));
		obj.put("commentList",commentService.getCommentsByTmsNo(tmsNo));
		return obj;
	}
	
	@RequestMapping(value= {"/getCustomerComplainHistory"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getCustomerComplainHistory(String customerId){
		Map<String, Object> obj = new HashMap();
		
		//ActivationTMS activationTms = activationService.getActivationTMSByTmsNo(tmsNo);
		
		Customer customer = customerService.findByCustomerId(customerId);
		//User user = userService.findById(activationTms.getEntryBy());
		obj.put("customer",customer);
	
		return obj;
	}
	

	@RequestMapping(value={"/support/complain-ticket-list"})
	public ModelAndView complain_ticket_list(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/complain-ticket-list");
		map.addAttribute("openTicketList",complainService.getTicketListByStatus(Status.OPEN.name()));
		map.addAttribute("processingTicketList",complainService.getTicketListByStatus(Status.PROCESSING.name()));
		map.addAttribute("closedTicketList",complainService.getTicketListByStatus(Status.CLOSED.name()));
		map.addAttribute("deletedTicketList",complainService.getTicketListByStatus(Status.DELETED.name()));
		return view;
	}

	@RequestMapping(value={"/complain-ticket-details/{ticketNo}"})
	public ModelAndView complain_ticket_details(ModelMap map,HttpSession session,@PathVariable("ticketNo") String ticketNo) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/complain-ticket-details");
		map.addAttribute("tmsNo",ticketNo);
		map.addAttribute("employeeList",employeeService.getEmployeeList());
		return view;
	}
	
	@RequestMapping(value= {"/updateComplainTMS"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateComplainTMS(ComplainTMS complainTms) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ComplainTMS updateComplainTms = complainService.getComplainTMSByTmsNo(complainTms.getTmsNo());
		updateComplainTms.setStatus(complainTms.getStatus());
		updateComplainTms.setPriority(complainTms.getPriority());
		updateComplainTms.setOwner(complainTms.getOwner());
		updateComplainTms.setStatus(complainTms.getStatus());
		updateComplainTms.setLastFollowupBy((int)userDetails.getId());
		updateComplainTms.setLastFollowupTime(new Timestamp(new Date().getTime()));
		
		if(complainService.saveComplainTMS(updateComplainTms) != null) {	
			obj.put("result","successfull");
		}else {
			obj.put("result","something wrong");
		}
		return obj;
	}

	//Connection Point
	@RequestMapping(value={"/support/connection-point"})
	public ModelAndView connection_point(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/connection-point");
		map.addAttribute("connectionList",connPointService.getConnectionPointList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}

	@RequestMapping(value= {"/saveConnectionPoint"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveConnectionPoint(ConnectionPoint connectionPoint) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!connPointService.isConnectionPointExist(connectionPoint.getConnectionPointName(), 0)) {
			connectionPoint.setEntryTime(new Timestamp(new Date().getTime()));
			connectionPoint.setEntryBy(userDetails.getId());
			obj.put("result", connPointService.saveConnectionPoint(connectionPoint));
			obj.put("connectionList",connPointService.getConnectionPointList());
		}else {
			obj.put("result", "duplicate");
		}


		return obj;
	}

	@RequestMapping(value= {"/editConnectionPoint"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editConnectionPoint(ConnectionPoint connectionPoint) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(!connPointService.isConnectionPointExist(connectionPoint.getConnectionPointName(), connectionPoint.getId())) {
			connectionPoint.setEntryTime(new Timestamp(new Date().getTime()));
			connectionPoint.setEntryBy(userDetails.getId());
			obj.put("result", connPointService.saveConnectionPoint(connectionPoint));
			obj.put("connectionList",connPointService.getConnectionPointList());
		}else {
			obj.put("result", "duplicate");
		}

		return obj;
	}


	@RequestMapping(value= {"/getConnectionPoint"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getConnectionPoint(String id){
		Map<String, Object> obj = new HashMap();
		obj.put("connectionPointInfo",connPointService.findConnectionPoint(Long.valueOf(id)));
		return obj;
	}


	// OLT Position
	@RequestMapping(value={"/support/olt-information"})
	public ModelAndView olt_position(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/olt-information");
		map.addAttribute("oltInfoList",oltInfoService.getOltInformations());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}

	@RequestMapping(value= {"/saveOltInfo"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveOltInfo(OltInformation oltMcPosition) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		oltMcPosition.setEntryTime(new Timestamp(new Date().getTime()));
		oltMcPosition.setEntryBy(userDetails.getId());
		obj.put("result", oltInfoService.saveOltInformation(oltMcPosition));
		obj.put("oltInfoList",oltInfoService.getOltInformations());
		return obj;
	}

	@RequestMapping(value= {"/editOltInfo"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editOltInfo(OltInformation oltMcPosition) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		oltMcPosition.setEntryTime(new Timestamp(new Date().getTime()));
		oltMcPosition.setEntryBy(userDetails.getId());
		obj.put("result", oltInfoService.saveOltInformation(oltMcPosition));
		obj.put("oltInfoList",oltInfoService.getOltInformations());
		return obj;
	}

	@RequestMapping(value= {"/getOltInfo"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getOltInfo(String id){
		Map<String, Object> obj = new HashMap();
		obj.put("oltInfo",oltInfoService.getOltInformation(Long.valueOf(id)));
		return obj;
	}

	//Customer Details
		@RequestMapping(value={"/support/mc-information"})
		public ModelAndView mc_position(ModelMap map,HttpSession session) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView view = new ModelAndView("support/mc-information");
			map.addAttribute("mcInfoList",mcInfoService.getMcInformations());
			//map.addAttribute("resourceList",resourceService.getResourceList());
			return view;
		}

	// MC Position
	@RequestMapping(value={"/inventory/connection-details"})
	public ModelAndView connection_details(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/customer-details");
		map.addAttribute("customerList",customerService.getCustomerList());
		map.addAttribute("connectionPointList",connPointService.getConnectionPointList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	@RequestMapping(value= {"/editCustomerDetails"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editCustomerDetails(Customer customer) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer updatedCustomer = customerService.findByCustomerId(customer.getCustomerId());
		updatedCustomer.setConnectionPoint(customer.getConnectionPoint());
		updatedCustomer.setIpAddress(customer.getIpAddress());
		updatedCustomer.setOnuMac(customer.getOnuMac());
		updatedCustomer.setOnuInterface(customer.getOnuInterface());
		updatedCustomer.setClientMac(customer.getClientMac());
		updatedCustomer.setLatLong(customer.getLatLong());
		updatedCustomer.setConnectionStatus(customer.getConnectionStatus());
		obj.put("result",customerService.saveCustomer(updatedCustomer));
		obj.put("customerList",customerService.getCustomerList());
		return obj;
	}
	
	@RequestMapping(value= {"/getCustomerDetails"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getCustomerDetails(String customerId) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		obj.put("customerDetails", customerService.findByCustomerId(customerId));
		return obj;
	}

	@RequestMapping(value= {"/saveMcInfo"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveMcInfo(McInformation mcInfo) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mcInfo.setEntryTime(new Timestamp(new Date().getTime()));
		mcInfo.setEntryBy(userDetails.getId());
		obj.put("result", mcInfoService.saveMcInformation(mcInfo));
		obj.put("mcInfoList",mcInfoService.getMcInformations());
		return obj;
	}

	@RequestMapping(value= {"/editMcInfo"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editMcInfo(McInformation mcInfo) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mcInfo.setEntryTime(new Timestamp(new Date().getTime()));
		mcInfo.setEntryBy(userDetails.getId());
		obj.put("result", mcInfoService.saveMcInformation(mcInfo));
		obj.put("mcInfoList",mcInfoService.getMcInformations());
		return obj;
	}

	@RequestMapping(value= {"/getMcInfo"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getMcInfo(String id){
		Map<String, Object> obj = new HashMap();
		obj.put("mcInfo",mcInfoService.getMcInformation(Long.valueOf(id)));
		return obj;
	}

	// PPPoE & Password
	@RequestMapping(value={"/support/customer-pppoe-id-password"})
	public ModelAndView ppoe_password(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/pppoe-password");
		
		map.addAttribute("pppoeList",pppoeService.getPPPoEIdPasswordList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}
	
	@RequestMapping(value= {"/editPPPoEAndPasswordInfo"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editPPPoEAndPasswordInfo(PPPoEInfo pppoeInfo) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		pppoeInfo.setEntryTime(new Timestamp(new Date().getTime()));
		pppoeInfo.setEntryBy(userDetails.getId());
		
		obj.put("result",pppoeService.savePPPoEInfo(pppoeInfo));
		obj.put("ppoePasswordInfoList",pppoeService.getPPPoEIdPasswordList());
		return obj;
	}
}
