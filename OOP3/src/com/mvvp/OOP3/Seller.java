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
}
