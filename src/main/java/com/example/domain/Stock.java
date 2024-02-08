package com.example.domain;

import java.time.LocalDate;
import java.time.Month;

import com.example.domain.Investment.AbstractInvestment;

public class Stock extends AbstractInvestment{
	
	public Stock( 
			FinanceManager financeManager,
			String productName, 
			double initialValue
			) {
		this.productName = productName;
		this.registerDate = LocalDate.now();
		this.purchaseDate =  LocalDate.of(2023, Month.JANUARY, 1);
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
				+ "\n   Hold Period: " + Stock.super.getHoldPeriod().toTotalMonths()+ " months"
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
