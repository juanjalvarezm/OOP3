package com.mvvp.OOP3;
import java.sql.*;

public class Statement2 {
	Connection connection = Connect.getConnection();
	public void Insert (String statement) {
		if(connection != null) {
			Statement stmt = null;
			try {
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(statement)
			}
		}
	}
}
