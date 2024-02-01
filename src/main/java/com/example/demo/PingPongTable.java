package com.example.demo;

public class PingPongTable {
	
	private static String state;
	
	public synchronized static void setState() {
		if (PingPongTable.state != null && 
				!PingPongTable.state.isEmpty()) {
			if (PingPongTable.state == "Ping") {
				PingPongTable.state = "Pong";
			} else {
				PingPongTable.state = "Ping";
			}
		} else {
			PingPongTable.state = "Ping";
		} 
		System.out.println(PingPongTable.state);
	}
	
	public static void main(String[] args) {
		
		PingPongPlayer pingPongPlayer1 = new PingPongPlayer();
		PingPongPlayer pingPongPlayer2 = new PingPongPlayer();
		
		Thread player1thread = new Thread(pingPongPlayer1);
		Thread player2thread = new Thread(pingPongPlayer2);
		
		player1thread.start();
		player2thread.start();
		
	}

}
