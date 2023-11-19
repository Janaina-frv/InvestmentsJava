package com.example.domain.Investment;

public abstract class AbstractPreFixedIncomeInvestment extends AbstractFixedIncomeInvestment{

	private float finalAmount;
	
	
	
	public float getFinalAmount( ) {
		return finalAmount; // ver calculo
	}
	
	@Override
	public double getCurrentValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
