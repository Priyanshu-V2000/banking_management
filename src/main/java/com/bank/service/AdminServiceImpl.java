package com.bank.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AdminDao;
import com.bank.exception.InvalidStatusException;
import com.bank.model.Admin1;
import com.bank.model.Customer;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminDao ad;
	@Autowired
	private CustomerServiceImpl csi;

	@Override
	public List<Admin1> getAdminDetails() {
		// TODO Auto-generated method stub
		return ad.findAll();
	}

	@Override
	public void assignStatusBalance(Admin1 admin) {
		// TODO Auto-generated method stub
		long adhaar = admin.getCustAdhaar();
		Customer cust = csi.getCustomer(adhaar);
		String status = admin.getAccStatus();
		if(status.equalsIgnoreCase("Active")) {
			ad.save(admin);
		}
		else {
			throw new InvalidStatusException("607", "Invalid Status");
		}
	}

	@Override
	public void updateBalance(String accId) {
		// TODO Auto-generated method stub
		Admin1 ad2 = ad.findById(accId).get();
		double balance=csi.getBalance(accId);
		ad.saveBalanceByAccId(balance, accId);
	}
	@Override
	public void updateStatus(String accId) {
		// TODO Auto-generated method stub
		Admin1 ad1 = ad.findById(accId).get();
		String status="closed";
		ad.saveStatusByAccId(status,accId);
	}
	
}








