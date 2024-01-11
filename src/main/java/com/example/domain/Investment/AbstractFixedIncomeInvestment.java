package com.example.domain.Investment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFixedIncomeInvestment extends AbstractInvestment implements FixedIncomeInterface{

	protected LocalDate endDate;
	protected double rateOfInterest;
	protected String nameRateOfInterest;  //indexer
	protected String rateOfInterestPeriod;
	
	public LocalDate getEndDate() {
		return endDate;
	}


	
}
