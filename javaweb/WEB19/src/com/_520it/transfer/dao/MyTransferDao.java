package com._520it.transfer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com._520it.utils.MyDataSourceUtils;

public class MyTransferDao {

	public void in(String in, String money) throws SQLException {
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		QueryRunner runner =new QueryRunner();
		String sql="update account set money=money+? where name=?";
		runner.update(conn, sql, money,in);
	}

	public void out(String out, String money) throws SQLException {
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		QueryRunner runner =new QueryRunner();
		String sql="update account set money=money-? where name=?";
		runner.update(conn, sql, money,out);
	}

}
