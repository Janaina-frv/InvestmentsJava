package com.example.domain.Fund;

public class InvestmentsFund extends AbstractFund{
	
	private Float rateIncrease;
	private Float rateDecrease;
	public Float getRateIncrease() {
		return rateIncrease;
	}
	public void setRateIncrease(Float rateIncrease) {
		this.rateIncrease = rateIncrease;
	}
	public Float getRateDecrease() {
		return rateDecrease;
	}
	public void setRateDecrease(Float rateDecrease) {
		this.rateDecrease = rateDecrease;
	}
	

}
