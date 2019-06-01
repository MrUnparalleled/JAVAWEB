package com._520it.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.创建cookie对象（两个参数都为String类型）
		Cookie cookie=new Cookie("name", "zhangsan");
		//1.1为cookie设置持久化时间-------秒(cookie在磁盘上存储的时间)
		cookie.setMaxAge(60*10);//10分钟------时间设置为0代表删除该cookie
		//1.2为cookie设置携带路径
		//cookie.setPath("/WEB16/cookie");//访问cookie时才携带这个资源
		cookie.setPath("/WEB16");//访问WEB16的任何资源都携带
		//cookie.setPath("/");//访问服务器下的任何资源都携带
		
		//2.将cookie中存储的数据发送到客户端-----头
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}