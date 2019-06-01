package com._520it.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com._520it.DataSource.MyDataSource;
import com._520it.DataSource.MyDataSource1;
import com._520it.utils.JDBCUtils_V3;

public class TestMyDataSource {

	/**
	 * 改造过的connection
	 */
	@Test
	public void testUser1() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet query=null;
		//1.创建自定义的连接池对象
		MyDataSource1 source =new MyDataSource1();
		try {
			//2.从连接池中获取连接
			conn = source.getConnection();
			String sql="select * from user";
			//3.必须在MyConnection类中重写conn.prepareStatement(sql)方法！！！
			pstmt = conn.prepareStatement(sql);
			query = pstmt.executeQuery();
			while (query.next()) {
				System.out.println(query.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils_V3.close(conn, pstmt, query);
		}
	}
	/**
	 * 没有改造过的connection
	 */
	@Test
	public void testUser() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet query=null;
		//1.创建自定义的连接池对象
		MyDataSource source =new MyDataSource();
		try {
			//2.从连接池中获取连接
			conn = source.getConnection();
			String sql="select * from user";
			pstmt = conn.prepareStatement(sql);
			query = pstmt.executeQuery();
			if (query.next()) {
				System.out.println(query.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			source.backConnection(conn);
		}
	}
}
