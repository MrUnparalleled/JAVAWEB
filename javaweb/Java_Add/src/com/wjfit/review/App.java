package com.wjfit.review;

public class App {
	public static void main(String[] args) {
		//������
//		Mouse mouse=new Mouse();
		//�������
		MotherBoard motherBoard=new MotherBoard();
		//���̶���
//		Keyboard keyboard=new Keyboard();
		//�������
//		motherBoard.install("mouse",mouse);
//		motherBoard.install("keyboard",keyboard);
		//ʹ�������ڲ��࣬�����ӡ������
//		motherBoard.install("print", new IUSB() {
//			public void swapData() {
//				System.out.println("��ӡ.........");
//			}});
		//���������ͨ�Ź���
		motherBoard.doWork();
	}
	
	
}
