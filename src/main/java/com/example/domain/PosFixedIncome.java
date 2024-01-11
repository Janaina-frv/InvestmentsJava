package com.example.domain;

import java.time.LocalDate;
import java.time.Period;

import com.example.domain.Investment.AbstractFixedIncomeInvestment;

public class PosFixedIncome extends AbstractFixedIncomeInvestment{

	public PosFixedIncome( 
			FinanceManager financeManager,
			String productName, 
			LocalDate registerDate, 
			LocalDate purchaseDate,
			LocalDate endDate,
			double initialValue,
			String nameRateOfInterest,
			String rateOfInterestPeriod
			) {
		this.productName = productName;
		this.registerDate = registerDate;
		this.purchaseDate = purchaseDate;
		this.endDate = endDate;
		this.initialValue = initialValue;
		this.nameRateOfInterest = nameRateOfInterest;
		this.rateOfInterestPeriod = rateOfInterestPeriod;
		this.financeManager = financeManager;
	};
	
	@Override
	public String toString() {
		return "\n" + financeManager.toString()
				+"\nPosFixedIncome "
				+ "\n   productName = " + productName 
				+ ", \n   initialValue = " + initialValue 
				+ "\n   registerDate = " + registerDate + ", purchaseDate = " + purchaseDate 
				+ ", endDate = " + endDate +  ", saleDate = " + saleDate+", "
				+ "\n   rateOfInterest = " + nameRateOfInterest + " "+ rateOfInterestPeriod 
				+ "]";
	}
	
	@Override
	public double getRateOfInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCurrentValue() {
		// TODO Auto-generated method stub
		ExternalResourcesEmulater externalResourcesEmulater = ExternalResourcesEmulater.getInstance();
		Integer firstMonth = purchaseDate.getMonthValue();
		long months = Period.between(purchaseDate, LocalDate.now()).toTotalMonths();
		double amount = initialValue;
		
		for (int i=firstMonth; i < (firstMonth + months); i++) {
			double rateOfInterestOfMonth = externalResourcesEmulater.getRateOfInterest(i);
			amount = amount * (1 + rateOfInterestOfMonth);
		}
		
		return amount; //calculate with compound interest = juros compostos, Map
	}

	@Override
	public double getProfabilityValue() {
		// TODO Auto-generated method stub
		
		return 0;
	}



}
