package com._520it._01_hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements javax.servlet.Servlet {


	public void destroy() {
		System.out.println("Ïú»Ù");
	}


	public ServletConfig getServletConfig() {
		return null;
	}


	public String getServletInfo() {
		return null;
	}


	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("³õÊ¼»¯");
	}


	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("hello,world");
	}

}
