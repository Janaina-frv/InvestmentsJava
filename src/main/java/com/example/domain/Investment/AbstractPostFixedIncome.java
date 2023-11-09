package com.example.domain.Investment;

public class AbstractPostFixedIncome extends AbstractFixedIncome{

	protected AbstractPostFixedIncome(float fixedRateOfInterest, float variableRateOfInterest) {
		super(fixedRateOfInterest + variableRateOfInterest);
	}
	
	
}
