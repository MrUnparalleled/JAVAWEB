package com._520it._03_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet1 extends MyGenericServlet {
	public void init() {
		System.out.println("����ĳ�ʼ������");
	}
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		String encoding =super.getInitParameter("encoding");
		System.out.println(encoding);
	}

}
