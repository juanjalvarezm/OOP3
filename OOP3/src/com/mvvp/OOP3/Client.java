package com.mvvp.OOP3;

public class Client {
	int id_client; //PK
	int ci;
	int cellnumber;
	String address;
	
	public static void create(String name, int ci, String address, int cellnumber) {
		String create = "INSERT INTO cliente VALUES (nextval(\'client\')"+",\'"+
	"\' , \'"+ci+"\', \'"+address+"\', \'"+cellnumber+"\' )";
		Statement.Insert(create);
	}
}
