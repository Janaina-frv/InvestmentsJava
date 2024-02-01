package com.example.demo;

import java.time.Duration;
import java.time.LocalTime;

public class PingPongPlayer implements Runnable {
	
	public void play() {
		PingPongTable.setState();
	}

	@Override
	public void run() {
		LocalTime startTime = LocalTime.now();
		
		while (Duration.between(startTime, LocalTime.now()).getSeconds() <= 60) {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			play();
		}
	}
	

}
