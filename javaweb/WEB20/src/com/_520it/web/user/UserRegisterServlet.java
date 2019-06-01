package com._520it.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.service.UserService;
@WebServlet("/userRegister")
/**
 * 用户注册时检查用户名是否存在
 * @author Administrator
 *
 */
public class UserRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取请求参数
			String username = request.getParameter("username");
			//传递请求和参数
			UserService service =new UserService();
			int count = service.checkRegisterUsername(username);
			System.out.println(count);
			boolean isUsed=false;
			if (count>0) {
				isUsed=true;
			}
			//将数据传输回去
			response.getWriter().write("{\"isUsed\":"+isUsed+"}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}