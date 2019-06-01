package cn.tzc.xianjian.day01;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

/**
 * 本类文件用来表示我的第一个窗口文件
 * 运行程序后，会在电脑屏幕中间出现一个1024*768大小的游戏窗口
 * @author 吴锦锋
 *
 */

public class FirstDemo {
	//主方法，开始执行程序后开始执行代码的入口
	@SuppressWarnings("deprecation")
	public static void main(String [] args) {
		/*
		 * 知识点：类和对象
		 * 类：是抽象的概念
		 * 对象：是抽象的具体实例化
		 * 
		 * 知识点：如何将类变成对象
		 * 创建类的实例化对象：类名 对象名 = new 类名（）；
		 */
//1.创建窗口类的实例化对象
		Frame ChuangKou=new Frame();
//2.设置窗口的相关内容（长宽，位置）
		//设置窗口的属性
		ChuangKou.setSize(1024, 768);
		//设置相对位置（让窗口出现在屏幕中央）
		ChuangKou.setLocationRelativeTo(null);
		//设置窗口标题
		ChuangKou.setTitle("我的窗口程序");
		ChuangKou.setResizable(false);
//5.创建自定义画板类的实例化对象
		MyPanel panel=new MyPanel();
//6.将窗口对象和自定义画板对象进行关联
		ChuangKou.add(panel);
		ChuangKou.setBackground(new Color(255, 248, 220));
//3.让窗口呈现出来
		ChuangKou.show();
	}
}
//4.编写自定义画板类
class MyPanel extends Panel{
	//绘画方法
	public void paint(Graphics g) {
		//可以将g理解成一只画笔
		g.drawLine(100, 100, 200, 200);//画直线
		g.drawRect(100, 100, 200, 200);//画矩形
		g.drawOval(100, 100, 200, 100);//画空心椭圆，外切矩形的左上角坐标，长宽
		g.setColor(Color.RED);//修改画笔的颜色
		g.fillRect(200, 200, 100, 100);//画实心矩形
		g.fillOval(500, 500, 200, 200);//画实心椭圆
		g.setColor(new Color(22, 22, 22));
		g.fillOval(500, 500, 100, 100);
	}
}
