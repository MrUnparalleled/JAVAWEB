package com._520it.servlet;

public class MyServletImpl implements IMyServlet{

	@Override
	public void init() {
		System.out.println("������������");
	}

	@Override
	public void service() {
		System.out.println("�ҿ���Ϊ�����.....");
	}

	@Override
	public void destory() {
		System.out.println("������������");
	}

}
