package com._520it.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������
		String referer = request.getHeader("referer");
		System.out.println(referer);
		if (referer!=null && referer.startsWith("http://localhost/")) {
			//�Ǵ��Լ�����վ���������ת������
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("�й���......");
		}else {
			//�Լ���վ����Դ����ȡ��
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("�����ߣ��ɳܣ���");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}