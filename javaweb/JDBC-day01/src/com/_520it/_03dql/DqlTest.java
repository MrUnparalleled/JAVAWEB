package com._520it._03dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;


public class DqlTest {
	//需求1：查询t_student表中一共有多少条学生信息
	static final String DB="jdbc:mysql:///jdbcdemo"+"?serverTimezone=GMT%2B8";
	@Test
	public void Test1() throws Exception{
		String sql="SELECT COUNT(*) FROM t_student";
		Connection connection=DriverManager.getConnection(DB, "root", "root");
		Statement statement=connection.createStatement();
		ResultSet set = statement.executeQuery(sql);
		if (set.next()) {
			long totalCount=set.getLong(1);
			System.out.println(totalCount);
		}
		set.close();
		statement.close();
		connection.close();
		
	}
	//需求2：查询t_student表中id为1 的学生信息
	@Test
	public void Test2() throws Exception{
		String sql="SELECT * FROM t_student WHERE id=14";
		Connection connection=DriverManager.getConnection(DB, "root", "root");
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(sql);
		if (resultSet.next()) {
		long id=resultSet.getLong("id");
		String name=resultSet.getString("name");
		int age=resultSet.getInt("age");
			System.out.println(id+","+name+","+age);
		}
		resultSet.close();
		statement.close();
		connection.close();
		
	}
	//需求3：查询t_student表中所有的学生信息
	@Test
	public void Test3() throws Exception{
		String sql="SELECT * FROM t_student";
		Connection connection=DriverManager.getConnection(DB, "root", "root");
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(sql);
		while (resultSet.next()) {
		long id=resultSet.getLong("id");
		String name=resultSet.getString("name");
		int age=resultSet.getInt("age");
			System.out.println(id+","+name+","+age);
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
}
