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
		//1.创建一个当前时间date
		Date date =new Date();
		//设置时间格式----由于Tomcat版本比较高，所以cookie的值中不能出现空格，所以设置时间格式的时候不能有空格
		//An invalid character [32] was present in the Cookie value//这是错误
		SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd-hh:mm:ss");
		//将当前时间的格式转换
		String nowTime = format.format(date);
		//2.创建一个记录登录时间的cookie
		Cookie cookie=new Cookie("loginTimeCookie", nowTime);
		//设置cookie存在时间
		cookie.setMaxAge(60*10);//存在10分钟
		//3.将cookie传给客户端
		response.addCookie(cookie);
		//4.获取客户端的cookie
		Cookie[] cookies = request.getCookies();
		//5.获取登录时间的cookie
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
			response.getWriter().write("您是第一次访问");
		}else {
			//6.显示上次登录时间
			System.out.println("您上次登录时间为："+loginTime);
			response.getWriter().write("您上次登录时间为："+loginTime);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}