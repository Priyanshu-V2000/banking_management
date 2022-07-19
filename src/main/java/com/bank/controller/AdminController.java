package com.bank.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Admin1;
import com.bank.service.AdminServiceImpl;

@RestController
public class AdminController {
	@Autowired
	private AdminServiceImpl asi;
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(AdminController.class);

	
	@PostMapping(path="addStatusBalance", consumes= {"application/json"})
	public ResponseEntity<Admin1> setStatusBalance(@RequestBody Admin1 admin) {
		asi.assignStatusBalance(admin);
		logger.info("Status Balance displayed!!");
		return new ResponseEntity<Admin1>(HttpStatus.CREATED);
	}
	@PutMapping("updateBalance/{accId}")
	public ResponseEntity<Admin1> updateBalance(@PathVariable("accId") String accId){
		asi.updateBalance(accId);
		logger.info("Balance updated!!");
		return new ResponseEntity<Admin1>(HttpStatus.CREATED);	
	}
}
