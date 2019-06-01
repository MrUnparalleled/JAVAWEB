package com._520it.header;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取指定请求头信息
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		//将请求头打印出来
		//获取请求头的名
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			//根据请求头的名字获取该名字的值
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}