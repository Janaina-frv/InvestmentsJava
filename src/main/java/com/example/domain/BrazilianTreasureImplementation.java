package com.example.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

import com.example.domain.Investment.Investment;

public class BrazilianTreasureImplementation implements BrazilianTreasuryEmulator {
	
	public Queue<Investment> investmentsBrazilianTreasury;
	
	public BrazilianTreasureImplementation() {
		super();
		this.investmentsBrazilianTreasury = new LinkedList<Investment>();
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
		Investment investment = investmentsBrazilianTreasury.poll();
		investment.setRegisterDate(LocalDate.now());
		System.out.println("\nProcessing: "+investment.getProductName());
	}; 
	
	public class InvestmentProcessor extends Thread{
		int count;
		LocalTime time = LocalTime.now();
		
		@Override
		public void run() {
			while(!(LocalTime.now() == time.plusSeconds(20))) {
				
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (investmentsBrazilianTreasury == null) {
					System.out.println("\nAll investment processed!! Queue is empty!!");
					System.out.println("Size of Queue: "+investmentsBrazilianTreasury.size());
				} else {
					process ();
					System.out.println("Size of Queue: "+investmentsBrazilianTreasury.size());	
					count += 1;
					System.out.println("Investments processed: "+ count);
				}
			}
		}
	}
}
