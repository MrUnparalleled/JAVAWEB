package com._520it.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class TestLogin {
	public void login(String username, String password) throws Exception {
		// ����ע������
		Class.forName("com.mysql.jdbc.Driver");
		// ��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// sql���
		String sql = "select * from user where uname = '" + username + "' and upassword = '" + password + "'";
		// ����ִ��sql������
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		// ��������
		if (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String pwd = resultSet.getString(3);
			System.out.println("id:" + id + "name:" + name + "pwd:" + pwd);
		}
		// �ر���Դ----------�ȵõ��ĺ�ر�
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
		// ����ע������
		Class.forName("com.mysql.jdbc.Driver");
		// ��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// sql���
		String sql = "select * from user where uname =? and upassword = ?";
		//����Ԥ�������
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		//����ռλ������
		prepareStatement.setString(1, username);
		prepareStatement.setString(2, passwrd);
		//ִ��sql���
		ResultSet query = prepareStatement.executeQuery();
		//��������
		if (query.next()) {
			int id = query.getInt(1);
			String name = query.getString(2);
			String pwd = query.getString(3);
			System.out.println("id:" + id + "name:" + name + "pwd:" + pwd);
		}
		//�ر���Դ
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
