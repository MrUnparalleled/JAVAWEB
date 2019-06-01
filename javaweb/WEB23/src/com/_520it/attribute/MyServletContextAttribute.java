package com._520it.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttribute implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scae) {
		//添加
		System.out.println(scae.getName());//放到域当中的name
		System.out.println(scae.getValue());//放到域当中的value
	}
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		//删除
		System.out.println(scae.getName());//删除域当中的name
		System.out.println(scae.getValue());//删除域当中的value
	}
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		//修改
		System.out.println(scae.getName());//获得修改前的name
		System.out.println(scae.getValue());//获得修改前的value
	}
}
