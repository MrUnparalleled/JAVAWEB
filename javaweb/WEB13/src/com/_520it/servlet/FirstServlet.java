package com._520it.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//1.��ȡservlet��name-------<servlet-name>abc</servlet-name>
		String servletName =arg0.getServletName();
		System.out.println(servletName);//abc
		//2.��ø�servlet�ĳ�ʼ���Ĳ���
		String initParameter = arg0.getInitParameter("url");
		System.out.println(initParameter);
		//3.��ȡServletContext����
		ServletContext servletContext = arg0.getServletContext();
		System.out.println(servletContext);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
	}

}
