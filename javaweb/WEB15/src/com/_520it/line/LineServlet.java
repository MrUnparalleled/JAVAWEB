package com._520it.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�����е���Ϣ
		//1.��ȡ���󷽷�
		String method = request.getMethod();
		System.out.println("method:"+method);
		//2.��ȡ·��
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("uri:"+requestURI);
		System.out.println("url:"+requestURL);
		//3.��ȡWEB Ӧ��
		String contextPath = request.getContextPath();
		System.out.println("webӦ�ã�"+contextPath);
		//4.��ȡget��ʽ�µ��������
		String queryString = request.getQueryString();
		System.out.println("query:"+queryString);
		//5.��ȡ�ͻ��˵�IP��ַ
		String remoteAddr = request.getRemoteAddr();
		System.out.println("ip:"+remoteAddr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}