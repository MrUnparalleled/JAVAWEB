package com._520it.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ת��
		//��request���д�ֵ��������Ҫ��������ת�����ض�������𣡣�����
		request.setAttribute("name", "zhangsan");
		//��ȡת����
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet2");
		//ʵ��ת��
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}