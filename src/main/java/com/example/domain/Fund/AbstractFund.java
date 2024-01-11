package com.example.domain.Fund;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.Investment.Investment;

public abstract class AbstractFund implements Fund{
	
	private LocalDate createFundDate;
	private List<Investment> investments;
	private Float totalAmount;
	
	public AbstractFund() {
		this.createFundDate = LocalDate.now();
		this.investments = new ArrayList<Investment>();
		this.totalAmount = 0.0f;
	}

	public List<Investment> getInvestments() {
		return investments;
	}
	public Float getTotalAmount() {
		return totalAmount;
	}
	
	public void addInvestment(Investment investment) {
		investments.add(investment);
	}
	
	@Override
	public int sumDaysFunds() {
		return 0;
	};
	
	@Override
	public Float sumTotalsFunds(float initialAmount, float currentAmount){
		return currentAmount - initialAmount;
	};
	
	
	

}
