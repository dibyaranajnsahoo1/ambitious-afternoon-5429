package com.masai.utilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;

public class DBUtility {
	
	private static String url;
	private static String driverName;
	private static String username;
	private static String password;
	
	
	static {
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		
		driverName= rb.getString("db.driverName");
		url= rb.getString("db.url");
		username= rb.getString("db.username");
		password= rb.getString("db.password");
		
		
	}
	
	public static Connection  provideConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conn= DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
}
}