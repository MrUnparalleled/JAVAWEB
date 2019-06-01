package com._520it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 提供连接和关闭资源的方法
 * @author Administrator
 *
 */
public class JDBCUtils_V2 {
	
	/**
	 * 静态代码块
	 */
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}
	
	
	
	
	
	/**
	 *获取连接方法 
	 * @return connection
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void close(Connection conn,PreparedStatement stmt,ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
}
