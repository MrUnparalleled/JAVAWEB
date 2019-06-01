package com._520it._06_encoding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		String username=arg0.getParameter("username");
//		byte [] data=username.getBytes("ISO-8859-1");
//		username=new String(data,"UTF-8");
		String password=arg0.getParameter("password");
		System.out.println(username+","+password);
		
	}
}
