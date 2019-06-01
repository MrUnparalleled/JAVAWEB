package com._520it.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除客户端已经存在的name=zhangsan的cookie
		//1.设置相同的cookie名
		Cookie cookie =new Cookie("name", "");
		//2.设置相同的路径
		cookie.setPath("/WEB16");
		//3.将时间设置为0
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}