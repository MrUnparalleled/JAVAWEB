package com._520it.transfer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class TransferDao {

	public void in(Connection conn,String in, String money) throws SQLException {
		QueryRunner runner =new QueryRunner();
		String sql="update account set money=money+? where name=?";
		runner.update(conn, sql, money,in);
	}

	public void out(Connection conn,String out, String money) throws SQLException {
		QueryRunner runner =new QueryRunner();
		String sql="update account set money=money-? where name=?";
		runner.update(conn, sql, money,out);
	}

}
