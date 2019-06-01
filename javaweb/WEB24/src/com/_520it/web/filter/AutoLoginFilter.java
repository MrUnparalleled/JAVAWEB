package com._520it.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com._520it.domain.User;
import com._520it.service.LoginService;

public class AutoLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//强转
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		//设置cookie_uname
		String cookie_uname =null;
		//设置cookie_upwd
		String cookie_upwd =null;
		
		//取出cookie
		Cookie[] cookies = req.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cookie_uname")) {
					cookie_uname = cookie.getValue();
				}
				if (cookie.getName().equals("cookie_upwd")) {
					cookie_upwd = cookie.getValue();
				}
			}
		}
		
		//判断cookie_uname和cookie_upwd是否为空
		if (cookie_uname!=null && cookie_upwd!=null) {
			HttpSession session = req.getSession();
			User user =null;
			LoginService service=new LoginService();
			try {
				user = service.findUser(cookie_uname,cookie_upwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (user!=null) {
				session.setAttribute("user", user);
			}
//			System.out.println(user.toString());
		}
		chain.doFilter(request, response);
	}
}
