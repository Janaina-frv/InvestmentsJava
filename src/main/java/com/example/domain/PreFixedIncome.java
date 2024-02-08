package com.example.domain;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import com.example.domain.Investment.AbstractPreFixedIncomeInvestment;

public class PreFixedIncome extends AbstractPreFixedIncomeInvestment{

	public PreFixedIncome( 
			FinanceManager financeManager,
			String productName, 
			double initialValue,
			double rateOfInterest,
			String rateOfInterestPeriod
			) {
		this.productName = productName;
		this.registerDate = LocalDate.now();
		this.purchaseDate = LocalDate.of(2023, Month.JUNE, 1);
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
				+ "\n   Hold Period: " + PreFixedIncome.super.getHoldPeriod().toTotalMonths() + " months"
				+ "\n   Currente Value : "+ NumberFormat.getCurrencyInstance().format(getCurrentValue())
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
	
	@Override
	public double getCurrentValue() {
		Integer firstMonth = purchaseDate.getMonthValue();
		long months = Period.between(purchaseDate, LocalDate.now()).toTotalMonths();
		double amount = initialValue;
		
		for (int i=firstMonth; i < (firstMonth + months); i++) {
			amount = amount * (1 + rateOfInterest);
		}
		
		return amount; 
	}



}
