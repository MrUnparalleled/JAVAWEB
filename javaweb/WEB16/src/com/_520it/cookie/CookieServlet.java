package com._520it.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����cookie��������������ΪString���ͣ�
		Cookie cookie=new Cookie("name", "zhangsan");
		//1.1Ϊcookie���ó־û�ʱ��-------��(cookie�ڴ����ϴ洢��ʱ��)
		cookie.setMaxAge(60*10);//10����------ʱ������Ϊ0����ɾ����cookie
		//1.2Ϊcookie����Я��·��
		//cookie.setPath("/WEB16/cookie");//����cookieʱ��Я�������Դ
		cookie.setPath("/WEB16");//����WEB16���κ���Դ��Я��
		//cookie.setPath("/");//���ʷ������µ��κ���Դ��Я��
		
		//2.��cookie�д洢�����ݷ��͵��ͻ���-----ͷ
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}