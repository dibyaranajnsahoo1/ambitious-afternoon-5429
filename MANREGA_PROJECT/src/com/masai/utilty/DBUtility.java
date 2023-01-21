package com.masai.utilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;

public class DBUtility {
	
<<<<<<< HEAD
	private static String url;
	private static String driverName;
	private static String username;
	private static String password;
	
	
	static {
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetail");
		
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
	
	
//	
//public static Connection provideConnection() {
=======
//	private static String url;
//	private static String driverName;
//	private static String username;
//	private static String password;
//	
//	
//	static {
//		
//		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
//		
//		driverName= rb.getString("db.driverName");
//		url= rb.getString("db.url");
//		username= rb.getString("db.username");
//		password= rb.getString("db.password");
//		
//		
//	}
//	
//	public static Connection  provideConnection() {
>>>>>>> 52a95b30d3b1f4997df6e55b4ece4400c0e169a1
//		
//		Connection conn = null;
//		
//		try {
<<<<<<< HEAD
//			Class.forName("com.mysql.cj.jdbc.Driver");
=======
//			Class.forName(driverName);
>>>>>>> 52a95b30d3b1f4997df6e55b4ece4400c0e169a1
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
<<<<<<< HEAD
//		
//		String url = "jdbc:mysql://localhost:3306/magnrega_project";
//		
//		try {
//			conn = DriverManager.getConnection(url,"root","Lalu@123");
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//		return conn;
//	}
=======
//
//		try {
//			conn= DriverManager.getConnection(url,username,password);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		return conn;
//}
	
	
	
public static Connection provideConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/magnrega_project";
		
		try {
			conn = DriverManager.getConnection(url,"root","Lalu@123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
>>>>>>> 52a95b30d3b1f4997df6e55b4ece4400c0e169a1

}
