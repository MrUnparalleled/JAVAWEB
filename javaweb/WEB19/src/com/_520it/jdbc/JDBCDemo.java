package com._520it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	//JDBCʵ������
	public static void main(String[] args) {
		Connection conn=null;
		try {
			//1.����ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql:///web19", "root", "root");
			//��������
			conn.setAutoCommit(false);
			//3.��ȡִ��ƽ̨
			Statement statement = conn.createStatement();
			//4.ִ��sql����
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
