package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		String url_con = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "XXXXXXX";
		return DriverManager.getConnection(url_con,user,password );
	}

}
