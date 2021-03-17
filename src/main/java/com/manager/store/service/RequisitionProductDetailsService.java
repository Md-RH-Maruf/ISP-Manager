package com.manager.store.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionProductDetails;
import com.manager.store.repository.ProductRequisitionRepository;
import com.manager.store.repository.RequisitionProductDetailsRepository;

@Service
public class RequisitionProductDetailsService {

	DecimalFormat df = new DecimalFormat("00");
	
	@Autowired
	RequisitionProductDetailsRepository requiPrductRepo;
	
	public RequisitionProductDetails saveRequisitionProduct(RequisitionProductDetails requisitionProduct) {
		return requiPrductRepo.save(requisitionProduct);
	}
	
	public List<RequisitionProductDetails> saveRequisitionProducts(List<RequisitionProductDetails> requisitionProducts) {
		return requiPrductRepo.saveAll(requisitionProducts);
	}
	
	
	public List<RequisitionProductDetails> findByRequisitionNo(String requisitionNo) {
		return requiPrductRepo.findByRequisitionNo(requisitionNo);
	}
	
	public List<RequisitionProductDetails> getProductRequisitionList(){
		return requiPrductRepo.findAll();
	}
	
}
