package com.mvvp.OOP3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection connect = null;
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
	}
}
