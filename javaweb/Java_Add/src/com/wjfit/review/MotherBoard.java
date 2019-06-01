package com.wjfit.review;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MotherBoard {
	//集合    List/Set/Map(key value)
	//允许重复用List 记录先后顺序用set
	//存储安装的USB设备对象
	private static Map<String, IUSB> plugins=new HashMap<>();
	
	static {
		Properties properties=new Properties();
		try {
			InputStream inStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("plugins.properties");
			properties.load(inStream);
			//====================
			//读取properties文件，创建USB组件对象
			Set<Entry<Object,Object>> entrys =properties.entrySet();
			for (Entry<Object, Object> entry : entrys) {
				
				String className=entry.getValue().toString();
				IUSB usbObject=(IUSB) Class.forName(className).newInstance();
				plugins.put(entry.getKey().toString(), usbObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
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
}
