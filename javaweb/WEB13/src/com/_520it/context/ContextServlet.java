package com._520it.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//1.获取全局的初始化参数(可以来配置数据库配置参数)
		String initParameter = servletContext.getInitParameter("driver");
		System.out.println(initParameter);
		//2.获得a b c d.txt的绝对路径
		//2.1获得a.txt文件
		String patha = servletContext.getRealPath("a.txt");
		System.out.println(patha);
		//2.2获得b.txt文件
		String pathb = servletContext.getRealPath("WEB-INF/b.txt");
		System.out.println(pathb);
		//2.3获得C.txt文件(无法获得！！！)
		//2.4获得d.txt文件
		String pathd = servletContext.getRealPath("WEB-INF/classes/d.txt");
		System.out.println(pathd);
		//在读取src(class)下的资源是可以通过类加载器----专门加载classes下的文件
		//getResource()参数是一个相对地址，相对于classes（最好不写/）
		String path =ContextServlet.class.getClassLoader().getResource("d.txt").getPath();
		System.out.println(path);
		//3.域对象---从ServletContext中存数据
		servletContext.setAttribute("name", "张三");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}