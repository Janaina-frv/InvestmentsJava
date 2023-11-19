package com.example.domain.Investment;

import java.time.LocalDate;

public abstract class AbstractFixedIncomeInvestment extends AbstractInvestment implements FixedIncomeInterface{

	protected LocalDate endDate;
	protected double rateOfInterest;
	
	public LocalDate getEndDate() {
		return endDate;
	}


	
}
