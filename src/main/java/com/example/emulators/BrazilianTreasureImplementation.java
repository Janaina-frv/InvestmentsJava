package com.example.emulators;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.domain.Investment.Investment;
import com.example.emulators.BrazilianTreasureImplementation.InvestmentProcessor;

public class BrazilianTreasureImplementation implements BrazilianTreasuryEmulator {
	
	public Queue<Investment> investmentsBrazilianTreasury;
	ExecutorService executorService;
	static AtomicInteger count;
	
	public BrazilianTreasureImplementation() {
		super();
		this.investmentsBrazilianTreasury = new LinkedBlockingQueue<Investment>();
		count = new AtomicInteger();
		executorService = Executors.newCachedThreadPool();
	}

	@Override
	public void register (Investment investment) {
		investment.setRegisterDate(LocalDate.now());
		investmentsBrazilianTreasury.add(investment);
		process();
	};
	
	@Override
	public void sale () {
		
	};
	
	@Override
	public void process () {
		InvestmentProcessor investmentProcessor = new InvestmentProcessor();
		executorService.execute(investmentProcessor);	
	}; 
	
	public class InvestmentProcessor extends Thread{
	
		@Override
		public void run() {

			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Investment investment = investmentsBrazilianTreasury.poll();

			if (investment == null) {
				System.out.println("\nAll investment processed!! Queue is empty!!");
				System.out.println("Size of Queue: "+investmentsBrazilianTreasury.size());
			} else {
				investment.setRegisterDate(LocalDate.now());
				System.out.println("\nProcessing: "+investment.getProductName());
				System.out.println("Size of Queue: "+investmentsBrazilianTreasury.size());	
				count.incrementAndGet();
				System.out.println("Investments processed: "+ count);
			}
		}
	}
}
