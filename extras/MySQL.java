package de.luke.naruto.extras;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MySQL {
	

	
	
	private Connection con;
	
	private String host;
	private int port;
	private String database;
	private String user;
	private String password;
	
	public MySQL(String host, int port, String database, String user, String password) {
		
		this.host = host;
		this.port = port;
		this.database = database;
		this.user = user;
		this.password = password;
		
		connect();
		
	}

	
	public void connect() {
		

		
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", user, password);
		
			System.out.println("MySQL connected");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MySQL disconnected");
		}
			
		}
	
	public void disconnect() {
		

	try {
		 if (this.hasConnection()) {
		this.con.close();
		 }
	}	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	
	public boolean hasConnection() {
		if(this.con != null) {
			return true;
		} return false;
	}
	
	public void UpdateConnection() throws SQLException {
		

		if (con.isValid(0) == false) {
			
			
          disconnect();
        	connect();
        	System.out.println("NewConnection");
        	
        	
        	
        
		
		}
       }
	
	
	public Connection getConnection() throws SQLException {
		if (con.isValid(0) == false) {
			
			
	          disconnect();
	        	connect();
	        	
		}
		return this.con;
	}
	

public Connection getSafeConnection() {
	return this.con;
}
}



