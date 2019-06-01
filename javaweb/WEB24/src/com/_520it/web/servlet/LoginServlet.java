package com._520it.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com._520it.domain.User;
import com._520it.service.LoginService;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User user =null;
			//获取参数和请求
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			//传递到service层
			LoginService service=new LoginService();
			user = service.findUser(uname,upwd);
			//判断是否存在
			if (user==null) {
				//用户名或密码错误
				request.setAttribute("LoginInfo", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			} else {
				//登录成功
				//判断是否勾选自动登录
				String autoLogin = request.getParameter("autoLogin");
				if (autoLogin!=null) {
					//将用户名，密码放到cookie中，设置持久化时间
					Cookie cookie_uname =new Cookie("cookie_uname", user.getUname());
					Cookie cookie_upwd =new Cookie("cookie_upwd", user.getUpwd());
					//设置持久化时间
					cookie_uname.setMaxAge(60*60*24*30);
					cookie_upwd.setMaxAge(60*60*24*30);
					//设置cookie携带路径
					cookie_uname.setPath(request.getContextPath());
					cookie_upwd.setPath(request.getContextPath());
					//添加cookie
					response.addCookie(cookie_uname);
					response.addCookie(cookie_upwd);
				}
				
				//将正确的用户名和密码加入到session域当中
				session.setAttribute("user", user);
				//重定向
				response.sendRedirect(request.getContextPath());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}