package com._520it._02dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DMLTest {
	//����1����T_student���в��룬�Ƿ壬30
	static final String DB="jdbc:mysql:///jdbcdemo"+"?serverTimezone=GMT%2B8";
	@Test
	public void testInsert() throws Exception{
		String sql="INSERT INTO t_student (name,age)VALUES ('�Ƿ�',30)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(DB, "root", "root");
		Statement statement=connection.createStatement();
		int i=statement.executeUpdate(sql);
		statement.close();
		connection.close();
		System.out.println(i);
	}
	//����2�� ��idΪ1 ��ѧ�������ָ�Ϊ���Ŵ�ѩ�������Ϊ28
	@Test
	public void testUpdate() throws Exception{
		String sql="UPDATE t_student SET name='���Ŵ�ѩ' WHERE id=1";
	 	Connection conn= DriverManager.getConnection(DB, "root", "root");
		Statement statement=conn.createStatement();
		int i=statement.executeUpdate(sql);
		statement.close();
		conn.close();
		System.out.println(i);
	}
	//����3����idΪ1��ѧ��ɾ��
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
