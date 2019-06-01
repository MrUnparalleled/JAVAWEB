package com.wjfit.introspector;

public class User {

	private String name;
	private int age;
	private boolean man;
	//属性名：name
	public void setName(String name) {
		this.name = name;
	}
	//属性名：age
	public int getAge() {
		return age;
	}
	//属性名：man
	public boolean isMan() {
		return man;
	}
	//属性名：man
	public void setMan(boolean man) {
		this.man = man;
	}
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
}
