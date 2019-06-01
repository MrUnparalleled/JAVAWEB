package com.wjfit.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.LongConverter;

import com.wjfit.javabean.Person;

//����ʹ��commons-beanutils���
public class BeanUtilsDemo {
	public static void main(String[] args) throws Exception {
		Person p=new Person();
		Map<String, Object> map=new HashMap<>();
		map.put("id", "");
		map.put("name", "����");
		map.put("age", 18);
		map.put("borndate", "1998-03-30");
		System.out.println(p);
		//����ע������ת����,long���Ͳ�ʹ������ת����δ��ֵʱ���Ϊ0��ʹ���Զ�������ת������Ϊnull
//		ConvertUtils.register(new LongConverter(null), Long.class);
		//beanUtils��֧��String-->Date��ת������Ҫ�����ֶ���������ת��
		DateConverter dateConverter=new DateConverter(null);
		dateConverter.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dateConverter, java.util.Date.class);
		//ǰ���Ǹ�������pΪ����ֵ
		BeanUtils.copyProperties(p, map);
		System.out.println(p);
	}
}
