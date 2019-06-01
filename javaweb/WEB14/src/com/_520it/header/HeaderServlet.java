package com._520it.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date=new Date();
		//设置请求头的信息
		response.addHeader("name", "zhangsan");
		response.addHeader("name", "lisi");
		//add写两次会有赋予两个值
		response.addIntHeader("age", 21);
		response.addDateHeader("birthday", date.getTime());
		//set会将值修改掉
		response.setHeader("name", "wangwu");
		//实现重定向
		//设置状态码
		//response.setStatus(302);
		//设置location
		//response.setHeader("Location", "/WEB14/line");
		//封装成一个重定向的方法
		response.sendRedirect("/WEB14/line");
		//设置定时跳转
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}