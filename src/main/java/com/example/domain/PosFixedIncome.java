package com.example.domain;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;

import com.example.domain.Investment.AbstractFixedIncomeInvestment;

public class PosFixedIncome extends AbstractFixedIncomeInvestment{

	public PosFixedIncome( 
			FinanceManager financeManager,
			String productName, 
			//LocalDate registerDate, 
			LocalDate purchaseDate,
			LocalDate endDate,
			double initialValue,
			String nameRateOfInterest,
			String rateOfInterestPeriod
			) {
		this.productName = productName;
		//this.registerDate = registerDate;
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
				+ "\n   Hold Period: " + PosFixedIncome.super.getHoldPeriod().toTotalMonths()+ " months"
				+ "\n   Currente Value : "+ NumberFormat.getCurrencyInstance().format(getCurrentValue())
				+ "]";
	}
	
	@Override
	public double getRateOfInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCurrentValue() {
		ExternalResourcesEmulater externalResourcesEmulater = ExternalResourcesEmulater.getInstance();
		Integer firstMonth = purchaseDate.getMonthValue();
		long months = Period.between(purchaseDate, LocalDate.now()).toTotalMonths();
		double amount = initialValue;
		
		for (int i=firstMonth; i < (firstMonth + months); i++) {
			int monthOfInterest = 0;
			if(i>=13) {monthOfInterest = i%12;} else {monthOfInterest = i;};
			double rateOfInterestOfMonth = externalResourcesEmulater.getRateOfInterest(monthOfInterest);
			amount = amount * (1 + rateOfInterestOfMonth);
		}
		
		return amount; 
	}

	@Override
	public double getProfabilityValue() {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	



}
