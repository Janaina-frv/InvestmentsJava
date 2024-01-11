package com.example.domain.Fund;

import com.example.domain.Investment.Investment;

public interface Fund {
	
	public Float sumTotalsFunds(float initialAmount, float currentAmount);
	public int sumDaysFunds();
	public void addInvestment(Investment investment);
	
}
