package com._520it.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com._520it.utils.JDBCUtils_V3;

public class MyDataSource1 implements DataSource{
	
	//创建一个空间来存放Connection
	private static LinkedList<Connection> pool =new LinkedList<Connection>();
	static {
		//初始创建5个连接放到自定义连接池当中
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils_V3.getConnection();
			//放入池子中的connection已经经过改造了
			MyConnection myconn=new MyConnection(conn, pool);
			pool.add(myconn);
		}
	}

	/**
	 * 将连接放回到连接池的方法
	 * @param conn
	 */
	public void backConnection(Connection conn) {
		pool.add(conn);
	}
	/**
	 * 重写从连接池当中获取连接的方法
	 */
	@Override
	public Connection getConnection() throws SQLException {
		//先判断连接池当中是否还有连接
		Connection conn=null;
		if (pool.size()==0) {
			for (int i = 0; i < 5; i++) {
				conn = JDBCUtils_V3.getConnection();
				//放入池子中的connection已经经过改造了
				MyConnection myconn=new MyConnection(conn, pool);
				pool.add(myconn);
			}
		}
		//从连接池当中获取一个连接
		conn = pool.remove(0);
		return conn;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
