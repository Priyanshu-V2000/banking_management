package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.bank.generator.AccIdGenerator;

@Entity
public class Admin1 { 
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "id_seq")
	@GenericGenerator(name="id_seq",
			strategy = "com.bank.generator.AccIdGenerator",
			parameters = {
					@Parameter(name=AccIdGenerator.INCREMENT_PARAM,value="1"),
					@Parameter(name=AccIdGenerator.VALUE_PREFIX_PARAMETER,value="B_"),
					@Parameter(name=AccIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
			}
			)
	@Column(name="AccId",updatable = false, nullable=false )
	private String AccId;
	

	private long custAdhaar;
	private String accStatus;
	private double balance;
	public String getAccId() {
		return AccId;
	}
	public void setAccId(String accId) {
		AccId = accId;
	}

	public String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getCustAdhaar() {
		return custAdhaar;
	}
	public void setCustAdhaar(long custAdhaar) {
		this.custAdhaar = custAdhaar;
	}

}
