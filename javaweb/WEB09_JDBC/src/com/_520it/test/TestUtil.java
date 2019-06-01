package com._520it.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com._520it.jdbc.JDBCUtils_V1;
import com._520it.jdbc.JDBCUtils_V2;
import com._520it.jdbc.JDBCUtils_V3;


public class TestUtil {
	/**
	 * 根据id进行更改操作
	 */
	@Test
	public void testUpdate() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//获取连接
			conn=JDBCUtils_V3.getConnection();
			//sql语句
			String sql="update user set upassword=? where id=?";
			//获取预编译语句对象
			pstmt = conn.prepareStatement(sql);
			//设置占位符
			pstmt.setString(1, "qweqwe");
			pstmt.setInt(2, 2);
			//执行sql语句
			int row = pstmt.executeUpdate();
			if (row>0) {
				System.out.println("更新成功");
			}else {
				System.out.println("更新失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V3.close(conn, pstmt, null);
		}
	}
	
	
	/**
	 * 刪除操作
	 */
	@Test
	public void testDel() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//获取连接
			conn=JDBCUtils_V3.getConnection();
			//sql语句
			String sql="delete from user where id=?";
			//获取预编译语句对象
			pstmt = conn.prepareStatement(sql);
			//设置占位符
			pstmt.setInt(1, 1);
			//执行sql语句
			int row = pstmt.executeUpdate();
			if (row>0) {
				System.out.println("刪除成功");
			}else {
				System.out.println("刪除失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V3.close(conn, pstmt, null);
		}
	}
	
	
	
	
	/**
	 * 插入操作
	 */
	@Test
	public void testAdd() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//获取连接
			conn=JDBCUtils_V2.getConnection();
			//sql语句
			String sql="insert into user values(?,?,?)";
			//获取预编译语句对象
			pstmt = conn.prepareStatement(sql);
			//设置占位符
			pstmt.setInt(1, 6);
			pstmt.setString(2, "ww");
			pstmt.setString(3, "123");
			//执行sql语句
			int row = pstmt.executeUpdate();
			if (row>0) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V2.close(conn, pstmt, null);
		}
	}
	
	
	
	/**
	 * 根据id查询用户信息
	 */
	@Test
	public void testId() {
		Connection conn=null; 
		PreparedStatement preparedStatement=null;
		ResultSet query=null;
		try {
			//获得连接对象
			conn = JDBCUtils_V1.getConnection();
			//书写sql语句
			String sql="select * from user where id =?";
			//获得预执行对象
			preparedStatement =conn.prepareStatement(sql);
			//设置占位符参数
			preparedStatement.setInt(1, 1);
			//执行sql语句
			query = preparedStatement.executeQuery();
			//处理结果集
			while (query.next()) {
				int id = query.getInt(1);
				String name = query.getString(2);
				String password = query.getString(3);
				System.out.println("id:"+id+"name:"+name+"pwd:"+password);
			}
			//关闭资源不能放在try里面，防止上面语句出错的情况下，导致资源一直不关闭！！！占用资源
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			JDBCUtils_V1.close(conn, preparedStatement, query);
		}
		
	}
}
