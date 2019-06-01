package cn.tzc.plants;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, MouseListener,MouseMotionListener{
	//定义变量
	Image bjImage;
	int bjX;
	int bjY;
	//B僵尸
	Image[] bucketImages;
	int bucketX;
	int bucketY;
	int bucketIndex;
	//C僵尸
	Image[] coneheadImages;
	int coneheadX;
	int coneheadY;
	int coneheadIndex;
	//N僵尸
	Image[] normalImages;
	int normalX;
	int normalY;
	int normalIndex;
	//锤子
	Image[] hammerImages;
	int hammerX;
	int hammerY;
	int hammerIndex;
	//构造方法
	public GamePanel(){
		//定义数组大小
		bucketImages=new Image[8];
		coneheadImages=new Image[8];
		normalImages=new Image[8];
		hammerImages=new Image[2];
		//初始化图片
		try {
			bjImage=ImageIO.read(new File("Plants vs zombies/background.jpg"));
			for(int i=0;i<bucketImages.length;i++) {
			bucketImages[i]=ImageIO.read(new File("Plants vs zombies/zombie_bucket/z_02_0"+(i+1)+".png"));
			}
			for(int i=0;i<coneheadImages.length;i++) {
			coneheadImages[i]=ImageIO.read(new File("Plants vs zombies/zombie_conehead/z_01_0"+(i+1)+".png"));
			}
			for(int i=0;i<normalImages.length;i++) {
			normalImages[i]=ImageIO.read(new File("Plants vs zombies/zombie_normal/z_00_0"+(i+1)+".png"));
			}
			hammerImages[0]=ImageIO.read(new File("Plants vs zombies/hammer/hammer.png"));
			hammerImages[1]=ImageIO.read(new File("Plants vs zombies/hammer/hammer_down.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bjX=0;
		bjY=0;
		bucketX=1024;
		bucketY=110;
		bucketIndex=0;
		coneheadX=1024;
		coneheadY=10;
		coneheadIndex=0;
		normalX=1024;
		normalY=240;
		normalIndex=0;
		hammerIndex=0;
	}
	
	public void paint(Graphics graphics) {
		//设置背景图片
		graphics.drawImage(bjImage, bjX, bjY, this);
		graphics.drawImage(bucketImages[bucketIndex], bucketX, bucketY, this);
		graphics.drawImage(coneheadImages[coneheadIndex], coneheadX, coneheadY, this);
		graphics.drawImage(normalImages[normalIndex], normalX, normalY, this);
		graphics.drawImage(hammerImages[hammerIndex], hammerX, hammerY, this);
	}
	//实现僵尸的动态变换和移动
	public void run() {
			while (true) {
				bucketIndex++;
				if (bucketIndex>=bucketImages.length) {
					bucketIndex=0;
				}
				coneheadIndex++;
				if (coneheadIndex>=coneheadImages.length) {
					coneheadIndex=0;
				}
				normalIndex++;
				if (normalIndex>=normalImages.length) {
					normalIndex=0;
				}
				bucketX=bucketX-3;
				coneheadX--;
				normalX=normalX-2;
				if (bucketX<=210) {
					bucketX=1024;
				}
				if (coneheadX<=210) {
					coneheadX=1024;
				}if (normalX<=210) {
					normalX=1024;
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		hammerIndex=1;
//		hammerX=hammerX-10;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		hammerIndex=0;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		hammerX=e.getX()-30;
		hammerY=e.getY()-120;
	}


}
