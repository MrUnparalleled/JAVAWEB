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
		//为该客户端创建一个私有的session区域
		/*该方法会判断该客户端在服务器端是否有session
		 * 如果该客户端在服务器端没有session，那么会创建一个session对象
		 * 如果该客户端在服务器端已经有了session，则返回已经存在的session
		 * */
		HttpSession session = request.getSession();
		//向session中传入数据
		session.setAttribute("name", "zhangsan");
		
		//获得JSESSIONID
		String id = session.getId();
		
		//在发现无法实现JSESSION持久化的时候需要看一下浏览器设置，是否设置成每次浏览器关闭就清空cookie！！！！！
		Cookie cookie =new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16/");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
		response.getWriter().write(id);
		//手动销毁session
		//session.invalidate();
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}