package com._520it.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

//import com.sun.javafx.scene.control.Properties;

public class DbcpUtil {
	private static DataSource ds=null;
	static {
		
		try {
			Properties p=new Properties();
			p.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("dbcp.properties"));
			ds=BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		try {
			//从连接池中获取Connection对象
			return ds.getConnection();
		} catch (SQLException e) {
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
