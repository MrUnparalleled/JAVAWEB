package com._520it.dao;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;


//����ʵ��Serializable�ӿڣ���ʵ�ָýӿڵĻ��ۻ�ʱ����������userд��Ӳ����
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
	
	//�ۻ�
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("user���ۻ���");
	}
	
	//�
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("user�����");
	}
}
