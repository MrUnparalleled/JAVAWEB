package com._520it.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得session
		HttpSession session = request.getSession();
		Person person =new Person();
		person.setPid(1);
		person.setPname("zhangsan");
		
		//绑定person
		session.setAttribute("person1", person);
		//解绑person
		session.removeAttribute("person1");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}