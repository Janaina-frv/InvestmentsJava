package com.example.domain;

import com.example.domain.Investment.Investment;

public abstract interface BrazilianTreasuryEmulator {

	abstract void register (Investment investment);///
	abstract void process (); // FIFO
	abstract void sale (Investment investment);
	
	public static void investmentSimulator (double initialValue, int months, double rateOfInterest) {
		
	}; //Calculater - 
	
	private void somethingInternal() {
		System.out.println("Internal use only!");
	};
	
}
