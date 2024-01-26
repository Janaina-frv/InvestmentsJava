package com.example.domain.Investment;
import java.time.LocalDate;
import java.time.Period;

public interface Investment {

	public LocalDate getPurchaseDate();
	public double getInitialValue();
	public double getCurrentValue(); //juros compostos - Map
	public Period getHoldPeriod();
	public String getProductName();
	public double getProfabilityValue();
	
	public default void anything() {
		System.out.println("System out!");
	}
	
	
	
}
