package com.wjfit.javabean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class Person {
	//ctrl+o�������ϵ
	private Long id;
	private String name;
	private Integer age;
	private Date borndate;
	//alt+shift+s   ѡ�����get��set����
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", borndate=" + borndate + "]";
	}

	
}
