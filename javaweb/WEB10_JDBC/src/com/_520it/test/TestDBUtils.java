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
	 * 查询count(*)的方法
	 * 
	 */
	@Test
	public void testCountUser() {
		try {
			//1.加载核心类QueryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2.sql语句
			String sql="select count(*) from user";
			//3.执行sql
			Long query = (Long) qr.query(sql, new ScalarHandler());
			System.out.println(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 根据id查询user的方法
	 */
	@Test
	public void testSelUserById() {
		try {
			//1.设置核心类QueryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2.设置sql语句
			String sql="select * from user where id=?";
			//3.设置占位符信息
			Object[] params = {2};
			//4.执行语句
			User user = qr.query(sql, new BeanHandler<User>(User.class), params);
				System.out.println(user.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有user的方法
	 */
	@Test
	public void testSelUser() {
		try {
			//1.设置核心类QueryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2.设置sql语句
			String sql="select * from user";
			//3.执行语句
			List<User> query = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : query) {
				System.out.println(user.getUname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除user方法
	 */
	@Test
	public void testDelUser() {
		try {
			//1.加载核心类
			QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
			//编写sql语句
			String sql="delete from user where uname=?";
			//为占位符设置信息
			Object[] param= {"耿耿"};
			int rows = qr.update(sql,param);
			if (rows>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新user方法
	 */
	@Test
	public void testUpdateUser() {
		try {
			//1.加载核心类
			QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
			//编写sql语句
			String sql="update user set id=? where uname=?";
			//为占位符设置信息
			Object[] param= {"20","耿耿"};
			int rows = qr.update(sql,param);
			if (rows>0) {
				System.out.println("更新成功");
			}else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 插入user方法
	 */
	@Test
	public void testAddUser() {
		try {
			//1.加载核心类
			QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
			//编写sql语句
			String sql="insert into user values(?,?,?)";
			//为占位符设置信息
			Object[] param= {10,"耿耿","余淮"};
			int rows = qr.update(sql,param);
			if (rows>0) {
				System.out.println("插入成功");
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
