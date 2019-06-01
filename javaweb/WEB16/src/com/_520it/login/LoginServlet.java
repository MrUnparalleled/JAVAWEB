package com._520it.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//检查验证码是否正确
		//获取输入的验证码
		String checkCode = request.getParameter("checkCode");
		//获取验证码图片内容
		HttpSession session = request.getSession();
		Object checkCode_img = session.getAttribute("checkcode_session");
		if (!checkCode.equals(checkCode_img.toString())) {
			
			//向请求域中存数据
			request.setAttribute("CheckImgInfo", "验证码错误");
			//请求转发
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
			//获取用户名密码，数据库操作核实账户密码
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}