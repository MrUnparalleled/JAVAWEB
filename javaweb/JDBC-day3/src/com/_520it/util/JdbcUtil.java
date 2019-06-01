package com._520it.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	//�������ݿ���Ҫ��
	private static Properties properties=new Properties();
	static {
		//���ض�ȡdb.properties�ļ�
		try {
		InputStream inStream=Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties");
		
			properties.load(inStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(properties.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					properties.getProperty("url"), 			//��ȡurl��ֵ
					properties.getProperty("username"), 	//��ȡusername��ֵ
					properties.getProperty("password"));	//��ȡpassword��ֵ
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if (resultSet!=null) {
				resultSet.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			try {
				if (statement!=null) {
					statement.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}finally {
				try {
					if (connection!=null) {
						connection.close();
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		}
	}
}
