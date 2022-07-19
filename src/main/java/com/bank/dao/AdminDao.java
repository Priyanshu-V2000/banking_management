package com.bank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Admin1;

public interface AdminDao extends JpaRepository<Admin1, String> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Admin1 set balance = ?1 where acc_Id=?2")
	public void saveBalanceByAccId(double balance,String accId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Admin1 set acc_status = ?1 where acc_Id=?2")
	public void saveStatusByAccId(String Status,String accId);
	
	
}
