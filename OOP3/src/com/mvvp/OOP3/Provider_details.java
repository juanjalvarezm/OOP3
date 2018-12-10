package com.mvvp.OOP3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		//Update Method
		public void update(String column, String value, int id_detail) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "UPDATE provider_details SET "+column+"= ? WHERE id_detail = ?";
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setString(1, value);
					prepareStatement.setInt(2,id_detail);
					prepareStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//Final update method
		
		//Delete Method
		public void delete(int id_detail) {
			Connection connection = Connect.getConnection();
			if(connection != null) {
				String query = "DELETE FROM provider_details WHERE id_detail = ?";
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(query);
					prepareStatement.setInt(1,id_detail);
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
						String query = "SELECT * FROM provider_details_view";
						try {
							stmt = connection.createStatement();
							ResultSet rs  = stmt.executeQuery(query);
							while(rs.next()) {
								
								Integer detailid = rs.getInt("detailid");
								Integer providerid =rs.getInt("providerid");
								String providername = rs.getString("providername");
								Integer productid = rs.getInt("productid");
								String productname = rs.getString("productname");
								System.out.println("ID: "+detailid+"|"
													+" Provider ID = "+providerid+"|"
													+" Provider Name = "+providername+"|"
													+" Product ID = "+productid+"|"
													+" Product Name = "+productname+"\n");
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
