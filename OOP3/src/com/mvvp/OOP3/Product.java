package com.mvvp.OOP3;

public class Product {
	int id_product; //PK
	double price; 
	int stock;
	String description;
	
	public static void create(double price, String description) {
		String create = "INSERT INT product VALUES (nextval(\'product\')"+","+price+" , \'"+description+"\',0)";
		Statement.Insert(create);
	}
}
