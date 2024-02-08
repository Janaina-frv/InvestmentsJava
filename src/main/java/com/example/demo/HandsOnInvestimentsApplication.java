package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.*;
import com.example.domain.Fund.EmergencyFund;
import com.example.domain.Investment.Investment;

@SpringBootApplication
public class HandsOnInvestimentsApplication {

	public static void main(String[] args) {
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
				emergencyFund.addInvestment(posFixedIncome);		
		
		System.out.println("\nTotal Amount of All Investments: " + String.format("%.2f", emergencyFund.getTotalAmount()));
		
		
		Stock stock = new Stock(new FinanceManager("XP Investimentos",0.2,"per sale"),
				"Ações petrobras",  500.00);
		//	System.out.println(stock.toString());
		
	
		BrazilianTreasuryEmulator.investmentSimulator(100.0, 10, 0.5);
		
		
		BrazilianTreasureImplementation brazilianTreasureImplementation1 = new BrazilianTreasureImplementation();
		
		brazilianTreasureImplementation1.register(posFixedIncome);
		brazilianTreasureImplementation1.register(posFixedIncome2);
		
	}

}

