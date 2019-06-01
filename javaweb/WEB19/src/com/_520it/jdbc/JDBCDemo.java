package com._520it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	//JDBC实现事务
	public static void main(String[] args) {
		Connection conn=null;
		try {
			//1.加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection("jdbc:mysql:///web19", "root", "root");
			//开启事务
			conn.setAutoCommit(false);
			//3.获取执行平台
			Statement statement = conn.createStatement();
			//4.执行sql操作
			int rows = statement.executeUpdate("insert into account values(null,'kitty',3000)");
			if (rows>0) {
				conn.commit();
			}else if (rows<=0) {
				conn.rollback();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	
}
