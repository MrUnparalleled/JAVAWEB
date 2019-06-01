package com._520it.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com._520it.utils.DataSourceUtils;

public class DBUtilDemo {
	
	public static void main(String[] args) {
		//DBUtilʵ������
		Connection connection=null;
		try {
			//1.������
			QueryRunner qRunner=new QueryRunner();
			//2.sql���
			String sql="insert into account values(null,?,?)";
			//3.Ϊռλ����ֵ
			Object[] params = {"lucy",5000};
			
			connection = DataSourceUtils.getConnection();
			//��������
			connection.setAutoCommit(false);
			//ִ��sql���
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
