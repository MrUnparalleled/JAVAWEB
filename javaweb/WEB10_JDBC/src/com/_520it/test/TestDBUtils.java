package com._520it.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com._520it.domain.User;
import com._520it.utils.C3P0Utils;

public class TestDBUtils {
	
	/**
	 * ��ѯcount(*)�ķ���
	 * 
	 */
	@Test
	public void testCountUser() {
		try {
			//1.���غ�����QueryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2.sql���
			String sql="select count(*) from user";
			//3.ִ��sql
			Long query = (Long) qr.query(sql, new ScalarHandler());
			System.out.println(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * ����id��ѯuser�ķ���
	 */
	@Test
	public void testSelUserById() {
		try {
			//1.���ú�����QueryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2.����sql���
			String sql="select * from user where id=?";
			//3.����ռλ����Ϣ
			Object[] params = {2};
			//4.ִ�����
			User user = qr.query(sql, new BeanHandler<User>(User.class), params);
				System.out.println(user.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ѯ����user�ķ���
	 */
	@Test
	public void testSelUser() {
		try {
			//1.���ú�����QueryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2.����sql���
			String sql="select * from user";
			//3.ִ�����
			List<User> query = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : query) {
				System.out.println(user.getUname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ɾ��user����
	 */
	@Test
	public void testDelUser() {
		try {
			//1.���غ�����
			QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
			//��дsql���
			String sql="delete from user where uname=?";
			//Ϊռλ��������Ϣ
			Object[] param= {"����"};
			int rows = qr.update(sql,param);
			if (rows>0) {
				System.out.println("ɾ���ɹ�");
			}else {
				System.out.println("ɾ��ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����user����
	 */
	@Test
	public void testUpdateUser() {
		try {
			//1.���غ�����
			QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
			//��дsql���
			String sql="update user set id=? where uname=?";
			//Ϊռλ��������Ϣ
			Object[] param= {"20","����"};
			int rows = qr.update(sql,param);
			if (rows>0) {
				System.out.println("���³ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����user����
	 */
	@Test
	public void testAddUser() {
		try {
			//1.���غ�����
			QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
			//��дsql���
			String sql="insert into user values(?,?,?)";
			//Ϊռλ��������Ϣ
			Object[] param= {10,"����","�໴"};
			int rows = qr.update(sql,param);
			if (rows>0) {
				System.out.println("����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
