package com._520it.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class TestDom4j {

	@Test
	public void  testDom() {
		try {
			//1.��ý�����
			SAXReader saxReader=new SAXReader();
			//2.��ȡdocument�ĵ�����
			Document doc =saxReader.read("src/com/_520it/xml/schema/web.xml");
			//3.��ȡ��Ԫ��
			Element rootElement = doc.getRootElement();
			//System.out.println(rootElement.getName());//��ȡ��Ԫ�ص�����
			//System.out.println(rootElement.attributeValue("version"));
			//4.��ȡ��Ԫ���µ���Ԫ��
			List<Element> childElements = rootElement.elements();
			//5.������Ԫ��
			for (Element element : childElements) {
				if ("servlet".equals(element.getName())) {
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					System.out.println(servletClass.getText());
					System.out.println(servletName.getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
}
