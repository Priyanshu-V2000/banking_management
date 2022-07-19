package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Customer {
	
	
	@NotEmpty
	private String custName;	
	
	private long custMobile;
	
	@Id
	private long custAdhaar;	
	
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
	private byte age;
	
	private int houseNo;
	
	private int pinCode;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	private String acId;
	
	private double balance;
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}

	public long getCustAdhaar() {
		return custAdhaar;
	}

	public void setCustAdhaar(long custAdhaar) {
		this.custAdhaar = custAdhaar;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAcId() {
		return acId;
	}

	public void setAcId(String acId) {
		this.acId = acId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer() {
		super();
	}

	public Customer(@NotEmpty String custName, long custMobile, long custAdhaar,
			@Min(value = 18, message = "Age should not be less than 18") @Max(value = 100, message = "Age should not be greater than 100") byte age,
			int houseNo, int pinCode, @NotEmpty String city, @NotEmpty String state, String acId, double balance) {
		super();
		this.custName = custName;
		this.custMobile = custMobile;
		this.custAdhaar = custAdhaar;
		this.age = age;
		this.houseNo = houseNo;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.acId = acId;
		this.balance = balance;
	}
	
	
	
}