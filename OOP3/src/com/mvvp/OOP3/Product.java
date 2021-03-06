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
	
	//Update Method
			public void update(String column, String value, int id_product) {
				Connection connection = Connect.getConnection();
				if(connection != null) {
					String query = "UPDATE product SET "+column+"= ? WHERE id_product = ?";
					try {
						PreparedStatement prepareStatement = connection.prepareStatement(query);
						prepareStatement.setString(1, value);
						prepareStatement.setInt(2,id_product);
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
			}//Final update method
			
			//Delete Method
			public void delete(int id_product) {
				Connection connection = Connect.getConnection();
				if(connection != null) {
					String query = "DELETE FROM product WHERE id_product = ?";
					try {
						PreparedStatement prepareStatement = connection.prepareStatement(query);
						prepareStatement.setInt(1,id_product);
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
					String query = "SELECT * FROM product_view";
					try {
						stmt = connection.createStatement();
						ResultSet rs  = stmt.executeQuery(query);
						while(rs.next()) {
							
							Integer productid = rs.getInt("productid");
							String nameproduct =rs.getString("nameproduct");
							String descripproduct = rs.getString("descripproduct");
							Integer stock = rs.getInt("stock");
							Integer price = rs.getInt("price");
							String provider = rs.getString("provider");
							System.out.println("ID: "+productid+"|"
												+" Product Name = "+nameproduct+"|"
												+" Product Description = "+descripproduct+"|"
												+" Stock = "+stock+"|"
												+" Price = "+price+"|"
												+" Provider = "+provider+"\n");
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
