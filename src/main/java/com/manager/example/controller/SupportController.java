package com.manager.example.controller;

import java.rmi.activation.ActivateFailedException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manager.inventory.entity.Employee;
import com.manager.inventory.services.PackageService;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.support.entity.ActivationTMS;
import com.manager.support.entity.ComplainTMS;
import com.manager.support.entity.ConnectionPoint;
import com.manager.support.entity.OltMcPosition;
import com.manager.support.services.ActivationTMSService;
import com.manager.support.services.ComplainTMSService;
import com.manager.support.services.ConnectionPointService;
import com.manager.support.services.OltMcPositionService;

@Controller
public class SupportController {

	@Autowired
	ConnectionPointService connPointService;
	@Autowired
	OltMcPositionService oltMcService;
	@Autowired
	ActivationTMSService activationService;
	@Autowired
	PackageService packageService;
	@Autowired
	ComplainTMSService complainService;

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
	public @ResponseBody Map<String, Object> submitActivationTMSRequest(ActivationTMS activationTms) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		activationTms.setEntryTime(new Timestamp(new Date().getTime()));
		activationTms.setEntryBy(userDetails.getId());
		obj.put("result", activationService.saveActivationTMS(activationTms));
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

		complainTms.setEntryTime(new Timestamp(new Date().getTime()));
		complainTms.setEntryBy(userDetails.getId());
		obj.put("result", complainService.saveComplainTMS(complainTms));
		return obj;
	}

	@RequestMapping(value={"/support/tms-report-list"})
	public ModelAndView tms_report_list(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/tms-report-list");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}

	@RequestMapping(value={"/tms-details/{tmsNo}"})
	public ModelAndView tms_details(ModelMap map,HttpSession session,@PathVariable("tmsNo") String tmsNo) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/tms-details");
		//map.addAttribute("roleList",roleService.getRoleList());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
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


	// OLT/MC Position
	@RequestMapping(value={"/support/olt-mc-position"})
	public ModelAndView olt_mc_position(ModelMap map,HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView view = new ModelAndView("support/olt-mc-position");
		map.addAttribute("oltMcList",oltMcService.getOltMcPositions());
		//map.addAttribute("resourceList",resourceService.getResourceList());
		return view;
	}

	@RequestMapping(value= {"/saveOltMcPosition"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveOltMcPosition(OltMcPosition oltMcPosition) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		oltMcPosition.setEntryTime(new Timestamp(new Date().getTime()));
		oltMcPosition.setEntryBy(userDetails.getId());
		obj.put("result", oltMcService.saveOltMcPosition(oltMcPosition));
		obj.put("oltMcList",oltMcService.getOltMcPositions());
		return obj;
	}

	@RequestMapping(value= {"/editOltMcPosition"},method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> editOltMcPosition(OltMcPosition oltMcPosition) {
		Map<String, Object> obj = new HashMap();
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		oltMcPosition.setEntryTime(new Timestamp(new Date().getTime()));
		oltMcPosition.setEntryBy(userDetails.getId());
		obj.put("result", oltMcService.saveOltMcPosition(oltMcPosition));
		obj.put("oltMcList",oltMcService.getOltMcPositions());
		return obj;
	}

	@RequestMapping(value= {"/getOltMcPosition"},method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getOltMcPosition(String id){
		Map<String, Object> obj = new HashMap();
		obj.put("oltMcPositionInfo",oltMcService.getOltMcPosition(Long.valueOf(id)));
		return obj;
	}
}
