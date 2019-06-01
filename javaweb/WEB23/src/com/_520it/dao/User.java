package com._520it.dao;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;


//必须实现Serializable接口，不实现该接口的话钝化时不能真正将user写到硬盘上
public class User implements HttpSessionActivationListener,Serializable {
	private int uid;
	private String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	//钝化
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("user被钝化了");
	}
	
	//活化
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("user被活化了");
	}
}
