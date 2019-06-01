package com._520it.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防盗链
		String referer = request.getHeader("referer");
		System.out.println(referer);
		if (referer!=null && referer.startsWith("http://localhost/")) {
			//是从自己的网站里面的链接转过来的
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("中国梦......");
		}else {
			//自己网站的资源被盗取了
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("盗链者，可耻！！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}