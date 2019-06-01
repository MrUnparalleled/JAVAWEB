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
	 * ����id���и��Ĳ���
	 */
	@Test
	public void testUpdate() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//��ȡ����
			conn=JDBCUtils_V3.getConnection();
			//sql���
			String sql="update user set upassword=? where id=?";
			//��ȡԤ����������
			pstmt = conn.prepareStatement(sql);
			//����ռλ��
			pstmt.setString(1, "qweqwe");
			pstmt.setInt(2, 2);
			//ִ��sql���
			int row = pstmt.executeUpdate();
			if (row>0) {
				System.out.println("���³ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V3.close(conn, pstmt, null);
		}
	}
	
	
	/**
	 * �h������
	 */
	@Test
	public void testDel() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//��ȡ����
			conn=JDBCUtils_V3.getConnection();
			//sql���
			String sql="delete from user where id=?";
			//��ȡԤ����������
			pstmt = conn.prepareStatement(sql);
			//����ռλ��
			pstmt.setInt(1, 1);
			//ִ��sql���
			int row = pstmt.executeUpdate();
			if (row>0) {
				System.out.println("�h���ɹ�");
			}else {
				System.out.println("�h��ʧ��");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V3.close(conn, pstmt, null);
		}
	}
	
	
	
	
	/**
	 * �������
	 */
	@Test
	public void testAdd() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//��ȡ����
			conn=JDBCUtils_V2.getConnection();
			//sql���
			String sql="insert into user values(?,?,?)";
			//��ȡԤ����������
			pstmt = conn.prepareStatement(sql);
			//����ռλ��
			pstmt.setInt(1, 6);
			pstmt.setString(2, "ww");
			pstmt.setString(3, "123");
			//ִ��sql���
			int row = pstmt.executeUpdate();
			if (row>0) {
				System.out.println("��ӳɹ�");
			}else {
				System.out.println("���ʧ��");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V2.close(conn, pstmt, null);
		}
	}
	
	
	
	/**
	 * ����id��ѯ�û���Ϣ
	 */
	@Test
	public void testId() {
		Connection conn=null; 
		PreparedStatement preparedStatement=null;
		ResultSet query=null;
		try {
			//������Ӷ���
			conn = JDBCUtils_V1.getConnection();
			//��дsql���
			String sql="select * from user where id =?";
			//���Ԥִ�ж���
			preparedStatement =conn.prepareStatement(sql);
			//����ռλ������
			preparedStatement.setInt(1, 1);
			//ִ��sql���
			query = preparedStatement.executeQuery();
			//��������
			while (query.next()) {
				int id = query.getInt(1);
				String name = query.getString(2);
				String password = query.getString(3);
				System.out.println("id:"+id+"name:"+name+"pwd:"+password);
			}
			//�ر���Դ���ܷ���try���棬��ֹ���������������£�������Դһֱ���رգ�����ռ����Դ
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ر���Դ
			JDBCUtils_V1.close(conn, preparedStatement, query);
		}
		
	}
}
