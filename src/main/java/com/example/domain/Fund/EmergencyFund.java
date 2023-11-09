package com.example.domain.Fund;

public class EmergencyFund extends AbstractFund{

	private Float goal;
	private Float currentExpanses;
	private int qtyMonthlys;

	public Float getGoal() {
		return goal;
	}

	public void setGoal(Float goal) {
		this.goal = goal;
	}

	public Float getCurrentExpanses() {
		return currentExpanses;
	}

	public void setCurrentExpanses(Float currentExpanses) {
		this.currentExpanses = currentExpanses;
	}

	public int getQtyMonthlys() {
		return qtyMonthlys;
	}

	public void setQtyMonthlys(int qtyMonthlys) {
		this.qtyMonthlys = qtyMonthlys;
	}


	
	

}