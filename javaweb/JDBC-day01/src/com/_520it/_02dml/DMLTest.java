package com._520it._02dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DMLTest {
	//需求1：汪T_student表中插入，乔峰，30
	static final String DB="jdbc:mysql:///jdbcdemo"+"?serverTimezone=GMT%2B8";
	@Test
	public void testInsert() throws Exception{
		String sql="INSERT INTO t_student (name,age)VALUES ('乔峰',30)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(DB, "root", "root");
		Statement statement=connection.createStatement();
		int i=statement.executeUpdate(sql);
		statement.close();
		connection.close();
		System.out.println(i);
	}
	//需求2： 把id为1 的学生的名字改为西门吹雪，年龄改为28
	@Test
	public void testUpdate() throws Exception{
		String sql="UPDATE t_student SET name='西门吹雪' WHERE id=1";
	 	Connection conn= DriverManager.getConnection(DB, "root", "root");
		Statement statement=conn.createStatement();
		int i=statement.executeUpdate(sql);
		statement.close();
		conn.close();
		System.out.println(i);
	}
	//需求3：把id为1的学生删掉
	@Test
	public void testDelete() throws Exception{
		String SQL="DELETE FROM t_student WHERE id=1";
		Connection connection=DriverManager.getConnection("jdbc:mysql:///jdbcdemo?serverTimezone=GMT%2B8", "root", "root");
		Statement statement=connection.createStatement();
		statement.executeLargeUpdate(SQL);
		statement.close();
		connection.close();
	}
}
