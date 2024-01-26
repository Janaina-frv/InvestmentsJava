package com.example.demo;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.*;
import com.example.domain.Fund.EmergencyFund;
import com.example.domain.Fund.Fund;

@SpringBootApplication
public class HandsOnInvestimentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsOnInvestimentsApplication.class, args);
						
		PreFixedIncome preFixPoupanca = new PreFixedIncome(new FinanceManager("Banco do Brasil",0.0,"a.a."),
				"Poupança 51 BB",  1000.00, 1.05, "a.a.");
		Fund emergencyFund = new EmergencyFund();
		emergencyFund.addInvestment(preFixPoupanca);
		System.out.println(preFixPoupanca.toString());
		preFixPoupanca.anything();
		
		PosFixedIncome posFixedIncome = new PosFixedIncome(new FinanceManager("Tesouro Direto",0.1,"a.a."),
				"LTF 2025", 
				LocalDate.of(2023, Month.JANUARY, 1) , LocalDate.of(2023, Month.JANUARY, 2), LocalDate.of(2029, Month.JANUARY, 1),
				1000.00, "SELIC", "a.m.");
		System.out.println(posFixedIncome.toString());
		System.out.println("Currente Value : "+ NumberFormat.getCurrencyInstance().format(posFixedIncome.getCurrentValue()));
		posFixedIncome.anything();
		
		Stock stock = new Stock(new FinanceManager("XP Investimentos",0.2,"per sale"),
				"Ações petrobras",  500.00);
		System.out.println(stock.toString());
		stock.anything();
		
		
		BrazilianTreasuryEmulator.investmentSimulator(0, 0, 0);
				
	}

}
