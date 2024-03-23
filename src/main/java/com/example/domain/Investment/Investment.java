package com.example.domain.Investment;
import java.time.LocalDate;
import java.time.Period;

public interface Investment {

	public LocalDate getSaleDate();
	public LocalDate getRegisterDate();
	public LocalDate getPurchaseDate();
	public double getInitialValue();
	public double getCurrentValue(); //juros compostos - Map
	public Period getHoldPeriod();
	public String getProductName();
	public double getProfabilityValue();
	void setRegisterDate(LocalDate registerDate);
	void setPurchaseDate(LocalDate purchaseDate);
	
}
