package com.wjfit.introspector;

public class User {

	private String name;
	private int age;
	private boolean man;
	//��������name
	public void setName(String name) {
		this.name = name;
	}
	//��������age
	public int getAge() {
		return age;
	}
	//��������man
	public boolean isMan() {
		return man;
	}
	//��������man
	public void setMan(boolean man) {
		this.man = man;
	}
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
}
