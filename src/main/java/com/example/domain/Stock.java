package com.example.domain;

import java.time.LocalDate;

import com.example.domain.Investment.AbstractInvestment;

public class Stock extends AbstractInvestment{
	
	public Stock( 
			FinanceManager financeManager,
			String productName, 
			LocalDate registerDate, 
			double initialValue
			) {
		this.productName = productName;
		this.registerDate = registerDate;
		this.initialValue = initialValue;
		this.financeManager = financeManager;
	};
	
	@Override
	public String toString() {
		return "\n" + financeManager.toString()
				+"\nStock "
				+ "\n   productName = " + productName 
				+ ", \n   initialValue = " + initialValue 
				+ "\n   registerDate = " + registerDate + ", saleDate = " + saleDate+", "
				+ "]";
	}
	

	@Override
	public double getCurrentValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getProfabilityValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
