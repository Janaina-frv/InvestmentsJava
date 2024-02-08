package com.example.domain;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

import com.example.domain.Investment.Investment;

public class BrazilianTreasureImplementation implements BrazilianTreasuryEmulator {
	
	public Queue<Investment> investmentsBrazilianTreasury;
	
	public BrazilianTreasureImplementation() {
		super();
		this.investmentsBrazilianTreasury = new LinkedList<Investment>();
		process();
	}


	@Override
	public void register (Investment investment) {
		investment.setRegisterDate(LocalDate.now());
		investmentsBrazilianTreasury.add(investment);
	};
	
	@Override
	public void sale () {
		
	};
	
	@Override
	public void process () {
		InvestmentProcessor investmentProcessor = new InvestmentProcessor();
		Thread thread1 = new Thread(investmentProcessor);
		thread1.start();
	}; 
	
	
	//INNER CLASS
	private class InvestmentProcessor implements Runnable{
		
		@Override
		public void run() {
			while(true) {
				
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Investment investment = investmentsBrazilianTreasury.poll();
				//add purchase date
				
				if (investment == null) {
					System.out.println("\nAll investment processed!! Queue is empty!!");
				} else {
					System.out.println("\nInvestment was Processed!!"+investment);
					
					
				}
			}
		}
	}
	
}




