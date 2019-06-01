package com._520it._02_initparam;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamServlet implements Servlet {

	
	private ServletConfig config;
	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		this.config=arg0;
	}

	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String encoding=config.getInitParameter("encoding");
		Enumeration<String> en=config.getInitParameterNames();
		while(en.hasMoreElements()) {
			String paramName=en.nextElement();
			System.out.println(paramName);
			System.out.println(config.getInitParameter(paramName));
		}
		if("GBK".equals(encoding)) {
			System.out.println("ƒ„∫√ ¿ΩÁ");
		}else {
			System.out.println("hello");
		}
	}

}
