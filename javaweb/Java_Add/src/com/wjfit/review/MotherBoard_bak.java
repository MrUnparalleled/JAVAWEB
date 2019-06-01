package com.wjfit.review;

import java.util.HashMap;
import java.util.Map;

public class MotherBoard_bak {
	//集合    List/Set/Map(key value)
	//允许重复用List 记录先后顺序用set
	private Map<String, IUSB> plugins=new HashMap<>();
	//把鼠标安插在主板上
	public void install(String name,IUSB usb) {
		plugins.put(name, usb);
	}
	
	//主板通信
	public void doWork() {
		//迭代出每一个安装在主板上的组件，并调用每一个的功能
		for(IUSB usb:plugins.values()) {
			usb.swapData();
		}
	}
	//从主板上移除组件
	public void move(String name,IUSB usb) {
		plugins.remove(name, usb);
	}
}
