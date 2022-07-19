package com.bank.service;

import java.util.List;

import com.bank.model.Admin1;

public interface IAdminService {

	public void assignStatusBalance(Admin1 admin);
	public List<Admin1> getAdminDetails();
	public void updateBalance(String accId);
	public void updateStatus(String accId);
}
