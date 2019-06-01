package com._520it.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 提供连接和关闭资源的方法
 * @author Administrator
 *
 */
public class JDBCUtils_V3 {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * 静态代码块
	 */
	static {
		try {
			//1.通过当前类获取类加载器
			ClassLoader classLoader =JDBCUtils_V3.class.getClassLoader();
			//2.通过类加载器的方法获得一个输入流
			InputStream is = classLoader.getResourceAsStream("db.properties");
			//3.创建一个properties对象
			Properties properties =new Properties();
			//4.加载输入流
			properties.load(is);
			//5.获取相关参数的值
			driver =properties.getProperty("driver");
			url =properties.getProperty("url");
			username =properties.getProperty("username");
			password =properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
//		ResourceBundle bundle = ResourceBundle.getBundle("db");
//		driver = bundle.getString("driver");
//		url = bundle.getString("url");
//		username = bundle.getString("username");
//		password = bundle.getString("password");
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
