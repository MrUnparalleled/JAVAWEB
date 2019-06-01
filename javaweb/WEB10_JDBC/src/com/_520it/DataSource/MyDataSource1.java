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
	
	//����һ���ռ������Connection
	private static LinkedList<Connection> pool =new LinkedList<Connection>();
	static {
		//��ʼ����5�����ӷŵ��Զ������ӳص���
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils_V3.getConnection();
			//��������е�connection�Ѿ�����������
			MyConnection myconn=new MyConnection(conn, pool);
			pool.add(myconn);
		}
	}

	/**
	 * �����ӷŻص����ӳصķ���
	 * @param conn
	 */
	public void backConnection(Connection conn) {
		pool.add(conn);
	}
	/**
	 * ��д�����ӳص��л�ȡ���ӵķ���
	 */
	@Override
	public Connection getConnection() throws SQLException {
		//���ж����ӳص����Ƿ�������
		Connection conn=null;
		if (pool.size()==0) {
			for (int i = 0; i < 5; i++) {
				conn = JDBCUtils_V3.getConnection();
				//��������е�connection�Ѿ�����������
				MyConnection myconn=new MyConnection(conn, pool);
				pool.add(myconn);
			}
		}
		//�����ӳص��л�ȡһ������
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
