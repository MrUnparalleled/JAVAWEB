package com.wjfit.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;


//��ʡ���ƣ�����User��ֵ������
public class IntrospectorDemo {
	public static void main(String[] args)throws Exception{
		//1.��ȡJavaBean����������
		BeanInfo beanInfo=Introspector.getBeanInfo(User.class,Object.class);
		User user=User.class.newInstance();
		//2.��ȡJavaBean�е����Ե�������
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		System.out.println(user);
		for (PropertyDescriptor propertyDescriptor : pds) {
			System.out.println("������="+propertyDescriptor.getName());
			System.out.println("getter "+propertyDescriptor.getReadMethod());
			System.out.println("setter "+propertyDescriptor.getWriteMethod());
			System.out.println("================================");
			if ("name".equals(propertyDescriptor.getName())) {
				Method setter=propertyDescriptor.getWriteMethod();
				setter.invoke(user, "will");
			}
		}
		System.out.println(user);
	}
}
