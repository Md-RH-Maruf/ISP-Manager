package com.manager.store.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.store.entity.ProductRequisition;
import com.manager.store.repository.ProductRequisitionRepository;

@Service
public class ProductRequisitionService {

	DecimalFormat df = new DecimalFormat("00");
	
	@Autowired
	ProductRequisitionRepository productReqRepo;
	
	public String getMaxRequisitionNo() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "PRQ-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+productReqRepo.getMaxRequisitionNo(yearMonth);
	}
	
	public ProductRequisition saveProductRequisition(ProductRequisition productRequisition) {
		return productReqRepo.save(productRequisition);
	}
	
	public ProductRequisition findById(long id) {
		return productReqRepo.findById(id).orElse(null);
	}
	
	public ProductRequisition findByRequisitionNo(String requisitionNo) {
		return productReqRepo.findByRequisitionNo(requisitionNo);
	}
	
	public List<ProductRequisition> getProductRequisitionList(){
		return productReqRepo.findAll();
	}
	
	public List<ProductRequisition> getProductRequisitionListByStatus(String status){
		return productReqRepo.findByStatus(Integer.valueOf(status));
	}
}
