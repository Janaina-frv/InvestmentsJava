package com.example.domain.Investment;
import java.time.LocalDate;
import java.time.Period;

public abstract class AbstractInvestment implements Investment{
		
	protected int registerDate;

	protected LocalDate purchaseDate;
	protected double initialValue;
	protected String productName;
	
	protected LocalDate saleDate;
		
	//private String financeManager; Create a new Class
	//private float administrateTax; Attribute of the new Class FinanceManager
		
	public int getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(int registerDate) {
		this.registerDate = registerDate;
	}
	
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public double getInitialValue() {
		return initialValue;
	}
	public Period getHoldPeriod() {
		return null;//Period LocalDate and Local Time and purchaseDate
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	};
	
}
