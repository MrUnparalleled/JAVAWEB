package com._520it.servlet2;

public class MyServlet2 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("��������");
	}

	@Override
	public void service() {
		System.out.println("MyServlet2��ʼΪ�����");
	}

	@Override
	public void destory() {
		System.out.println("��������");
	}

}
