package com.wjfit.anno;

//第三方程序，来赋予注解功能
public class VIPDemo {
	public static void main(String[] args) {
		//需求：获取Employee上所有的注解
		//1.先获取Employee字节码对象
		Class<Employee> clz=Employee.class;
		//2.直接获取类上所有的注解
//		Annotation[] as= clz.getAnnotations();
//		for (Annotation annotation : as) {
//			System.out.println(annotation);;
//		}
		//判断Employee类上是否使用了VIP注解
		VIP aVip=clz.getAnnotation(VIP.class);
		if (aVip==null) {
			System.out.println("没有");
		}else {
			System.out.println("有");
			System.out.println(aVip.name());
			System.out.println(aVip.age());
			System.out.println(aVip.hobby());
		}
		
	}
}
