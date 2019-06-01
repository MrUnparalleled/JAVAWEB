package com.wjfit.review;

import java.util.HashMap;
import java.util.Map;

public class MotherBoard_bak {
	//����    List/Set/Map(key value)
	//�����ظ���List ��¼�Ⱥ�˳����set
	private Map<String, IUSB> plugins=new HashMap<>();
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
	//���������Ƴ����
	public void move(String name,IUSB usb) {
		plugins.remove(name, usb);
	}
}
