package com.bank.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>  {

	@Query("select balance from Customer where acId = ?1")
	public double findBalanceByAcId(String acId);
	
	@Query("from Customer where acId = ?1")
    public Customer findByAcId(String acId);
    
   @Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Customer set balance = balance+?2 where acId=?1")
	public void saveBalanceByAcId(String acId, Double balance);
   
   @Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Customer set balance = balance-?2 where acId=?1")
	public void withdrawAmountByAcId(String acId, Double balance);

   @Transactional
   public void deleteByAcId(String acId);
}
