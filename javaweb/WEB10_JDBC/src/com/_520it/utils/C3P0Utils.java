package com._520it.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource source=new ComboPooledDataSource("oracl");
	public static DataSource getDataSource() {
		return source;
	}
	public static Connection getConnection() {
		try {
			return  source.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
