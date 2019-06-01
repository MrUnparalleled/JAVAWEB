package com._520it.content;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取单个请求参数
		String username = request.getParameter("username");
		System.out.println(username);
		//2.获取多个参数
		String[] hobbys = request.getParameterValues("hobby");
		for (String hobby : hobbys) {
			System.out.println(hobby);
		}
		//3.获得所有参数的名称
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String name = (String) parameterNames.nextElement();
			System.out.println(name);
		}
		System.out.println("--------------------------");
		//4.显示完整参数      get和set方法都可以使用
		Map<String, String[]> parameterMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entry:parameterMap.entrySet()) {
			System.out.println(entry.getKey());
			for(String str:entry.getValue()) {
				System.out.println(str);
			}
			System.out.println("------------------------");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}