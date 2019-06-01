package com._520it.servlet2;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestMyServlet {


	@Test
	public void testMyServlet1(){
		try {
			//1.获取解析器
			SAXReader reader=new SAXReader();
			//2.获取document对象
			Document dom=reader.read("src/com/_520it/servlet2/web.xml");
			//3.获取根节点
			Element rootElement =dom.getRootElement();
			//System.out.println(rootElement.getName());
			//4.获取servlet对象
			Element servletElement = rootElement.element("servlet");
			//System.out.println(servletElement.getName());
			//获取servlet-class
			Element servletName = servletElement.element("servlet-name");
			//System.out.println(servletName.getText());
			String servletclass = servletElement.element("servlet-class").getText();
			//
			Class clazz =Class.forName(servletclass);
			MyServlet1 servlet1 = (MyServlet1) clazz.newInstance();
			servlet1.init();
			servlet1.service();
			servlet1.destory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
