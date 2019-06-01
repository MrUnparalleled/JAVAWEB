package cn.tzc.xianjian.day02;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyGame {

	public static void main(String[] args) {
		//1.绘画游戏窗口
		//1.1创建窗口类的实例化对象
		JFrame frame=new JFrame();
		//1.3设置窗口的相关属性
		frame.setSize(1024, 768);
		frame.setTitle("我的第一个游戏");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		//修改窗口对象的默认关闭操作选项
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//2.2创建自定义画板类的实例化对象
		MyGamePanel myPanel=new MyGamePanel();
		//2.3将窗口对象和自定义画板类的实例化对象进行关联
		frame.add(myPanel);
		//1.2.让窗口对象显示出来
		frame.setVisible(true);
		
	}

	}
	//2.绘画游戏界面
	//2.1 编写自定义画板类
  class MyGamePanel extends JPanel{
	//绘画方法
	public void paint(Graphics graphics) {
		//前提准备，将图片文件和代码文件存放在同一个包下
//		graphics.drawImage(Toolkit.getDefaultToolkit().getImage(MyGamePanel.class.getResource("/Game_XianJian/src/cn/tzc/xianjian/day02/0.png")), -200, -200, this);
		//绘画7个配角图片
		//配角：阿旺婶，旺财嫂，阿朱，小孩，巨鸡，小鸡，小小鸡
//		ImageIcon bg=new ImageIcon("./Legend_of_Sword_and_Fairy/LiJiaCun/0.png");
//		JLabel label=new JLabel(bg);
//		label.setBounds(0,0, bg.getIconWidth(), bg.getIconHeight());
		graphics.drawImage(new ImageIcon("E:/java/workspace/Game_XianJian/Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/LiJiaCun/0.png").getImage(),-200,-200,this);
		graphics.drawImage(new ImageIcon("E:/java/workspace/Game_XianJian/Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/AWangShen/0.png").getImage(),450,310,this);
		graphics.drawImage(new ImageIcon("E:/java/workspace/Game_XianJian/Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/MuJi/0.png").getImage(),530,100,this);
		graphics.drawImage(new ImageIcon("E:/java/workspace/Game_XianJian/Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/WangCaiSao/0.png").getImage(),580,280,this);
		graphics.drawImage(new ImageIcon("E:/java/workspace/Game_XianJian/Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoJi/0.png").getImage(),500,160,this);
		graphics.drawImage(new ImageIcon("E:/java/workspace/Game_XianJian/Legend_of_Sword_and_Fairy/Legend_of_Sword_and_Fairy/XiaoXiaoJi/0.png").getImage(),500,130,this);
}

}
