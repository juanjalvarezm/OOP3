package com.mvvp.OOP3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerConnectPrueba {
	public static Connection getConnection() {
		System.out.println("------- PostgreSQL JDBC Connection Testing --------");
		try {
			
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Where is your postgresql JDBC driver? inlcude in your library path");
			e.printStackTrace();
			return null;
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:2112/OOP3", "postgres", "21122113Humberto");
		}catch(SQLException e) {
			System.out.println("Connection Failed! Check Output console");
			e.printStackTrace();
			return null;
		}
		if(connection != null) {
			System.out.println("You made it, take control your database now! ");
			return connection;
		}else {
			System.out.println("Failed to make connection!");
		}
		return null;
	}
}
