package cn.tzc.plants;

import javax.swing.JFrame;

public class GameFrame {

	public static void main(String[] args) {
		//��������
		JFrame ChuangKou =new JFrame("ֲ���ս��ʬ");
		ChuangKou.setSize(1024, 600);//���ô��ڵĴ�С
		ChuangKou.setLocationRelativeTo(null);//��������Ļ����
		ChuangKou.setResizable(false);
		ChuangKou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel panel=new GamePanel();
		ChuangKou.add(panel);
		//�����߳�
		Thread thread=new Thread(panel);
		thread.start();
		//��Ӽ���
		 ChuangKou.addMouseMotionListener(panel);
		 ChuangKou.addMouseListener(panel);
		//������ʾ
		ChuangKou .setVisible(true);
		
	}

}
