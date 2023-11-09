package com.example.domain.Fund;

public class RetirementFund extends AbstractFund{

	private int contributionTime;
	private Float totalAmountGoal;
	private int durationRemuneration;
	private Float income;
	public int getContributionTime() {
		return contributionTime;
	}
	public void setContributionTime(int contributionTime) {
		this.contributionTime = contributionTime;
	}

	public Float getTotalAmountGoal() {
		return totalAmountGoal;
	}
	public void setTotalAmountGoal(Float totalAmountGoal) {
		this.totalAmountGoal = totalAmountGoal;
	}
	public int getDurationRemuneration() {
		return durationRemuneration;
	}
	public void setDurationRemuneration(int durationRemuneration) {
		this.durationRemuneration = durationRemuneration;
	}
	public Float getIncome() {
		return income;
	}
	public void setIncome(Float income) {
		this.income = income;
	}
	

}
