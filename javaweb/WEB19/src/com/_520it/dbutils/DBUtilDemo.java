package com._520it.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com._520it.utils.DataSourceUtils;

public class DBUtilDemo {
	
	public static void main(String[] args) {
		//DBUtil实现事务
		Connection connection=null;
		try {
			//1.核心类
			QueryRunner qRunner=new QueryRunner();
			//2.sql语句
			String sql="insert into account values(null,?,?)";
			//3.为占位符赋值
			Object[] params = {"lucy",5000};
			
			connection = DataSourceUtils.getConnection();
			//开启事务
			connection.setAutoCommit(false);
			//执行sql语句
			qRunner.update(connection, sql, params);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
