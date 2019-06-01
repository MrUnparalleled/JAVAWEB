package cn.tzc.xianjian.day03;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 本类游戏用来表示游戏项目的窗口
 * @author 吴锦锋
 *
 */
public class GameFrame {
	public static void main(String[] args) {
		String Message;
		//1.1创建窗口，设置窗口标题
		JFrame ChuangKou =new JFrame("仙剑奇侠传-传奇版-1.0");
		//设置窗口大小不可更改
		ChuangKou.setResizable(false);
		//设置窗口大小
		ChuangKou.setSize(1024, 768);
		//窗口居中显示
		ChuangKou.setLocationRelativeTo(null);
		//设置窗口的关闭方式
		ChuangKou.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//当窗口关闭时，需弹出一个确认对话框
		ChuangKou.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				super.windowOpened(e);
//				String xinxi=JOptionPane.showInputDialog(null,"请输入信息");
//				JOptionPane.showMessageDialog(null, xinxi);
//			}
			//当窗口正在被关闭的时候会自动调用执行的方法
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//输入对话框
//				String xinxi=JOptionPane.showInputDialog(null,"请输入信息");
//				//消息对话框
//				JOptionPane.showMessageDialog(null, xinxi);
				//确认对话框
				int jieguo=JOptionPane.showConfirmDialog(null, "确定要离开嘛？","确认对话框",JOptionPane.YES_NO_OPTION);
				if (jieguo==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		

		
		//2.2创建自定义画板类实例化对象
		GamePanel panel=new GamePanel();
		//设置背景音乐
		// 初始化音乐
		MP3	ljcMusic = new MP3("E:/java/workspace/Game_XianJian/Music/BGM1.wav");
		ljcMusic.play();
		MP3	ddMusic = new MP3("E:/java/workspace/Game_XianJian/Music/fight1.wav");
		//2.3将窗口对象和自定义画板对象进行关联
		ChuangKou.add(panel);
		//创建线程类的实例化对象，同时关联自定义画板对象，然后启动线程对象。
		Thread xiancheng =new Thread(panel);
		xiancheng.start();
		//改变鼠标光标
		Cursor coursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("Image/mouse.png").getImage(),new Point(10,20), "stick");
		ChuangKou.setCursor(coursor);
		//
		ChuangKou.addKeyListener(panel);
		panel.addKeyListener(panel);

		//1.2使窗口显现出来
		ChuangKou.setVisible(true);
	}
//	public void read() throws Exception {
//		String DB_URL="jdbc:mysql://localhost:3306/jdbcdemo"+"?serverTimezone=GMT%2B8";
//		String sql="CREATE TABLE t_student(id bigint(20) primary key auto_increment,name varchar(20));";
//		//加载注册驱动
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		//获取连接对象
//		Connection conn=DriverManager.getConnection(DB_URL, "root", "root");
//		Statement state= conn.createStatement();
//		int i=state.executeUpdate(sql);
//		state.close();
//		conn.close();
//		
//		System.out.println(i);
//		
//		
//	}

}
