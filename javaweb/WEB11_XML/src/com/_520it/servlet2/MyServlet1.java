package com._520it.servlet2;

public class MyServlet1 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("��������");
	}

	@Override
	public void service() {
		System.out.println("MyServlet1��ʼΪ�����");
	}

	@Override
	public void destory() {
		System.out.println("��������");
	}

}
