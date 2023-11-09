package com.example.domain.Investment;


public class Stock extends AbstractInvestment{


	public Float priceVariation(float initialAmount,float currentAmount) {
		return currentAmount / initialAmount;
	}
	
}
