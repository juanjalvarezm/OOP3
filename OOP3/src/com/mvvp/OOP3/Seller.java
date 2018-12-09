package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Seller {
	//Insert Method
		public static void insert(int id_seller, String name, int turn) {
			Connection connection = Connect.getConnection();
			if(connection != null ) {

				String query ="INSERT INTO seller(id_seller, name, turn)  VALUES (?,?, ?)";
		
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1, id_seller);
					prepareStatement.setString(2, name);
					prepareStatement.setInt(3,turn);
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
		public void update(String column, String value, int id_provider) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "UPDATE seller SET "+column+"= ? WHERE id_product = ?";
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setString(1, value);
					prepareStatement.setInt(2,id_provider);
					prepareStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//Final update method
		
		//Delete Method
		public void delete(int id_seller) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "DELETE FROM seller WHERE id_seller = ?";
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1,id_seller);
					prepareStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//Final Delete Method
}
