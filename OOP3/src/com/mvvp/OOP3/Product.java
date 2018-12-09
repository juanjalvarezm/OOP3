package com.mvvp.OOP3;
import java.sql.*;

public class Product {
	public Provider provider = new Provider();
	//Insert Method
	public static void insert(int id_product, String name, int price, String description, int stock, int id_provider) {
		Connection connection = Connect.getConnection();
		if(connection != null ) {

			String query ="INSERT INTO product(id_product, name, description,stock,price,id_provider)  VALUES (?,?, ?,?, ?, ?)";
	
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setInt(1, id_product);
				prepareStatement.setString(2, name);
				prepareStatement.setString(3,description);
				prepareStatement.setInt(4, stock);
				prepareStatement.setInt(5,price);
				prepareStatement.setInt(6, id_provider);
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
