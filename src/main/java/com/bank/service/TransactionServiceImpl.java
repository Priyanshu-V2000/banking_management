package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.CustomerDao;
import com.bank.dao.TransactionDao;
import com.bank.model.Customer;
import com.bank.model.Transaction1;

@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	private TransactionDao td;
	
	@Autowired
	private CustomerDao cd ;
	
	@Override
	public void createTrans(Transaction1 trans) {
		// TODO Auto-generated method stub
		td.save(trans);
		
		
	}
	@Override
	public void createTransaction(Transaction1 trans,String acId) {
		Customer customer = cd.findByAcId(acId);
		trans.setCustomer(customer);
		createTrans(trans);
		
	}
	@Override
	public List<Transaction1> getTrans(Customer cust) {
		// TODO Auto-generated method stub
		return td.findByCustomer(cust);
	}
	
	@Override
	public void deleteTrans(Customer cust) {
		// TODO Auto-generated method stub
		td.deleteByCustomer(cust);
		
	}

}
