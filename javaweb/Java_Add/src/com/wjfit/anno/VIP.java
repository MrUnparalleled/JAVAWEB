package com.wjfit.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface VIP {

	String name();
	//注解中的抽象方法（属性）类型：只能是基本类型，String,Class,annotation,枚举,数组
	int age() default 18;
	String[] hobby() ;
}
