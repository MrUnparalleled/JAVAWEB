package com._520it.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡServletContext����
		ServletContext servletContext = this.getServletContext();
		//1.��ȡȫ�ֵĳ�ʼ������(�������������ݿ����ò���)
		String initParameter = servletContext.getInitParameter("driver");
		System.out.println(initParameter);
		//2.���a b c d.txt�ľ���·��
		//2.1���a.txt�ļ�
		String patha = servletContext.getRealPath("a.txt");
		System.out.println(patha);
		//2.2���b.txt�ļ�
		String pathb = servletContext.getRealPath("WEB-INF/b.txt");
		System.out.println(pathb);
		//2.3���C.txt�ļ�(�޷���ã�����)
		//2.4���d.txt�ļ�
		String pathd = servletContext.getRealPath("WEB-INF/classes/d.txt");
		System.out.println(pathd);
		//�ڶ�ȡsrc(class)�µ���Դ�ǿ���ͨ���������----ר�ż���classes�µ��ļ�
		//getResource()������һ����Ե�ַ�������classes����ò�д/��
		String path =ContextServlet.class.getClassLoader().getResource("d.txt").getPath();
		System.out.println(path);
		//3.�����---��ServletContext�д�����
		servletContext.setAttribute("name", "����");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}