package com.example.domain.Investment;

public class AbstractFixedIncome extends AbstractInvestment{

	private int endDate;
	private float rateOfInterest;
	
	protected AbstractFixedIncome(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	
}
