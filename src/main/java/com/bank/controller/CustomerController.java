package com.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bank.model.Customer;
import com.bank.model.Transaction1;
import com.bank.service.AdminServiceImpl;
import com.bank.service.CustomerServiceImpl;
import com.bank.service.TransactionServiceImpl;


@RestController

public class CustomerController {

	@Autowired
	private CustomerServiceImpl cs;
	
	@Autowired
	private TransactionServiceImpl tsi;
	
	@Autowired
	private AdminServiceImpl asi;
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(CustomerController.class);


//Create Account
	@PostMapping("createCust")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		Customer cso = cs.createCustomer(customer);
		logger.info("signup processing!!");
		return new ResponseEntity<Customer>(cso , HttpStatus.CREATED);
	}

	
	@GetMapping("customers")
	public List<Customer> getProducts() {
		return cs.getAllCustomer();
	}

	
//update Account id
	@PutMapping("assignAcId/{custAdhaar}/{acId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("custAdhaar") long adhaar, @PathVariable("acId") String id) {
		Customer c = cs.getCustomer(adhaar);
		cs.updateCustomer(c, id);
		logger.info("Account id generated!!");
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
	}

//getBalance
	@GetMapping("getBalance/{acId}")
	public double getBalance(@PathVariable("acId") String acId) {
		logger.info("Balance displayed!!");
		return cs.getBalance(acId);
	}

//depositAmount
	@PutMapping("deposit/{acId}/{amount}")
	public ResponseEntity<Customer> getDeposit(@PathVariable("acId") String acId, @PathVariable("amount") double amount) {
		Customer cust = cs.getCustomerById(acId);		
		double bal=getBalance(acId);
		cs.depositAmount(cust, acId, amount);
		Transaction1 trans = new Transaction1("Deposited", bal , bal + amount);
		tsi.createTransaction(trans, acId);
		logger.info("Deposit successfull!!");
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
		
	}

//withdrawAmount
	@PutMapping("withdraw/{acId}/{amount}")
	public void withdrawAmount(@PathVariable("acId") String acId, @PathVariable("amount") double amount) {
		Customer cust = cs.getCustomerById(acId);
	    double bal=getBalance(acId);
		cs.withdrawAmount(cust,acId, amount, bal);
		Transaction1 trans = new Transaction1("Withdrawn", bal , bal - amount);
		tsi.createTransaction(trans, acId);
		logger.info("Withdraw successfull!!");
		
	}

//delete account
	@DeleteMapping("deleteAccount/{acId}")
	public ResponseEntity<Customer> deleteAccount(@PathVariable("acId") String acId ) {
		Customer cust = cs.findByAcId(acId);
		tsi.deleteTrans(cust);
		asi.updateBalance(acId);
		asi.updateStatus(acId);
		cs.deleteAccount(acId);
		logger.info("Delete successfull!!");
		return new ResponseEntity<Customer>(HttpStatus.ACCEPTED);
	}
}
