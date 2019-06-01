package com._520it.login;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com._520it.register.User;
import com._520it.util.DruidUtil;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.获取登录界面的请求参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		//2.将参数封装在一个JavaBean当中
		User user=new User();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//3.根据方法判断是否登录成功
		try {
			boolean login = login(user);
//			System.out.println(login);
			if (login==true) {
				response.sendRedirect(request.getContextPath());
			} else {
				//向请求域中存数据
				request.setAttribute("loginInfo", "账号或密码不正确");
				//请求转发
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//开发中一般不会返回boolean类型，一般会返回JavaBean
	public boolean login(User user) throws SQLException {
		Connection conn = DruidUtil.getConn();
		String sql="SELECT * FROM user WHERE username=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ResultSet query = ps.executeQuery();
		if (query.next()) {
			return true;
		}else {
			return false;
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}