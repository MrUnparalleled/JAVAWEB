package com._520it.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSourceUtils {
	
	//获取连接池
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl =new ThreadLocal<Connection>();
	
	//获取当前线程连接
	public static Connection getCurrentConnection() throws SQLException {
		Connection conn = tl.get();
		if (conn==null) {
			conn=getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//开启事务
	public static void startTransaction() throws SQLException {
		getCurrentConnection().setAutoCommit(false);
	}
	
	//提交事务
	public static void commitTransaction() throws SQLException {
		Connection connection =getCurrentConnection();
		connection.commit();
		//将connection移除
		tl.remove();
		connection.close();
	}
	
	//回滚事务
	public static void rollbackTransaction() throws SQLException {
		getCurrentConnection().rollback();
	}
}
