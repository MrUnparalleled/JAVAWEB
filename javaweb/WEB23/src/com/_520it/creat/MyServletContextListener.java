package com._520it.creat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		//监听context域对象创建
		System.out.println("context创建");
		//就是被监听的对象
		ServletContext servletContext = sce.getServletContext();
		//就是被监听的对象----通用的方法
		ServletContext source = (ServletContext) sce.getSource();
		//开始银行计息的任务调度
		Timer timer =new Timer();
		//task：任务  firstTime：第一次执行的时间  period：间隔时间
//		timer.scheduleAtFixedRate(new TimerTask() {
//			//匿名内部类
//			@Override
//			public void run() {
//				System.out.println("银行计息了.....");
//			}
//		}, new Date(), 3000);
		
		//修改成真正的银行计息
		//1.将开始时间计算成晚上12点
		//2.间隔时间为24小时
		SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		String currentTimer ="2019-4-13 00:00:00";
		//String currentTimer ="2019-4-12 15:53:00";
		Date parse =null;
		try {
			parse = format.parse(currentTimer);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		timer.scheduleAtFixedRate(new TimerTask() {
			//匿名内部类
			@Override
			public void run() {
				System.out.println("银行计息了.....");
			}
		},parse, 5000);
	}
	public void contextDestroyed(ServletContextEvent sce) {
		//监听context域对象销毁
		System.out.println("context销毁");
	}
}
