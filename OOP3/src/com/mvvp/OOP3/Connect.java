package com.mvvp.OOP3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Where's your driver?");
			e.printStackTrace();
			return null;
		}
		System.out.println("PostgreSQL JDBC Driver Registered");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:2112/OOP3","postgres","21122113Humberto");
		}catch(SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
			return null;
		}
		if(connection!=null) {
			return connection;
		}else {
			System.out.println("failed to make connection");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static Connection connect = null;
	public static Connection getConnection() {
		try {
			if(connect == null) {
				Class.forName("org.postgresql.Driver");
				DriverManager.getConnection("jdbc:postgresql://127.0.0.1:2112/OOP3","postgres", "21122113Humberto");
				System.out.println("Connection established");
			}
			return connect;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Something went wrong");
		}
	}
	
	static class close extends Thread{
		public void run() {
		try {
			Connection connect = Connect.getConnection();
			connect.close();
			System.out.println("Connection closed");
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
	}*/
}
