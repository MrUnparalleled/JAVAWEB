package com._520it._08_cal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
		throws ServletException, IOException {
	arg0.setCharacterEncoding("utf-8");
	arg1.setContentType("text/html;cahracter=utf-8");
	PrintWriter out=arg1.getWriter();
	
	
	String sNum1=arg0.getParameter("num1");
	String sNum2=arg0.getParameter("num2");
	String op=arg0.getParameter("op");	
	String result="";
	if (hasLength(sNum1) && hasLength(sNum2)) {
		Integer num1=Integer.valueOf(sNum1);
		Integer num2=Integer.valueOf(sNum2);

		if ("+".equals(op)) {
			result=num1+num2+"";
		} else if("-".equals(op)) {
			result=num1-num2+"";
		}
	}
	
	
	out.print("<form action='/day1/cal' method='post'>");
	out.print("<input type='number' name='num1' value='"+sNum1+"'/> ");
	out.print("<select name='op'>");
	out.print("<option>+");
	out.print("<option>-");
	out.print("<option>*");
	out.print("<option>/");
	out.print("</select>");
	out.print("<input type='number' name='num2'value='"+sNum2+"'> ");
	out.print("<input type='submit' value=' = '>");
	out.print("<input type='text' value='"+result+"' disabled='disabled'>");
}
private boolean hasLength(String str) {
	return str!=null && !"".equals(str.trim());
}
}
