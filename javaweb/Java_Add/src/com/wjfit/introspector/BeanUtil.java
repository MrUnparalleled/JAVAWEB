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
		p.setName("张三");
		
		Map<String, Object>map2=bean2map(p);
		System.out.println(map2);
		Person object1=map2bean(map2, Person.class);
		System.out.println(object1);
		User user=new User();
		user.setMan(true);
		user.setName("张三");
		System.out.println(user);
	}
	
	//把JavaBean转换为一个map
	public static Map<String, Object> bean2map(Object bean) throws Exception{
		Map<String, Object> map=new HashMap<>();
		BeanInfo beanInfo=Introspector.getBeanInfo(Person.class,Object.class);
		PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : pds) {
			String name=propertyDescriptor.getName();
			Object value=propertyDescriptor.getReadMethod().invoke(bean);//获取属性值
			map.put(name, value);
		}
		return map;
		
	}
	//把map转换为一个JavaBean
	public static <T> T map2bean(Map<String, Object> map,Class<T> beanType)throws Exception {
		//创建出一个JavaBean对象
		Object object=beanType.newInstance();
		BeanInfo beanInfo=Introspector.getBeanInfo(beanType,Object.class);
		PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Object value=map.get(pd.getName());
			//调用set方法，设置属性值
			pd.getWriteMethod().invoke(object,value);
		}
		return (T) object;
	}
		
}

