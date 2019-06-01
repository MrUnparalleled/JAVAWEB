package cn.tzc.xianjian.day01;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Polygon;

public class Demo {
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
		MyPanel2 panel=new MyPanel2();
//6.将窗口对象和自定义画板对象进行关联
		ChuangKou.add(panel);
		ChuangKou.setBackground(new Color(255, 248, 220));
//3.让窗口呈现出来
		ChuangKou.show(true);
	}
	
}
class MyPanel2 extends Panel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void drawTriangle(Graphics g,Color color,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4) 
	{ 
		Polygon filledPolygon=new Polygon(); 
		filledPolygon.addPoint(x1,y1); 
		filledPolygon.addPoint(x2,y2); 
		filledPolygon.addPoint(x3,y3); 
		filledPolygon.addPoint(x4,y4); 
		g.setColor(color); 
		g.fillPolygon(filledPolygon); 
	}
	//绘画方法
	public void paint(Graphics G) {
		//可以将g理解成一只画笔
//		g.drawLine(100, 100, 200, 200);//画直线
//		g.drawRect(100, 100, 200, 200);//画矩形
//		g.drawOval(100, 100, 200, 100);//画空心椭圆，外切矩形的左上角坐标，长宽
//		g.setColor(Color.RED);//修改画笔的颜色
//		g.fillRect(200, 200, 100, 100);//画实心矩形
//		g.fillOval(500, 500, 200, 200);//画实心椭圆
//		g.setColor(new Color(22, 22, 22));
//		g.fillOval(500, 500, 100, 100);
		G.setColor(new Color(22, 22, 22));//黑色
		G.fillOval(410, 140, 20, 20);
		G.fillOval(720, 140, 20, 20);
		G.fillRect(420, 148, 320, 5);
		G.fillRect(575, 150, 10, 300);//躯干
		//G.fillRect(525, 470, 10, 200);//左腿
		drawTriangle(G, new Color(1, 1, 1), 525, 470, 535, 670, 545, 670, 535, 470);//左腿
		//G.fillRect(615, 470, 10, 200);//右腿
		drawTriangle(G, new Color(1, 1, 1), 615, 470, 605, 670, 615, 670, 625, 470);//右腿
		G.fillRect(380, 280, 150, 10);//左臂
		G.fillRect(655, 300, 10, 100);//右臂
		G.setColor(new Color(107, 130, 35));//绿色
		G.fillOval(480, 260, 50, 50);//左肩
		G.fillOval(620, 260, 50, 50);//右肩
		
		G.setColor(new Color(255, 69, 0));//橙色
		G.fillRoundRect(360, 170, 10, 30, 10, 10);//左拇指1
		G.fillRoundRect(640, 480, 10, 30, 10, 10);//右拇指
		G.fillRoundRect(655, 480, 10, 30, 10, 10);
		G.fillRoundRect(670, 480, 10, 30, 10, 10);
		G.fillRoundRect(355, 190, 40, 100, 25, 25);//粗手臂左
		G.fillRoundRect(640, 390, 40, 100, 25, 25);//粗手臂右
//		G.fillRect(500, 250, 150, 150);//躯干（橙色）
		G.fillRoundRect(500, 250, 150, 150, 20, 20);
//		G.fillRect(475, 100, 200, 100);//头（橙色）
		G.fillRoundRect(475, 100, 200, 100, 20, 20);
		G.fillOval(450, 125, 50, 50);//左耳（橙色）
		G.fillOval(650, 125, 50, 50);//右耳（橙色）
		G.fillRect(522, 450, 105, 25);//矩形下肢（橙色）
		G.fillOval(515, 450, 25, 25);
		G.fillOval(610, 450, 25, 25);//
		G.fillOval(485, 650, 70, 70);//左脚
		G.fillOval(590, 650, 70, 70);//右脚
		G.setColor(new Color(255, 248, 220));//背景色
		G.fillRect(400, 680, 500, 100);//
		
		G.setColor(new Color(107, 142, 35));//绿色
		G.fillRect(520, 270, 110, 110);//胸口
		G.fillRect(535, 450, 80, 25);//矩形下肢（绿色）
		G.fillOval(519, 545, 30, 30);
		G.fillOval(600, 545, 30, 30);
		
		G.setColor(new Color(122, 197, 205));//蓝色
//		G.fillRect(485, 110, 180, 80);
		G.fillRoundRect(485, 110, 180, 80, 20, 20);
		
		G.setColor(new Color(22, 22, 22));//黑色
		G.fillOval(610, 290, 10, 10);
		G.fillOval(610, 320, 10, 10);
		G.fillOval(610, 350, 10, 10);
		G.fillOval(515, 125, 15, 15);
		G.fillOval(600, 125, 15, 15);
//		G.fillRect(555, 155, 40, 10);//嘴巴
		G.fillRoundRect(555, 160, 40, 10, 10, 10);
		G.fillRect(515, 125, 35, 5);
		G.fillRect(600, 125, 35, 5);
	}
	
}
