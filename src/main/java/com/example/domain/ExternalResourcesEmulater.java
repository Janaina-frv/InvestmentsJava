package com.example.domain;

import java.util.HashMap;
import java.util.Map;

public final class ExternalResourcesEmulater {
	
	private static ExternalResourcesEmulater instance;
	
	protected static Map<Integer,Double> mapRateofInterest; //Month, rate
	
	private ExternalResourcesEmulater () {
		mapRateofInterest = new HashMap<>();
		mapRateofInterest.put( 1 , 1.08 );
		mapRateofInterest.put( 2 , 1.22 );
		mapRateofInterest.put( 3 , 1.32 );
	}
	
	public static ExternalResourcesEmulater getInstance() {
		if (instance == null) {
			instance = new ExternalResourcesEmulater();
		} 
		return instance;
	}
	
	public double getRateOfInterest(Integer month) {
		return mapRateofInterest.get(month);
	}

}
