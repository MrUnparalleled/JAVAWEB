package com._520it._07_response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseDemo extends HttpServlet{
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		//ÔÚä¯ÀÀÆ÷ÖÐÊä³öspring Brohter£¬·ï½ã
//		OutputStream out=arg1.getOutputStream();
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter out= arg1.getWriter();
		out.println("Spring Brother");
		out.println("·ï½ã");
		
	}
}
