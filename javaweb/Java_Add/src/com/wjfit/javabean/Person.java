package com.wjfit.javabean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class Person {
	//ctrl+o看类的体系
	private Long id;
	private String name;
	private Integer age;
	private Date borndate;
	//alt+shift+s   选择添加get和set方法
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", borndate=" + borndate + "]";
	}

	
}
