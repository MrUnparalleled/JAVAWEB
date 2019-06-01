package cn.tzc.plants;

import javax.swing.JFrame;

public class GameFrame {

	public static void main(String[] args) {
		//创建窗口
		JFrame ChuangKou =new JFrame("植物大战僵尸");
		ChuangKou.setSize(1024, 600);//设置窗口的大小
		ChuangKou.setLocationRelativeTo(null);//出现在屏幕中央
		ChuangKou.setResizable(false);
		ChuangKou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel panel=new GamePanel();
		ChuangKou.add(panel);
		//启动线程
		Thread thread=new Thread(panel);
		thread.start();
		//添加监听
		 ChuangKou.addMouseMotionListener(panel);
		 ChuangKou.addMouseListener(panel);
		//窗口显示
		ChuangKou .setVisible(true);
		
	}

}
