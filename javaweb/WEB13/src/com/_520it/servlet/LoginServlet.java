package com._520it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.domain.User;
import com._520it.util.DruidUtil;


public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		Integer count =0;
		ServletContext context = this.getServletContext();
		context.setAttribute("count", count);
		super.init();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user1=null;
		ServletContext context = this.getServletContext();
		Integer count;
		//1.获取请求信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.通过数据库验证信息
		Connection conn=DruidUtil.getConn();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT * FROM user where username=? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			
		while (rs.next()) {
			User user=new User();
			user1=user;
			user1.setId(rs.getInt("id"));
			user1.setName(rs.getString("username"));
			user1.setPassword(rs.getString("password"));
			user1.setEmail(rs.getString("email"));
		}
		DruidUtil.close(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		count =(Integer) context.getAttribute("count");
		//3.返回验证结果
		if (user1!=null) {
			count++;
			response.getWriter().write(user1.toString()+"you are "+count+" people");
		}else {
			response.getWriter().write("sorry your username or password is wrong!");
		}
		context.setAttribute("count", count);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}