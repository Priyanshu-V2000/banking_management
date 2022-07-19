package com.bank.service;

import java.util.List;

import com.bank.model.Customer;
import com.bank.model.Transaction1;

public interface ITransactionService {
	
	public void createTrans(Transaction1 trans);
	public void createTransaction(Transaction1 trans,String acId);
    public List<Transaction1> getTrans(Customer cust);
    public void deleteTrans(Customer cust);
}
