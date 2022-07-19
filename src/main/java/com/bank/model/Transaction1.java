package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.bank.generator.TransIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Transaction1 {
    
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "tid_seq")
	@GenericGenerator(name="tid_seq",
			strategy = "com.bank.generator.TransIdGenerator",
			parameters = {
					@Parameter(name=TransIdGenerator.INCREMENT_PARAM,value="1"),
					@Parameter(name=TransIdGenerator.VALUE_PREFIX_PARAMETER,value="T_"),
					@Parameter(name=TransIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
			}
			)
	@Column(name="transId",updatable = false, nullable=false )
	private String transId;
	private String transType;
	@OneToOne
	private Customer customer;
	private double initBal;
	private double finalBal;
	
	@JsonIgnore
	@JsonProperty(value = "customer_cust_adhaar")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public double getInitBal() {
		return initBal;
	}
	public void setInitBal(double initBal) {
		this.initBal = initBal;
	}
	public double getFinalBal() {
		return finalBal;
	}
	public void setFinalBal(double finalBal) {
		this.finalBal = finalBal;
	}
	
	public Transaction1(String transType,double initBal, double finalBal) {
		super();
		this.transType= transType;
		this.initBal= initBal;
		this.finalBal=finalBal;
		
	}
	public Transaction1() {
		super();
	}

}
