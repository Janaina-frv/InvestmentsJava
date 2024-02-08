package com.example.domain;

import com.example.demo.PingPongTable;
import com.example.domain.Investment.Investment;

public abstract interface BrazilianTreasuryEmulator {

	abstract void register (Investment investment);///
	abstract void process (); // FIFO
	abstract void sale (Investment investment);
	
	public static void investmentSimulator (double initialValue, int months, double rateOfInterest) {
		double finalValue = 0;
		for (int i=0; i < months; i++) {
			finalValue = initialValue * (1 + rateOfInterest);
		}
		System.out.println("\nInvestment Simulator ");
		System.out.println("   Initial Valuel: "+ initialValue);
		System.out.println("   Months: "+ months);
		System.out.println("   Rate of Interest: "+ rateOfInterest + " per month");
		System.out.println("   Final Valuel: "+ finalValue);
	}; 
	
	
}
