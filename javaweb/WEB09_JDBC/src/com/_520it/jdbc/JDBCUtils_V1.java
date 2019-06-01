package com._520it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 提供连接和关闭资源的方法
 * @author Administrator
 *
 */
public class JDBCUtils_V1 {
	//连接资源
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08","root","root");
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
