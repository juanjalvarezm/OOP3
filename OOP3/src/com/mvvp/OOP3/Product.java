package com.mvvp.OOP3;
import java.sql.*;

public class Product {
	public Provider provider = new Provider();
	
	
	
	public static String create(String name, int price, String description, int stock, int id_provider) {
		return "INSERT INTO product(id_product, name, description,stock,price,id_provider)  VALUES (?,?, ?,?, ?, ?)";
	}
	public static void insert(int id_product, String name, int price, String description, int stock, int id_provider) {
		Connection connection = Connect.getConnection();
		Statement stmt = null;
		if(connection != null ) {

			String query ="INSERT INTO product(id_product, name, description,stock,price,id_provider)  VALUES (?,?, ?,?, ?, ?)";
	
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setInt(1, 1);
				prepareStatement.setString(2, name);
				prepareStatement.setString(3,"Mayonesa Deliciosa");
				prepareStatement.setInt(4, stock);
				prepareStatement.setInt(5,price);
				prepareStatement.setInt(6, id_provider);
				prepareStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			/*try {
				stmt =  connection.createStatement();
				stmt.executeUpdate(query);
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				if(stmt != null) {
					try {
					connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}
	}
}
