package com._520it.service;

import java.sql.SQLException;

import com._520it.dao.UserDao;

public class UserService {

	public int checkRegisterUsername(String username) throws SQLException {
		//将请求和参数传递给dao层
		UserDao dao =new UserDao();
		int i = dao.checkRegisterUsername(username);
		return i;
	}

}
