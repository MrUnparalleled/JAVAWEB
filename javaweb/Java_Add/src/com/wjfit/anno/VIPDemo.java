package com.wjfit.anno;

//����������������ע�⹦��
public class VIPDemo {
	public static void main(String[] args) {
		//���󣺻�ȡEmployee�����е�ע��
		//1.�Ȼ�ȡEmployee�ֽ������
		Class<Employee> clz=Employee.class;
		//2.ֱ�ӻ�ȡ�������е�ע��
//		Annotation[] as= clz.getAnnotations();
//		for (Annotation annotation : as) {
//			System.out.println(annotation);;
//		}
		//�ж�Employee�����Ƿ�ʹ����VIPע��
		VIP aVip=clz.getAnnotation(VIP.class);
		if (aVip==null) {
			System.out.println("û��");
		}else {
			System.out.println("��");
			System.out.println(aVip.name());
			System.out.println(aVip.age());
			System.out.println(aVip.hobby());
		}
		
	}
}
