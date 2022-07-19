package com.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Customer;
import com.bank.model.Transaction1;
import com.bank.service.CustomerServiceImpl;
import com.bank.service.TransactionServiceImpl;


@RestController
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl tsi;
	@Autowired 
	private CustomerServiceImpl csi;
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(TransactionController.class);
	
	@GetMapping("getTrans/{custAdhaar}")
	public ResponseEntity<List<Transaction1>> getTransaction(@PathVariable("custAdhaar") long custAdhaar){
		Customer c =csi.getCustomer(custAdhaar);
		List<Transaction1> t = tsi.getTrans(c);
		logger.info("Transaction displayed!!");
		return new ResponseEntity<List<Transaction1>>(t,HttpStatus.OK);
		
		
	}


}
