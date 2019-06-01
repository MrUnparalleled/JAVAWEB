package com._520it.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��2д���Ժ�1���Բ���д
		//1.����response��ѯ�����
		//response.setCharacterEncoding("utf-8");
		//2.ͨ��һ��Content-Type��֪�ͻ���ʹ�����ֱ���
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		//��һ�ַ���
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter=response.getWriter();
		printWriter.write("hello, writer");
		printWriter.write("���");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}