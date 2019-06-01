package com._520it.timecookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.����һ����ǰʱ��date
		Date date =new Date();
		//����ʱ���ʽ----����Tomcat�汾�Ƚϸߣ�����cookie��ֵ�в��ܳ��ֿո���������ʱ���ʽ��ʱ�����пո�
		//An invalid character [32] was present in the Cookie value//���Ǵ���
		SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd-hh:mm:ss");
		//����ǰʱ��ĸ�ʽת��
		String nowTime = format.format(date);
		//2.����һ����¼��¼ʱ���cookie
		Cookie cookie=new Cookie("loginTimeCookie", nowTime);
		//����cookie����ʱ��
		cookie.setMaxAge(60*10);//����10����
		//3.��cookie�����ͻ���
		response.addCookie(cookie);
		//4.��ȡ�ͻ��˵�cookie
		Cookie[] cookies = request.getCookies();
		//5.��ȡ��¼ʱ���cookie
		String loginTime=null;
		if (cookies!=null) {
			for (Cookie cookie2 : cookies) {
				String cookieName = cookie2.getName();
				if (cookieName.equals("loginTimeCookie")) {
					loginTime = cookie2.getValue();
				}
			}
		}
		
		if (loginTime==null) {
			response.getWriter().write("���ǵ�һ�η���");
		}else {
			//6.��ʾ�ϴε�¼ʱ��
			System.out.println("���ϴε�¼ʱ��Ϊ��"+loginTime);
			response.getWriter().write("���ϴε�¼ʱ��Ϊ��"+loginTime);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}