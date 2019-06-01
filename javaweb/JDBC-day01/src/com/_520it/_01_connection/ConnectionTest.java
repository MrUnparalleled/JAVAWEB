package com._520it._01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class ConnectionTest {
	static final  String DB_URL="jdbc:mysql://localhost:3306/jdbcdemo"+"?serverTimezone=GMT%2B8";
	@Test
	public void test1() throws Exception {
		String sql="CREATE TABLE t_student(id bigint(20) primary key auto_increment,name varchar(20));";
		//加载注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//获取连接对象
		Connection conn=DriverManager.getConnection(DB_URL, "root", "root");
		Statement state= conn.createStatement();
		int i=state.executeUpdate(sql);
		state.close();
		conn.close();
		
		System.out.println(i);
		
		
	}
}
