package com.example.demo;

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
		
		PosFixedIncome posFixedIncome = new PosFixedIncome(new FinanceManager("Tesouro Direto",0.1,"a.a."),
				"LTF 2025", 
				LocalDate.now() , LocalDate.now().plusDays(1), LocalDate.now().plusDays(1).plusYears(1),
				900.00, "SELIC", "a.d.");
		System.out.println(posFixedIncome.toString());
		
		Stock stock = new Stock(new FinanceManager("XP Investimentos",0.2,"per sale"),
				"Ações petrobras",  500.00);
		System.out.println(stock.toString());
				
	}

}
