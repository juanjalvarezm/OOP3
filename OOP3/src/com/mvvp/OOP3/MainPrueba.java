package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainPrueba {

	public static void main(String[] args) {
		String tableName = "product";
		Connection connection = ManagerConnectPrueba.getConnection();
		
		if(connection != null) {
			Statement stmt = null;
			String query = "SELECT *"+" FROM "+ tableName;
			
			try {
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					Integer id = rs.getInt("id");
					String description = rs.getString("description");
					System.out.println(id+": "+description);
				}
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				if(stmt != null) {
					try {
						System.out.println("Closing statement");
						stmt.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
				
			try {
				System.out.println("Closing down");
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		}else {
				System.out.println(":D");
			}
		

	}

}
