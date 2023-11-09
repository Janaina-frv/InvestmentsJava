package com.example.domain.Fund;

import java.time.LocalDate;
import java.util.List;

import com.example.domain.Investment.Investment;

public abstract class AbstractFund implements Fund{
	
	private LocalDate createFundDate;
	private List<Investment> investments;
	private Float totalAmount;

	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
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
