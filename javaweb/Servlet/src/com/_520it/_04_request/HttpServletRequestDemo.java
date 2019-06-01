package com._520it._04_request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.javafx.collections.MappingChange.Map;

//演示HttpServletRequest的方法
public class HttpServletRequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
//		返回请求方式
		System.out.println(arg0.getMethod());
//		返回请求行中的资源名字部分
		System.out.println(arg0.getRequestURI());
//		返回浏览器地址栏中所有的信息
		System.out.println(arg0.getRequestURL());
//		返回当前项目的上下文路径<Context/>元素的path属性值
		System.out.println(arg0.getContextPath());
//		返回发出请求的客户机IP地址
		System.out.println(arg0.getRemoteAddr());
//		返回指定名称的请求头信息
		String userAgent=arg0.getHeader("User-Agent");
		System.out.println(userAgent.contains("Firefox"));
		System.out.println(userAgent);
		System.out.println("------------------------");
//		返回指定参数的值
		String username = arg0.getParameter("username");
		System.out.println(username);
//		返回指定参数的多个参数值
		String [] hobbys=arg0.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbys));
//		返回所有参数名的Enumeration对象
		Enumeration<String> names=arg0.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println("--->"+names.nextElement());
//			返回所有参数和值所组成的Map对象
//			Map<String,String[]>paramMap=arg0.getParameterMap();
//			System.out.println(paramMap);
		}
	}
}
