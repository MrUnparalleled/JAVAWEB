package com.wjfit.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.wjfit.javabean.Person;

public class BeanUtil {
	
	public static void main(String[] args) throws Exception {
		Person p=new Person();
		p.setId(123L);
		p.setAge(18);
		p.setName("����");
		
		Map<String, Object>map2=bean2map(p);
		System.out.println(map2);
		Person object1=map2bean(map2, Person.class);
		System.out.println(object1);
		User user=new User();
		user.setMan(true);
		user.setName("����");
		System.out.println(user);
	}
	
	//��JavaBeanת��Ϊһ��map
	public static Map<String, Object> bean2map(Object bean) throws Exception{
		Map<String, Object> map=new HashMap<>();
		BeanInfo beanInfo=Introspector.getBeanInfo(Person.class,Object.class);
		PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : pds) {
			String name=propertyDescriptor.getName();
			Object value=propertyDescriptor.getReadMethod().invoke(bean);//��ȡ����ֵ
			map.put(name, value);
		}
		return map;
		
	}
	//��mapת��Ϊһ��JavaBean
	public static <T> T map2bean(Map<String, Object> map,Class<T> beanType)throws Exception {
		//������һ��JavaBean����
		Object object=beanType.newInstance();
		BeanInfo beanInfo=Introspector.getBeanInfo(beanType,Object.class);
		PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Object value=map.get(pd.getName());
			//����set��������������ֵ
			pd.getWriteMethod().invoke(object,value);
		}
		return (T) object;
	}
		
}

