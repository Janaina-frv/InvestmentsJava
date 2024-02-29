package com.example.emulators;

import java.util.HashMap;
import java.util.Map;

public final class ExternalResourcesEmulater {
	
	private static ExternalResourcesEmulater instance;
	
	protected static Map<Integer,Double> mapRateofInterest; //Month, rate
	
	private ExternalResourcesEmulater () {
		mapRateofInterest = new HashMap<>();
		mapRateofInterest.put( 1 , 0.10 );
		mapRateofInterest.put( 2 , 0.10 );
		mapRateofInterest.put( 3 , 0.10 );
		mapRateofInterest.put( 4 , 0.10 );
		mapRateofInterest.put( 5 , 0.10 );
		mapRateofInterest.put( 6 , 0.10 );
		mapRateofInterest.put( 7 , 0.10 );
		mapRateofInterest.put( 8 , 0.10 );
		mapRateofInterest.put( 9 , 0.10 );
		mapRateofInterest.put( 10 , 0.10 );
		mapRateofInterest.put( 11 , 0.10 );
		mapRateofInterest.put( 12 , 0.10 );
		
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
