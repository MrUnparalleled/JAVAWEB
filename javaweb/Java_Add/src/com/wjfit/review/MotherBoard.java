package com.wjfit.review;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MotherBoard {
	//����    List/Set/Map(key value)
	//�����ظ���List ��¼�Ⱥ�˳����set
	//�洢��װ��USB�豸����
	private static Map<String, IUSB> plugins=new HashMap<>();
	
	static {
		Properties properties=new Properties();
		try {
			InputStream inStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("plugins.properties");
			properties.load(inStream);
			//====================
			//��ȡproperties�ļ�������USB�������
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
	
	
	//����갲����������
	public void install(String name,IUSB usb) {
		plugins.put(name, usb);
	}
	
	//����ͨ��
	public void doWork() {
		//������ÿһ����װ�������ϵ������������ÿһ���Ĺ���
		for(IUSB usb:plugins.values()) {
			usb.swapData();
		}
	}
}
