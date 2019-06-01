package com._520it._03_extends;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

abstract public  class MyGenericServlet implements Servlet,ServletConfig,Serializable {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	public void destroy() {
		
	}
//把ServletConfig对象暴露给子类
	public ServletConfig getServletConfig() {
		return this.config;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		this.config=arg0;
		this.init();
	}
	public void init() {
		
	}

	abstract public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException;
	
	

	public String getInitParameter(String arg0) {
		return config.getInitParameter(arg0);
	}
	public Enumeration<String> getInitParameterNames() {
		return config.getInitParameterNames();
	}
	public ServletContext getServletContext() {
		return config.getServletContext();
	}
	public String getServletName() {
		return config.getServletName();
	}

}
