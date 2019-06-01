package com._520it.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;

import com._520it.utils.C3P0Utils;
import com._520it.utils.JDBCUtils_V3;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0 {

	@Test
	public void testUser2() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet query=null;
		try {
			//2.�����ӳ��л�ȡ����
			conn = C3P0Utils.getConnection();
			String sql="select * from user";
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
	@Test
	public void testUser1() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet query=null;
		//1.�������ӳض���
		DataSource source= new ComboPooledDataSource();//ʹ��Ĭ������
		//DataSource source= new ComboPooledDataSource("oracl");//ʹ����Ϊoracle������
		try {
			//2.�����ӳ��л�ȡ����
			conn = source.getConnection();
			String sql="select * from user";
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
}
