package com.example.domain;

public class FinanceManager {
	
	public String nameFinanceManager;
	public double taxFinanceManager;
	public String taxFinanceManagerPeriod;
	
	
	
	public FinanceManager(String nameFinanceManager, double taxFinanceManager, String taxFinanceManagerPeriod) {
		super();
		this.nameFinanceManager = nameFinanceManager;
		this.taxFinanceManager = taxFinanceManager;
		this.taxFinanceManagerPeriod = taxFinanceManagerPeriod;
	}
	
	
	
	@Override
	public String toString() {
		return "FinanceManager "
				+ "\n   [nameFinanceManager = " + nameFinanceManager + 
				", \n   taxFinanceManager = " + taxFinanceManager+" "+ taxFinanceManagerPeriod + "]";
	}



	public String getNameFinanceManager() {
		return nameFinanceManager;
	}
	public double getTaxFinanceManager() {
		return taxFinanceManager;
	}
	public String getTaxFinanceManagerPeriod() {
		return taxFinanceManagerPeriod;
	}
	
	

}
