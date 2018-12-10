package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Provider {
	//Insert Method
	public static void insert(int id_provider, String name, String address) {
		Connection connection = Connect.getConnection();
		if(connection != null ) {

			String query ="INSERT INTO provider(id_product, name, address)  VALUES (?,?, ?)";
	
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setInt(1, id_provider);
				prepareStatement.setString(2, name);
				prepareStatement.setString(3,address);
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
			String query = "UPDATE provider SET "+column+"= ? WHERE id_product = ?";
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
	public void delete(int id_provider) {
		Connection connection = Connect.getConnection();
		if(connection != null) {
			String query = "DELETE FROM provider WHERE id_provider = ?";
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setInt(1,id_provider);
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
	
	//Read Method 
			public void read() {
				Connection connection  = Connect.getConnection();
				if(connection != null) {
					Statement stmt = null;
					String query = "SELECT * FROM provider";
					try {
						stmt = connection.createStatement();
						ResultSet rs  = stmt.executeQuery(query);
						while(rs.next()) {
							
							Integer id_provider = rs.getInt("id_provider");
							String name =rs.getString("name");
							String address = rs.getString("address");
							System.out.println("ID: "+id_provider+"|"
												+" Client Name = "+name+"|"
												+" Address = "+address+"\n");
						}
					}catch(SQLException e) {
						System.out.println(e);
					}finally {
						if(stmt != null) {
							try {
								stmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					try {
						connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
				}
			}//Final Read Method
	
}
