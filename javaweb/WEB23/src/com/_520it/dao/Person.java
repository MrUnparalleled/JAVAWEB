package com._520it.dao;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener {

	private int pid;
	private String pname;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		//��
		System.out.println("Person������");
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		//���
		System.out.println("Person�������");
	}
}
