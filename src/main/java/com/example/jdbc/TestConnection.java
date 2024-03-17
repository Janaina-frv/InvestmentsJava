package com.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	
	public static void main (String[] args) {
		
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			System.out.println("Connection up!!");
			
			//executingMyQuery("drop",con);
			//executingMyQuery("create",con);
			//executingMyQuery("insert",con, 12 , 0.13);
			//executingMyQuery("delete", con, 12);
			//executingMyQuery("update", con, 11, 0.12);
			executingMyQuery("select",con);
			
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
	
	
	
	
	public static void executingMyQuery(String option, Connection con) {
		switch(option){
			case "drop":
				try {
					PreparedStatement drop = con.prepareStatement("DROP TABLE RateOfInterest");
					drop.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "create":
				try {
					PreparedStatement create = con.prepareStatement("CREATE TABLE RateOfInterest(  "
							+ "  month INT,\r\n"
							+ "  rateOfInterest FLOAT)");
					create.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "select":
				try {
					PreparedStatement select = con.prepareStatement("SELECT * FROM RateOfInterest");
					select.execute();
					ResultSet result = select.getResultSet();
				    System.out.print("Month ");
				    System.out.println("RateOfInterest");
					while (result.next()) {
					    System.out.print(result.getString(1)+"     ");
					    System.out.println(result.getString(2));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Nothing to do!!");
		}
		
	}
	
	public static void executingMyQuery(String option, Connection con, int month) {
		switch(option){
			case "delete":
				try {
					PreparedStatement delete = con.prepareStatement("DELETE FROM RateOfInterest WHERE month = ?");
						delete.setInt(1, month);
					delete.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Nothing to do!!");
		}
		
	}
	
	public static void executingMyQuery(String option, Connection con, int month, double rate) {
		switch(option){
			case "insert":
				try {
					PreparedStatement insert = con.prepareStatement("INSERT INTO RateOfInterest Values(?,?)");
						insert.setInt(1, month);
					insert.setDouble(2, rate);
				insert.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "update":
				try {
					PreparedStatement update = con.prepareStatement("UPDATE RateOfInterest SET rateOfInterest = ? WHERE month = ?");
						update.setDouble(1, rate);
						update.setInt(2, month);
					update.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Nothing to do!!");
		}
		
	}

}
