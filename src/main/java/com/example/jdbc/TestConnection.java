package com.example.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	
	public static void main (String[] args) {
		
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			System.out.println("Connection up!!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection broken!!");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	



}
