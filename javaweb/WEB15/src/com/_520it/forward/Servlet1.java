package com._520it.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求转发
		//向request域中传值（！！！要掌握请求转发和重定向的区别！！！）
		request.setAttribute("name", "zhangsan");
		//获取转发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet2");
		//实现转发
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}