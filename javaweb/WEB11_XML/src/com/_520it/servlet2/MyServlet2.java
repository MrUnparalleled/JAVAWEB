package com._520it.servlet2;

public class MyServlet2 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("劳资来啦");
	}

	@Override
	public void service() {
		System.out.println("MyServlet2开始为你服务");
	}

	@Override
	public void destory() {
		System.out.println("劳资走了");
	}

}
