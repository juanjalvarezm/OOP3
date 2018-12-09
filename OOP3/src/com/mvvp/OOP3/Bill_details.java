package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bill_details {
	//Insert Method
		public static void insert(int id_client, int id_product, int id_seller, int id_bill, int product_quantity, int sell_price) {
			Connection connection = Connect.getConnection();
			if(connection != null ) {

				String query ="INSERT INTO bill_details(id_client, id_product, id_seller,id_bill,product_quantity,sell_price)  VALUES (?,?, ?,?, ?, ?)";
		
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1, id_client);
					prepareStatement.setInt(2, id_product);
					prepareStatement.setInt(3,id_seller);
					prepareStatement.setInt(4, id_bill);
					prepareStatement.setInt(5,product_quantity);
					prepareStatement.setInt(6, sell_price);
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
