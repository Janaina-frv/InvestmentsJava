package com.example.domain.Fund;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.Investment.Investment;

public abstract class AbstractFund implements Fund{
	
	private LocalDate createFundDate;
	private List<Investment> investments;
	private double totalAmount;
	
	public AbstractFund() {
		this.createFundDate = LocalDate.now();
		this.investments = new ArrayList<Investment>();
		this.totalAmount = 0.0f;
	}

	public List<Investment> getInvestments() {
		return investments;
	}
	public double getTotalAmount() {
		totalAmount = 0;
		int qtyInvestments = investments.size();
		for (int i=0;i<qtyInvestments;i++) {
			totalAmount = totalAmount + investments.get(i).getCurrentValue();
		}
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
