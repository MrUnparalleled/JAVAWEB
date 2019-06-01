package com._520it._04_request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.javafx.collections.MappingChange.Map;

//��ʾHttpServletRequest�ķ���
public class HttpServletRequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
//		��������ʽ
		System.out.println(arg0.getMethod());
//		�����������е���Դ���ֲ���
		System.out.println(arg0.getRequestURI());
//		�����������ַ�������е���Ϣ
		System.out.println(arg0.getRequestURL());
//		���ص�ǰ��Ŀ��������·��<Context/>Ԫ�ص�path����ֵ
		System.out.println(arg0.getContextPath());
//		���ط�������Ŀͻ���IP��ַ
		System.out.println(arg0.getRemoteAddr());
//		����ָ�����Ƶ�����ͷ��Ϣ
		String userAgent=arg0.getHeader("User-Agent");
		System.out.println(userAgent.contains("Firefox"));
		System.out.println(userAgent);
		System.out.println("------------------------");
//		����ָ��������ֵ
		String username = arg0.getParameter("username");
		System.out.println(username);
//		����ָ�������Ķ������ֵ
		String [] hobbys=arg0.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbys));
//		�������в�������Enumeration����
		Enumeration<String> names=arg0.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println("--->"+names.nextElement());
//			�������в�����ֵ����ɵ�Map����
//			Map<String,String[]>paramMap=arg0.getParameterMap();
//			System.out.println(paramMap);
		}
	}
}
