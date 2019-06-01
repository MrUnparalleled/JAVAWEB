package com._520it.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求行的信息
		//1.获取请求方法
		String method = request.getMethod();
		System.out.println("method:"+method);
		//2.获取路径
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("uri:"+requestURI);
		System.out.println("url:"+requestURL);
		//3.获取WEB 应用
		String contextPath = request.getContextPath();
		System.out.println("web应用："+contextPath);
		//4.获取get方式下的请求参数
		String queryString = request.getQueryString();
		System.out.println("query:"+queryString);
		//5.获取客户端的IP地址
		String remoteAddr = request.getRemoteAddr();
		System.out.println("ip:"+remoteAddr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}