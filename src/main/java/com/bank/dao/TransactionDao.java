package com.bank.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.bank.model.Customer;
import com.bank.model.Transaction1;

public interface TransactionDao extends JpaRepository<Transaction1, String> {
	
	public List<Transaction1> findByCustomer(Customer cust);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	public void deleteByCustomer(Customer cust);

}
