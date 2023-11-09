package com.example.domain.Investment;

public abstract class AbstractInvestment implements Investment{
		
	private int registerDate;
	private int initialDate;
	
	private int today; //class period
	private float initialAmount;
	private float currentAmount;
		
	private String description;
	private String financeManager;
	private float administrateTax;
		
	public int getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(int registerDate) {
		this.registerDate = registerDate;
	}
	public int getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(int initialDate) {
		this.initialDate = initialDate;
	}
	public float getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(float initialAmount) {
		this.initialAmount = initialAmount;
	}
	public float getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFinanceManager() {
		return financeManager;
	}
	public void setFinanceManager(String financeManager) {
		this.financeManager = financeManager;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public float getAdministrateTax() {
		return administrateTax;
	}
	public void setAdministrateTax(float administrateTax) {
		this.administrateTax = administrateTax;
	}
	
	@Override
	public int calcDaysInvestment() {
		return 0;
	};
	
	@Override
	public Float calcProfitabilityInvestment(float initialAmount, float currentAmount){
		return this.currentAmount - this.initialAmount;
	};
	

}
