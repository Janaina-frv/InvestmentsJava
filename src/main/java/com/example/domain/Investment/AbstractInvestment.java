package com.example.domain.Investment;
import java.time.LocalDate;
import java.time.Period;

import com.example.domain.FinanceManager;

public abstract class AbstractInvestment implements Investment{
		
	protected LocalDate registerDate;
	protected LocalDate purchaseDate;
	protected double initialValue;
	protected String productName;
	protected LocalDate saleDate;
		
	protected FinanceManager financeManager;
		
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public double getInitialValue() {
		return initialValue;
	}
	public Period getHoldPeriod() {
		return Period.between(purchaseDate, LocalDate.now());//Period LocalDate and Local Time and purchaseDate
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
