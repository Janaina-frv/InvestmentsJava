package com.example.emulators;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import com.example.jdbc.ConnectionFactory;

public class BrazilianTreasureImplementation implements BrazilianTreasuryEmulator {
	
	public Queue<Investment> investmentsBrazilianTreasury;
	ExecutorService executorService;
	static AtomicInteger count;
	
	public BrazilianTreasureImplementation() {
		super();
		this.investmentsBrazilianTreasury = new LinkedBlockingQueue<Investment>();
		count = new AtomicInteger();
		executorService = Executors.newFixedThreadPool(3);
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
		
		private Connection con = null;
	
		@Override
		public void run() {
		
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
				
				try {
					con = ConnectionFactory.getConnection();
					System.out.println("Connection up!!");
					PreparedStatement p = con.prepareStatement("INSERT INTO Investment (registerdate, purchasedate, initialvalue, productname) VALUES(?, ?, ?, ?)");
					p.setDate(1, java.sql.Date.valueOf(investment.getRegisterDate()));
					p.setDate(2, java.sql.Date.valueOf(investment.getPurchaseDate()));
					p.setDouble(3, investment.getInitialValue());
					p.setString(4, investment.getProductName());
					p.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						con.close();
						System.out.println("Connection closed!!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
