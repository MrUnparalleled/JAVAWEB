package com._520it._03_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServlet extends MyGenericServlet {
	public void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		service(request,response);
	}
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		String method=arg0.getMethod();
//		System.out.print(method);
		if("GET".equals(method)) {
			doGet(arg0,arg1);
		}else {
			doPost(arg0,arg1);
		}
	}
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) {
		System.out.println("doGet");
	}
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) {
		System.out.println("doPost");
	}
}
