package com.mvvp.OOP3;

public class Provider {
	int id_provider; //PK
	String name; 
	String address;
	
	public static void create(String name, String address) {
		String create = "INSERT INTO proveedor VALUES (nextval(\'proveedor\')"+
	", \'"+name+"\', \'"+address+"\' )";
		Statement.Insert(create);
	}
}
