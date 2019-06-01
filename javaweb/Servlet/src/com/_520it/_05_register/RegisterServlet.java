package com._520it._05_register;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String username=arg0.getParameter("username");
		String password=arg0.getParameter("password");
		String gender=arg0.getParameter("gender");
		String city=arg0.getParameter("city");
		String intro=arg0.getParameter("intro");
		String [] hobbys=arg0.getParameterValues("hobby");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(city);
		System.out.println(intro);
		System.out.println(Arrays.toString(hobbys));
	}

}
