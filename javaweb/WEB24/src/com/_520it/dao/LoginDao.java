package com._520it.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com._520it.domain.User;
import com._520it.util.DataSourceUtils;

public class LoginDao {

	public User findUser(String uname, String upwd) throws SQLException {

		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from user where uname=? and upwd=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), uname,upwd);
		return user;
	}

}
