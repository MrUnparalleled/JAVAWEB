package com._520it.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttribute implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scae) {
		//���
		System.out.println(scae.getName());//�ŵ����е�name
		System.out.println(scae.getValue());//�ŵ����е�value
	}
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		//ɾ��
		System.out.println(scae.getName());//ɾ�����е�name
		System.out.println(scae.getValue());//ɾ�����е�value
	}
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		//�޸�
		System.out.println(scae.getName());//����޸�ǰ��name
		System.out.println(scae.getValue());//����޸�ǰ��value
	}
}
