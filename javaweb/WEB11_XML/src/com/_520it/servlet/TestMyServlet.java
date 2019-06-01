package com._520it.servlet;

import org.junit.Test;

public class TestMyServlet {

	@Test
	public void testMyServlet() throws Exception {
		MyServletImpl myServletImpl = new MyServletImpl();
		myServletImpl.init();
		myServletImpl.service();
		myServletImpl.destory();
	}
	@Test
	public void testMyServlet1() throws Exception {
		String string="com._520it.servlet.MyServletImpl";
		Class clazz =Class.forName(string);
		MyServletImpl myServletImpl = (MyServletImpl) clazz.newInstance();
		myServletImpl.init();
		myServletImpl.service();
		myServletImpl.destory();
	}
}
