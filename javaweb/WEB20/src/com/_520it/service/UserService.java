package com._520it.service;

import java.sql.SQLException;

import com._520it.dao.UserDao;

public class UserService {

	public int checkRegisterUsername(String username) throws SQLException {
		//������Ͳ������ݸ�dao��
		UserDao dao =new UserDao();
		int i = dao.checkRegisterUsername(username);
		return i;
	}

}
