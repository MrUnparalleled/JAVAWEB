package com._520it.servlet;

public class MyServletImpl implements IMyServlet{

	@Override
	public void init() {
		System.out.println("啊，劳资来啦");
	}

	@Override
	public void service() {
		System.out.println("我可以为你服务.....");
	}

	@Override
	public void destory() {
		System.out.println("啊，劳资走了");
	}

}
