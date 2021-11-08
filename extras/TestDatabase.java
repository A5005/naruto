package de.luke.naruto.extras;


public class TestDatabase {
	

	public static MySQL mysql;
	
	public static void setUp() {
		loadMySQL();
		
	}
	
	//https://webphpmyadmin.com/
	
	public static void loadMySQL() {
		mysql = new MySQL("remotemysql.com", 3306, "PLScCERvj5", "PLScCERvj5", "5SQVjPa69W");
	}                      

}
