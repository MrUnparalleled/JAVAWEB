package com.wjfit.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;


//内省机制：操作User类值的属性
public class IntrospectorDemo {
	public static void main(String[] args)throws Exception{
		//1.获取JavaBean的描述对象
		BeanInfo beanInfo=Introspector.getBeanInfo(User.class,Object.class);
		User user=User.class.newInstance();
		//2.获取JavaBean中的属性的描述器
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		System.out.println(user);
		for (PropertyDescriptor propertyDescriptor : pds) {
			System.out.println("属性名="+propertyDescriptor.getName());
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
