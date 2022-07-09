package com.circuits99.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection createConnection() {
//		Properties prop = PropertyFileReader.getValues();
		String DRIVER_CLASS = "org.postgresql.Driver";//prop.getProperty("DRIVER_CLASS");
		String DB_URL = "jdbc:postgresql://ec2-3-222-74-92.compute-1.amazonaws.com/da5bl47d3v2b0g";//prop.getProperty("DB_URL");
		String DB_USERNAME = "rnpkwzrskpimvc";//prop.getProperty("DB_USERNAME");
		String DB_PASSWORD = "c4d7e243169c35550a284510ff2b4d67b5de4babeae9cf9a1c10cfe0967e1d0d";//prop.getProperty("DB_PASSWORD");
		Connection connection = null;
		try {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}if(con != null) {
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(createConnection());
	}
}
