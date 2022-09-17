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
		String DB_URL = "jdbc:postgresql://ec2-3-219-52-220.compute-1.amazonaws.com/d1lqnd2lfi81s2";//prop.getProperty("DB_URL");
		String DB_USERNAME = "gcubzjzfqmutgq";//prop.getProperty("DB_USERNAME");
		String DB_PASSWORD = "396e6a098f8ccc1b1fb929b9e2267f80e5f9b94b45356971be58b8b4208e9119";//prop.getProperty("DB_PASSWORD");
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
