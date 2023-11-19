package com.example.domain.Investment;

public abstract class AbstractPostFixedIncomeInvestment extends AbstractFixedIncomeInvestment implements PostFixedIncomeInterface {

	private double indexerRate;
	

	
	@Override
	public double getCurrentValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public double getRateOfInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getIndexerRate() {
		return indexerRate;
	}


	
	
}
