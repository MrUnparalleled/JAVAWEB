package com.wjfit.review;

public class App {
	public static void main(String[] args) {
		//鼠标对象
//		Mouse mouse=new Mouse();
		//主板对象
		MotherBoard motherBoard=new MotherBoard();
		//键盘对象
//		Keyboard keyboard=new Keyboard();
		//安插操作
//		motherBoard.install("mouse",mouse);
//		motherBoard.install("keyboard",keyboard);
		//使用匿名内部类，安插打印机对象
//		motherBoard.install("print", new IUSB() {
//			public void swapData() {
//				System.out.println("打印.........");
//			}});
		//调用主板的通信功能
		motherBoard.doWork();
	}
	
	
}
