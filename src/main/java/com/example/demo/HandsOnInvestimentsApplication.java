package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.*;

@SpringBootApplication
public class HandsOnInvestimentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsOnInvestimentsApplication.class, args);
						
		PreFixedIncome preFixPoupanca = new PreFixedIncome(new FinanceManager("Banco do Brasil",0.0,"a.a."),
				"Poupança 51 BB", LocalDate.now() , 1000.00, 1.05, "a.a.");
		System.out.println(preFixPoupanca.toString());
		
		PosFixedIncome posFixedIncome = new PosFixedIncome(new FinanceManager("Tesouro Direto",0.1,"a.a."),
				"LTF 2025", 
				LocalDate.now() , LocalDate.now().plusDays(1), LocalDate.now().plusDays(1).plusYears(1),
				900.00, "SELIC", "a.d.");
		System.out.println(posFixedIncome.toString());
		
		Stock stock = new Stock(new FinanceManager("XP Investimentos",0.2,"por venda"),
				"Ações petrobras", LocalDate.now() , 500.00);
		System.out.println(stock.toString());
				
	}

}
