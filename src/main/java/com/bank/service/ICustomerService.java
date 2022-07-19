package com.bank.service;

import java.util.List;

import com.bank.model.Customer;


public interface ICustomerService {

	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer getCustomer(long adhaar);
	public void updateCustomer(Customer c,String id);
	public void depositAmount(Customer cust,String acId, double amount);
	public double getBalance(String acId);
	public Customer getCustomerById(String acId);
	public void withdrawAmount(Customer cust,String acId, double amount , double balance);
	public void deleteAccount(String acId);
	public Customer findByAcId(String acId);
	public List<Customer> getCustomers();
}
