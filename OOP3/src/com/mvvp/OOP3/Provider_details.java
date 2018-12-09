package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Provider_details {
	//Insert Method
		public static void insert(int id_product,  int id_provider) {
			Connection connection = Connect.getConnection();
			if(connection != null ) {

				String query ="INSERT INTO provider_details(id_product, id_provider)  VALUES (?,?)";
		
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1, id_product);
					prepareStatement.setInt(2, id_provider);
					prepareStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//Final Insert Method
}
