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
		//����context����󴴽�
		System.out.println("context����");
		//���Ǳ������Ķ���
		ServletContext servletContext = sce.getServletContext();
		//���Ǳ������Ķ���----ͨ�õķ���
		ServletContext source = (ServletContext) sce.getSource();
		//��ʼ���м�Ϣ���������
		Timer timer =new Timer();
		//task������  firstTime����һ��ִ�е�ʱ��  period�����ʱ��
//		timer.scheduleAtFixedRate(new TimerTask() {
//			//�����ڲ���
//			@Override
//			public void run() {
//				System.out.println("���м�Ϣ��.....");
//			}
//		}, new Date(), 3000);
		
		//�޸ĳ����������м�Ϣ
		//1.����ʼʱ����������12��
		//2.���ʱ��Ϊ24Сʱ
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
			//�����ڲ���
			@Override
			public void run() {
				System.out.println("���м�Ϣ��.....");
			}
		},parse, 5000);
	}
	public void contextDestroyed(ServletContextEvent sce) {
		//����context���������
		System.out.println("context����");
	}
}
