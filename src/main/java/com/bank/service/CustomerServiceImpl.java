package com.bank.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bank.dao.AdminDao;
import com.bank.dao.CustomerDao;
import com.bank.exception.AccountIdException;
import com.bank.exception.AccountIdMustBeNullException;
import com.bank.exception.CustomerAlreadyExistsException;
import com.bank.exception.EmptyInputException;
import com.bank.exception.InsufficientBalanceException;
import com.bank.exception.SizeLimitException;
import com.bank.model.Admin1;
import com.bank.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerDao cd;
	
	@Autowired
	private AdminDao ad;
		
	Logger logger=org.slf4j.LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub	
		Long custAdhaar = customer.getCustAdhaar();			
		if (custAdhaar == 0) {
			throw new EmptyInputException("602", "Customer Adhaar is empty"); 
		}
		else if(custAdhaar.toString().length()!=12) {
			throw new SizeLimitException("610", "Customer Adhaar must be of size 12 digit");
		}
		
		Long custMobile = customer.getCustMobile();
		if (custMobile == 0) {
			throw new EmptyInputException("603", "Mobile no is empty"); 
		}
		else if(custMobile.toString().length()!=10) {
			throw new SizeLimitException("609","Mobile size must be of size 10 digit");
		}
		
		int houseNo = customer.getHouseNo();
		if (houseNo == 0) {
			throw new EmptyInputException("604", "House no is empty"); 
		}
		
		Integer pincode = customer.getPinCode();		
		if (pincode == 0) {
			throw new EmptyInputException("605", "Pincode is empty"); 
		}
		else if(pincode.toString().length()!=6) {
			throw new SizeLimitException("611","Pincode must be of size 6");
		}
		
		List<Customer> cust = getAllCustomer();	
		long count = 0;
		count = cust.stream().filter((i) -> i.getCustAdhaar() == customer.getCustAdhaar()).count();
		String acId = customer.getAcId();
		if(acId.isBlank() && count == 0) {
			return cd.save(customer);
		}		
		else if(count != 0) { 
			throw new CustomerAlreadyExistsException("609","The customer already exists");
		}		 
		else {
			throw new AccountIdMustBeNullException("606", "Account Id must be null");
		}
	}
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}
	@Override
	public Customer getCustomer(long adhaar) {
		// TODO Auto-generated method stub
		Customer c= cd.findById(adhaar).get();
		return c;
	}
	@Override
	public void updateCustomer(Customer c,String id) {
		// TODO Auto-generated method stub
		Admin1 admin = ad.findById(id).get();
		if(cd.findByAcId(id)==null) {
			c.setAcId(id);
			cd.save(c);
		}
		else {
			throw new AccountIdException("608","This account id is already assigned to another customer");
		}
		
	}
	@Override
	public void depositAmount(Customer cust,String acId, double amount) {
		// TODO Auto-generated method stub
		if(cd.findByAcId(acId)==null) {
			throw new AccountIdException("601" , "Account id dose'nt exist");
		}
		cd.saveBalanceByAcId(acId, amount);		
	}
	@Override
	public double getBalance(String acId) {
		// TODO Auto-generated method stub		
		if(cd.findByAcId(acId)==null) {
			throw new AccountIdException("601" , "Account id dose'nt exist");
		}		
		return cd.findBalanceByAcId(acId);
	}
	@Override
	public Customer getCustomerById(String acId) {
		// TODO Auto-generated method stub
		 Customer c = cd.findByAcId(acId);
		 return c;
	}
	@Override
	public void withdrawAmount(Customer cust,String acId, double amount, double balance) {
		// TODO Auto-generated method stub
		if(cd.findByAcId(acId)==null) {
			throw new AccountIdException("601" , "Account id dose'nt exist");
		}
		if(balance<amount) {
    		 throw new InsufficientBalanceException("602","amount exceeds balance");
    	 }
		cd.withdrawAmountByAcId(acId, amount);		
	}
	@Override
	public void deleteAccount(String acId) {
		
		if(cd.findByAcId(acId)==null) {
			throw new AccountIdException("601" , "Account id dose'nt exist");
		}		
		cd.deleteByAcId(acId);
	}	
	
	@Override
	public Customer findByAcId(String acId) {
		return cd.findByAcId(acId);
	}
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}
	
}