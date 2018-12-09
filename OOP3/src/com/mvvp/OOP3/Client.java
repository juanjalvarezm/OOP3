package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
	
	//Insert Method
		public static void insert(int id_client, String name, int cellnumber, int ci, String address) {
			Connection connection = Connect.getConnection();
			if(connection != null ) {

				String query ="INSERT INTO client(id_client, name, cellnumber, ci, address)  VALUES (?,?, ?,?,?)";
		
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1, id_client);
					prepareStatement.setString(2, name);
					prepareStatement.setInt(3,cellnumber);
					prepareStatement.setInt(4,ci);
					prepareStatement.setString(5, address);
					prepareStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//Final Insert Method
		
		//Update Method
		public void update(String column, String value, int id_client) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "UPDATE client SET "+column+"= ? WHERE id_product = ?";
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setString(1, value);
					prepareStatement.setInt(2,id_client);
					prepareStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//Final update method
}
