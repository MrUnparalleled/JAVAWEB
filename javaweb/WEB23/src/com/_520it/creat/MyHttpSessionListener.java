package com._520it.creat;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent se) {
		//session����ʱ
		HttpSession session = se.getSession();
		System.out.println("session����"+session.getId());
		
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session����");
		
	}
}
