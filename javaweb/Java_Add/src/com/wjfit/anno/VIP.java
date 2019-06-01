package com.wjfit.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface VIP {

	String name();
	//ע���еĳ��󷽷������ԣ����ͣ�ֻ���ǻ������ͣ�String,Class,annotation,ö��,����
	int age() default 18;
	String[] hobby() ;
}
