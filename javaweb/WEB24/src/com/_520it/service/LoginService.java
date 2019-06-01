package com._520it.service;

import java.sql.SQLException;

import com._520it.dao.LoginDao;
import com._520it.domain.User;

public class LoginService {

	public User findUser(String uname, String upwd) throws SQLException {
		// TODO Auto-generated method stub
		//´«µÝµ½dao²ã
		LoginDao dao =new LoginDao();
		User user = dao.findUser(uname,upwd);
		return user;
	}

}
