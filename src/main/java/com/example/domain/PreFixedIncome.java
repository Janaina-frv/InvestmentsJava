package com.example.domain;

import java.time.LocalDate;

import com.example.domain.Investment.AbstractPreFixedIncomeInvestment;

public class PreFixedIncome extends AbstractPreFixedIncomeInvestment{

	public PreFixedIncome( 
			FinanceManager financeManager,
			String productName, 
			LocalDate registerDate, 
			double initialValue,
			double rateOfInterest,
			String rateOfInterestPeriod
			) {
		this.productName = productName;
		this.registerDate = registerDate;
		this.initialValue = initialValue;
		this.rateOfInterest = rateOfInterest;
		this.rateOfInterestPeriod = rateOfInterestPeriod;
		this.financeManager = financeManager;
	};
	
	@Override
	public String toString() {
		return "\n" + financeManager.toString()
				+"\nPreFixedIncome "
				+ "\n   productName = " + productName 
				+ ", \n   initialValue = " + initialValue 
				+ "\n   registerDate = " + registerDate + ", purchaseDate = " + purchaseDate 
				+ ", endDate = " + endDate +  ", saleDate = " + saleDate+", "
				+ "\n   rateOfInterest = " + rateOfInterest + " "+ rateOfInterestPeriod 
				
				+ "]";
	}
	
	@Override
	public double getRateOfInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getProfabilityValue() {
		// TODO Auto-generated method stub
		return 0;
	}



}
