package com.wjfit.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.LongConverter;

import com.wjfit.javabean.Person;

//测试使用commons-beanutils组件
public class BeanUtilsDemo {
	public static void main(String[] args) throws Exception {
		Person p=new Person();
		Map<String, Object> map=new HashMap<>();
		map.put("id", "");
		map.put("name", "张三");
		map.put("age", 18);
		map.put("borndate", "1998-03-30");
		System.out.println(p);
		//重新注册类型转换器,long类型不使用类型转换器未赋值时输出为0，使用自定义类型转换器后为null
//		ConvertUtils.register(new LongConverter(null), Long.class);
		//beanUtils不支持String-->Date的转换，需要我们手动设置类型转换
		DateConverter dateConverter=new DateConverter(null);
		dateConverter.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dateConverter, java.util.Date.class);
		//前面那个参数即p为被赋值
		BeanUtils.copyProperties(p, map);
		System.out.println(p);
	}
}
