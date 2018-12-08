package com.mvvp.OOP3;

public class Seller {
	int id_seller; //PK
	String name;
	int turn;
	
	public static void create(String name, int turn, String address) {
		String create = "INSERT INTO vendedor VALUES (nextval(\'vendedor\')"+", \'"+name+"\', \'"+turn+"\', \'"+address+"\' )";
		Statement.Insert(create);
	}
}
