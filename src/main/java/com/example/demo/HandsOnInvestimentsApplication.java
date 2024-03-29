package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.*;
import com.example.domain.Fund.EmergencyFund;
import com.example.emulators.BrazilianTreasureImplementation;
import com.example.emulators.BrazilianTreasureImplementation.InvestmentProcessor;

@SpringBootApplication
public class HandsOnInvestimentsApplication {

	public static void main(String[] args) throws InterruptedException {
		
		SpringApplication.run(HandsOnInvestimentsApplication.class, args);
		
		EmergencyFund emergencyFund = new EmergencyFund();
						
		PreFixedIncome preFixPoupanca = new PreFixedIncome(new FinanceManager("Banco do Brasil",0.1,"a.a."),
				"Poupança 51 BB",  1000.00, 0.15, " per month");
			emergencyFund.addInvestment(preFixPoupanca);
		//System.out.println(preFixPoupanca.toString());
		
		PosFixedIncome posFixedIncome = new PosFixedIncome(new FinanceManager("Tesouro Direto",0.1," per month"),
				"LTF 2025", 
				LocalDate.of(2023, Month.FEBRUARY, 2), LocalDate.of(2029, Month.APRIL, 1),
				1000.00, "SELIC", "a.m.");
			emergencyFund.addInvestment(posFixedIncome);
		//System.out.println(posFixedIncome.toString());

		PosFixedIncome posFixedIncome2 = new PosFixedIncome(new FinanceManager("Tesouro Direto",0.3," per month"),
				"LTF 2026", 
				LocalDate.of(2023, Month.FEBRUARY, 2), LocalDate.of(2029, Month.APRIL, 1),
				2000.00, "SELIC", "a.m.");
			emergencyFund.addInvestment(posFixedIncome2);		
		
		Stock stock = new Stock(new FinanceManager("XP Investimentos",0.2,"per sale"),
				"Ações petrobras",  500.00);
			System.out.println(stock.toString());
	
		//BrazilianTreasuryEmulator.investmentSimulator(100.0, 10, 0.5);
		
		System.out.println("\nTotal Amount of All Investments: " + String.format("%.2f", emergencyFund.getTotalAmount()));

		BrazilianTreasureImplementation brazilianTreasureImplementation = new BrazilianTreasureImplementation();
		BrazilianTreasureWebSiteEmulator brazilianTreasureWebSiteEmulator = new BrazilianTreasureWebSiteEmulator(brazilianTreasureImplementation);
		System.out.println("All up!");	
		
		ExecutorService executorService = Executors.newSingleThreadExecutor(); 
		executorService.execute(brazilianTreasureWebSiteEmulator);
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.MINUTES);
		
	}
	

	//INNER CLASS
	private static class BrazilianTreasureWebSiteEmulator extends Thread {
		
		private BrazilianTreasureImplementation  brazilianTreasureImplementation;
		int count;
		LocalTime time = LocalTime.now();
			
		public BrazilianTreasureWebSiteEmulator (BrazilianTreasureImplementation brazilianTreasureImplementation1) {
			this.brazilianTreasureImplementation = brazilianTreasureImplementation1;
		}
		
		@Override
		public void run() {

			while(!(LocalTime.now() == time.plusSeconds(20))) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String hour = LocalTime.now().toString();

				PosFixedIncome posFixedIncome = new PosFixedIncome(new FinanceManager("Tesouro Direto",0.3," per month"),
						"LTF 2026 in "+hour+" time", 
						LocalDate.of(2023, Month.FEBRUARY, 2), LocalDate.of(2029, Month.APRIL, 1),
						2000.00, "SELIC", "a.m.");	
				
				brazilianTreasureImplementation.register(posFixedIncome);
				count += 1;

				System.out.println("\nAdding: "+ posFixedIncome.getProductName());
				System.out.println("Investments registed: "+ count);

			}
		}
	}
}

