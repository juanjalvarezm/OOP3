package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Devolutions {
	//Insert Method
		public static void insert(int id_bill, int id_devol, int id_product_devol, int quantity_devol, int id_client_devol) {
			Connection connection = Connect.getConnection();
			if(connection != null ) {

				String query ="INSERT INTO Devolutions(id_bill, id_devol, id_product_devol, quantity_devol, id_client_devol)  VALUES (?,?,?,?,?)";
		
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1, id_bill);
					prepareStatement.setInt(2, id_devol);
					prepareStatement.setInt(3,id_product_devol);
					prepareStatement.setInt(4, quantity_devol);
					prepareStatement.setInt(5,id_client_devol);
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
		
		//Update Method
		public void update(String column, String value, int id_devol) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "UPDATE devolutions SET "+column+" = "+value+" WHERE id_devol = "+id_devol;
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//Final update method
		
		//Delete Method
		public void delete(int id_devol) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "DELETE FROM devolutions WHERE id_devol = ?";
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1,id_devol);
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
						String query = "SELECT * FROM devolutions_view";
						try {
							stmt = connection.createStatement();
							ResultSet rs  = stmt.executeQuery(query);
							while(rs.next()) {
								
								Integer id_devol = rs.getInt("devolid");
								Integer billid =rs.getInt("billid");
								String product = rs.getString("product");
								Integer quantity = rs.getInt("quantity");
								String client = rs.getString("client");
								Integer clientid = rs.getInt("clientid");
								System.out.println("ID: "+id_devol+"|"
													+" Bill ID = "+billid+"|"
													+" Product Name = "+product+"|"
													+" Quantity = "+quantity+"|"
													+" Client Name = "+client
													+" Client ID = "+clientid+"\n");
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
