package com._520it.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class TestLogin {
	public void login(String username, String password) throws Exception {
		// 加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// sql语句
		String sql = "select * from user where uname = '" + username + "' and upassword = '" + password + "'";
		// 创建执行sql语句对象
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		// 处理结果集
		if (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String pwd = resultSet.getString(3);
			System.out.println("id:" + id + "name:" + name + "pwd:" + pwd);
		}
		// 关闭资源----------先得到的后关闭
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public void login1(String username, String passwrd) throws Exception {
		// 加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// sql语句
		String sql = "select * from user where uname =? and upassword = ?";
		//创建预编译对象
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		//设置占位符参数
		prepareStatement.setString(1, username);
		prepareStatement.setString(2, passwrd);
		//执行sql语句
		ResultSet query = prepareStatement.executeQuery();
		//处理结果集
		if (query.next()) {
			int id = query.getInt(1);
			String name = query.getString(2);
			String pwd = query.getString(3);
			System.out.println("id:" + id + "name:" + name + "pwd:" + pwd);
		}
		//关闭资源
		if (query != null) {
			query.close();
		}
		if (prepareStatement != null) {
			prepareStatement.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
