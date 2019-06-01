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
 * �ṩ���Ӻ͹ر���Դ�ķ���
 * @author Administrator
 *
 */
public class JDBCUtils_V3 {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * ��̬�����
	 */
	static {
		try {
			//1.ͨ����ǰ���ȡ�������
			ClassLoader classLoader =JDBCUtils_V3.class.getClassLoader();
			//2.ͨ����������ķ������һ��������
			InputStream is = classLoader.getResourceAsStream("db.properties");
			//3.����һ��properties����
			Properties properties =new Properties();
			//4.����������
			properties.load(is);
			//5.��ȡ��ز�����ֵ
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
	 *��ȡ���ӷ��� 
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
