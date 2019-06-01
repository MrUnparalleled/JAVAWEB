package com._520it.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当2写了以后1可以不用写
		//1.设置response查询的码表
		//response.setCharacterEncoding("utf-8");
		//2.通过一个Content-Type告知客户端使用哪种编码
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		//另一种方法
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter=response.getWriter();
		printWriter.write("hello, writer");
		printWriter.write("你好");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}