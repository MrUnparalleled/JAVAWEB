package com._520it.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ϊ�ÿͻ��˴���һ��˽�е�session����
		/*�÷������жϸÿͻ����ڷ��������Ƿ���session
		 * ����ÿͻ����ڷ�������û��session����ô�ᴴ��һ��session����
		 * ����ÿͻ����ڷ��������Ѿ�����session���򷵻��Ѿ����ڵ�session
		 * */
		HttpSession session = request.getSession();
		//��session�д�������
		session.setAttribute("name", "zhangsan");
		
		//���JSESSIONID
		String id = session.getId();
		
		//�ڷ����޷�ʵ��JSESSION�־û���ʱ����Ҫ��һ����������ã��Ƿ����ó�ÿ��������رվ����cookie����������
		Cookie cookie =new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16/");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
		response.getWriter().write(id);
		//�ֶ�����session
		//session.invalidate();
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}