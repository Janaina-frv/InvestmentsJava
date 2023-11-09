package com.example.domain.Investment;

public class AbstractPreFixedIncome extends AbstractFixedIncome{

	private float finalAmount;
	
	protected AbstractPreFixedIncome(float rateOfInterest) {
		super(rateOfInterest);
	}
	
	public float getFinalAmount( float rateOfInterest) {
		return rateOfInterest; // ver calculo
	}

}
