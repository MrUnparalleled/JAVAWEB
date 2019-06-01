package com._520it.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date=new Date();
		//��������ͷ����Ϣ
		response.addHeader("name", "zhangsan");
		response.addHeader("name", "lisi");
		//addд���λ��и�������ֵ
		response.addIntHeader("age", 21);
		response.addDateHeader("birthday", date.getTime());
		//set�Ὣֵ�޸ĵ�
		response.setHeader("name", "wangwu");
		//ʵ���ض���
		//����״̬��
		//response.setStatus(302);
		//����location
		//response.setHeader("Location", "/WEB14/line");
		//��װ��һ���ض���ķ���
		response.sendRedirect("/WEB14/line");
		//���ö�ʱ��ת
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}