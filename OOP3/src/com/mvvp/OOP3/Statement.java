package com.mvvp.OOP3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
public class Statement {
	public static void Insert(String statement) {
		try {
			PreparedStatement p;
			p = Connect.getConnection().prepareStatement(statement);
			p.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static List<Result1> getIDandName(int id, String table) throws SQLException{
		List<Result1> results = new ArrayList<Result1>();
		Connection connection = null;
		PreparedStatement p = null;
		ResultSet resultSet = null;
		String statement = "SELECT * FROM "+table+" "+" WHERE "+table+"_id= "+id;
		try {
			connection = Connect.getConnection();
			p = connection.prepareStatement(statement);
			resultSet = p.executeQuery();
			while(resultSet.next()) {
				Result1 result  = new Result1();
				result.setId(resultSet.getInt(table + "_id"));
				result.setName(resultSet.getString("Nombres"));
				results.add(result);
			}
		}
		finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				}catch (SQLException ignore) {}
				}
			if(p!=null) {
				try {
					p.close();
				}catch (SQLException ignore) {
				}
			}
			return results;
		}
	}
		@SuppressWarnings("finally")
		public static boolean Exists(int id, String table){
			PreparedStatement p;
			ResultSet r; 
			try {
				String statement = "SELECT * "+"FROM "+table+" "+"WHERE "+table+"_id = "+id;
				p = Connect.getConnection().prepareStatement(statement);
				r = p.executeQuery();
				return r.next();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				return false;
			}
		}
	}

