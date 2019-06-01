package com._520it.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSourceUtils {
	
	//��ȡ���ӳ�
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl =new ThreadLocal<Connection>();
	
	//��ȡ��ǰ�߳�����
	public static Connection getCurrentConnection() throws SQLException {
		Connection conn = tl.get();
		if (conn==null) {
			conn=getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	//��ȡ����
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//��������
	public static void startTransaction() throws SQLException {
		getCurrentConnection().setAutoCommit(false);
	}
	
	//�ύ����
	public static void commitTransaction() throws SQLException {
		Connection connection =getCurrentConnection();
		connection.commit();
		//��connection�Ƴ�
		tl.remove();
		connection.close();
	}
	
	//�ع�����
	public static void rollbackTransaction() throws SQLException {
		getCurrentConnection().rollback();
	}
}
