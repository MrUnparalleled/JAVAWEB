package cn.tzc.xianjian.day03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

//前提准备：将素材文件夹复制粘贴到工程目录下
//知识点：路径-->绝对路径+相对路径
//绝对路径：以盘符（C:）或者根目录（/）开始的路径
//相对路径：在代码中相对路径从工程名称后面开始书写路径
/**
 * 本类游戏用来表示游戏项目的画板
 * 
 * @author 吴锦锋
 *
 */
// 绘画游戏界面
// 2.1编写自定义画板类
// 知识点：在Java语言中，遵循单继承（类）多实现（接口）
public class GamePanel extends JPanel implements Runnable, KeyListener {
	Image EndImage;
	//===================物品栏===========================
	Image wpIcon;
	Image redAddIcon;
	Image blueAddIcon;
	Image redHurtIcon;
	Image blueHurtIcon;
	Image renwuIcon;
	Image fishIcon;
	//==================物品栏系统=========================
	int Add_Red_Num;
	int Add_Red;
	int Add_blue;
	int Add_Blue_Num;
	int FishNum;
	//=================任务系统===============================
	Image renwu;
	boolean isShow_RenWu;
	String[] renwuMessages;
	int renwuIndex;
	//===============怪物属性值================================
	int Red_yg;
	int Hurt_yg;
	int DefensivePower_yg;
	//=============人物的基本属性================================
	int Level;//等级
	int Red_lxy;//人物血量
	int Blue_lxy;//人物法力
	int NowYellow_lxy;//人物当前经验
	int NeedYello_lxy;//人物升级所需经验
	int RedHurt_lxy;//物理伤害
	int BlueHurt_lxy;//法术伤害
	int BlueUse_lxy;//法术耗蓝
	int DefensivePower_lxy;//防御力
	Image lxyMessageImage;
	Image FightEnd;
	Image Win;
	boolean canBlue;
	//==============================================
	//定义片头图片
	Image dgImage;//背景图片
	Image[] dg_lxygj_pgImages;//普通攻击李逍遥照片
	int dg_gj_lxypgIndex;
	Image[] dg_lxygj_jnImages;//技能攻击李逍遥
	int dg_gj_lxyjnIndex;
	Image[] dg_lxyBgjImages;//被攻击动作
	int dg_bgj_lxyIndex;
	Image[] dg_jnImages;//攻击技能特效
	Image[] dg_pgImages;//普攻特效
	int dg_pgIndex;
	Image[] dg_gj_gwImages;//鱼怪攻击
	int dg_gj_gwIndex;
	Image[] dg_bgj_gwImages;//鱼怪被攻击
	int dg_bgj_gwIndex;
	int dg_lxyX;
	int dg_lxyY;
	Image[] dg_zlImages;//治疗技能
	int dg_zlIndex;
	boolean isZL;
	boolean isPG;
	boolean isJN;
	boolean isDG_zl_lxy;
	boolean isDG_pg_lxy;
	boolean isMe;
	boolean isbgj_gw;
	boolean isgj_gw;
	boolean death_lxy;
	boolean death_yg;
	
	//=============================================
	// a.定义李家村图片的相关内容
	BufferedImage ljcDateImage;// 定义李家村障碍地图
	Image ljcImage;// 用来存储李家村图片的内容
	int ljcX;// 用来表示李家村图片左上角点的X
	int ljcY;// 用来表示李家村图片左上角点的Y
	// 定义阿旺婶图片的相关内容
	Image[] awsImages;// 用来存储阿旺婶配角下的所有图片的内容
	int awsX;
	int awsY;
	int awsIndex;
	// 定义母鸡图片的相关内容
	Image[] mjImages;
	int mjX;
	int mjY;
	int mjIndex;
	// 定义旺财嫂图片的相关内容
	Image[] wcsImages;
	int wcsX;
	int wcsY;
	int wcsIndex;
	// 定义小鸡图片的相关内容
	Image[] xjImages;
	int xjX;
	int xjY;
	int xjIndex;
	// 定义阿朱图片的相关内容
	Image[] azImages;
	int azX;
	int azY;
	int azIndex;
	// 定义小小鸡图片的相关内容
	Image[] xxjImages;
	int xxjX;
	int xxjY;
	int xxjIndex;
	// 定义小孩图片的相关内容
	Image[] xhImages;
	int xhX;
	int xhY;
	int xhIndex;
	// 定义李逍遥动作
	int lxyX;
	int lxyY;
	Image[] left_lxyImages;
	Image[] right_lxyImages;
	Image[] up_lxyImages;
	Image[] down_lxyImages;
	Image[] Up_Left_lxyImages;
	Image[] Up_Right_lxyImages;
	Image[] Down_Left_lxyImages;
	Image[] Down_Right_lxyImages;
	Image lxyImage;
	int lxyIndex;// 定义李逍遥的数组下标
	int lxyDir;// 定义李逍遥运动方向
	// 定义按键状态
	boolean isLeft;
	boolean isRight;
	boolean isUp;
	boolean isDown;
	// 定义人物移动速度
	int Speed;
	int HighSpeed;
	// 定义速度状态
	boolean isHighSpeed;
	// 定义加速特效
	Image[] jsBuffImages;
	Image nulljsBuffImage;
	int jsBuffIndex;
	int jsBuffX;
	int jsBuffY;
	// 正在使用的循环背景音乐
	MP3 Music;
	// 定义地图
	int MapId;
	// 定义李逍遥的中心位置
	int x;
	int y;
	Image[] TitleImages;
	int xTitle;
	int yTitle;
	int TitleIndex;
	boolean isTitle;
	// 定义聊天相关属性
	Image ltImage;
	int ltImageX;
	int ltImageY;
	String ltMessage;
	int ltIndex;
	// 旺财嫂话
	String lt_0_wcsMessage;
	String[] lt_1_wcsMessages;
	String[] lt_2_wcsMessages;
	String[] lt_3_wcsMessages;
	// 阿朱话
	String lt_0_azMessage;
	String lt_2_azMessage;
	String[] lt_1_azMessages;
	// 阿旺婶
	String[] lt_1_1awsMessages;
	String[] lt_1_0awsMessages;
	String[] lt_2_0awsMessages;
	String[] lt_2_1awsMessages;
	String[] lt_3_1awsMessages;
	String[] lt_3_2awsMessages;
	// 小孩
	String[] lt_2_xhMessages;
	String[] lt_1_xhMessages;
	String lt_0_xhMessage;
	// 李逍遥
	String[] lt_0_lxyMessages;
	String faceman;
	int Dir1;// 定义竖直方向
	int Dir2;// 定义水平方向
	int lxyNow;
	boolean IsLtShow;

	// 构造方法
	public GamePanel() {
		// 定义数组长度
		xhImages = new Image[4];
		xjImages = new Image[2];
		xxjImages = new Image[2];
		azImages = new Image[6];
		awsImages = new Image[17];
		mjImages = new Image[6];
		wcsImages = new Image[14];
		left_lxyImages = new Image[4];
		right_lxyImages = new Image[4];
		up_lxyImages = new Image[4];
		down_lxyImages = new Image[4];
		Up_Left_lxyImages = new Image[4];
		Up_Right_lxyImages = new Image[4];
		Down_Left_lxyImages = new Image[4];
		Down_Right_lxyImages = new Image[4];
		jsBuffImages = new Image[16];
		TitleImages = new Image[9];
		//====================
		dg_lxygj_jnImages=new Image[3];
		dg_lxygj_pgImages=new Image[4];
		dg_lxyBgjImages=new Image[3];
		dg_zlImages=new Image[8];
		dg_pgImages=new Image[5];
		dg_bgj_gwImages=new Image[5];
		dg_gj_gwImages=new Image[6];
		// b.初始化李家村场景的图片相关内容
		try {
			//==========初始化技能栏======
			wpIcon=ImageIO.read(new File("Image/jinengkuang.png"));
			blueAddIcon=ImageIO.read(new File("Image/blue.jpg"));
			blueHurtIcon=ImageIO.read(new File("Image/blueHurt.png"));
			redAddIcon=ImageIO.read(new File("Image/red.jpg"));
			redHurtIcon=ImageIO.read(new File("Image/redHurt.png"));
			fishIcon=ImageIO.read(new File("Image/fish.jpg"));
			renwuIcon=ImageIO.read(new File("Image/renwu.jpg"));
			//=========初始化打斗场景==============
			Win=ImageIO.read(new File("DaGuai/Win.png"));
			FightEnd=ImageIO.read(new File("DaGuai/End.png"));
			dgImage=ImageIO.read(new File("DaGuai/dg_background.png"));
			for (int i = 0; i < dg_lxygj_jnImages.length; i++) {
				dg_lxygj_jnImages[i]=ImageIO.read(new File("DaGuai/DaDou/gj_jn/"+i+".png"));
			}
			for (int i = 0; i < dg_lxygj_pgImages.length; i++) {
				dg_lxygj_pgImages[i]=ImageIO.read(new File("DaGuai/DaDou/gj_pg/"+i+".png"));
			}
			for (int i = 0; i < dg_lxyBgjImages.length; i++) {
				dg_lxyBgjImages[i]=ImageIO.read(new File("DaGuai/DaDou/bgj/"+i+".png"));
			}
			for (int i = 0; i < dg_zlImages.length; i++) {
				dg_zlImages[i]=ImageIO.read(new File("DaGuai/JiNen/ZhiLiao/"+i+".png"));
			}
			for (int i = 0; i < dg_pgImages.length; i++) {
				dg_pgImages[i]=ImageIO.read(new File("DaGuai/JiNen/PuGong/"+i+".png"));
			}
			for (int i = 0; i < dg_gj_gwImages.length; i++) {
				dg_gj_gwImages[i]=ImageIO.read(new File("DaGuai/YuGuai/gj/"+i+".png"));
			}
			for (int i = 0; i < dg_bgj_gwImages.length; i++) {
				dg_bgj_gwImages[i]=ImageIO.read(new File("DaGuai/YuGuai/bgj/"+i+".png"));
			}
			//===========初始化李家村================
			EndImage=ImageIO.read(new File("Image/end.png"));
			renwu=ImageIO.read(new File("Image/juanzhou.png"));
			lxyMessageImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/RenWu/ztl.png"));
			//初始化李家村障碍地图
			ljcDateImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/LiJiaCun/RedMap.png"));
			// 初始化李家村
			ljcImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/LiJiaCun/0.png"));
			// 初始化阿旺婶
			for (int i = 0; i < awsImages.length; i++) {
				awsImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/AWangShen/" + i + ".png"));
			}
			// 初始化母鸡
			for (int i = 0; i < mjImages.length; i++) {
				mjImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/MuJi/" + i + ".png"));
			}
			// 初始化旺财嫂
			for (int i = 0; i < wcsImages.length; i++) {
				wcsImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/WangCaiSao/" + i + ".png"));
			}
			// 初始化小鸡
			for (int i = 0; i < xjImages.length; i++) {
				xjImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/XiaoJi/" + i + ".png"));
			}
			// 初始化小小鸡图片
			for (int i = 0; i < xxjImages.length; i++) {
				xxjImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/XiaoXiaoJi/" + i + ".png"));
			}
			// 初始化阿朱图片
			for (int i = 0; i < azImages.length; i++) {
				azImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/AZhu/" + i + ".png"));
			}
			// 初始化小孩图片
			for (int i = 0; i < xhImages.length; i++) {
				xhImages[i] = ImageIO.read(new File("Legend_of_Sword_and_Fairy/XiaoHai/" + i + ".png"));
			}
			// 初始化李逍遥的动作图片
			for (int i = 0; i < left_lxyImages.length; i++) {
				left_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/left/" + i + ".png"));
			}
			for (int i = 0; i < right_lxyImages.length; i++) {
				right_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/right/" + i + ".png"));
			}
			for (int i = 0; i < up_lxyImages.length; i++) {
				up_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/up/" + i + ".png"));
			}
			for (int i = 0; i < down_lxyImages.length; i++) {
				down_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/down/" + i + ".png"));
			}
			for (int i = 0; i < Up_Left_lxyImages.length; i++) {
				Up_Left_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/up_left/" + i + ".png"));
			}
			for (int i = 0; i < Down_Left_lxyImages.length; i++) {
				Down_Left_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/down_left/" + i + ".png"));
			}
			for (int i = 0; i < Down_Right_lxyImages.length; i++) {
				Down_Right_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/down_right/" + i + ".png"));
			}
			for (int i = 0; i < Up_Right_lxyImages.length; i++) {
				Up_Right_lxyImages[i] = ImageIO.read(new File("LiXiaoYao/up_right/" + i + ".png"));
			}
			// 初始化加速
			for (int i = 0; i < jsBuffImages.length; i++) {
				jsBuffImages[i] = ImageIO.read(new File("buff/" + i + ".png"));
			}
			nulljsBuffImage = ImageIO.read(new File("buff/16.png"));
			// 初始化人物称号
			for (int i = 0; i < TitleImages.length; i++) {
				TitleImages[i] = ImageIO.read(new File("title2/" + i + ".png"));
			}
			ltImage = ImageIO.read(new File("Legend_of_Sword_and_Fairy/LiaoTian/0.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ljcX = -200;
		ljcY = -200;
		// 初始化阿旺婶图片的相关内容
		awsX = 650;
		awsY = 510;
		awsIndex = 0;
		// 初始化母鸡图片的相关内容
		mjX = 740;
		mjY = 340;
		mjIndex = 0;
		// 初始化旺财嫂图片的相关内容
		wcsX = 780;
		wcsY = 480;
		wcsIndex = 0;
		// 初始化小鸡图片的相关内容
		xjX = 710;
		xjY = 370;
		xjIndex = 0;
		// 初始化小小鸡图片的相关内容
		xxjX = 710;
		xxjY = 340;
		xxjIndex = 0;
		// 初始化阿朱图片的相关内容
		azX = 730;
		azY = 250;
		azIndex = 0;
		// 初始化小孩图片的相关内容
		xhX = 1090;
		xhY = 770;
		xhIndex = 0;
		// 初始化李逍遥的相关内容
		lxyX = 400;
		lxyY = 400;
		lxyIndex = 0;
		lxyImage = down_lxyImages[lxyIndex];
		// 初始化按键状态值
		isRight = false;
		isLeft = false;
		isUp = false;
		isDown = false;
		// 初始化李逍遥移动速度
		Speed = 10;
		HighSpeed = 20;
		isHighSpeed = false;
		// 初始化加速Buff
		jsBuffIndex = 0;
		jsBuffX = -5;
		jsBuffY = 70;
		
		// 初始化地图
		MapId = 1;
		// 初始化人物称号
		xTitle = -70;
		yTitle = -64;
		TitleIndex = 0;
		isTitle = false;
		//==================初始化任务系统================
		renwuMessages=new String[] {"找阿旺婶谈话","找旺财嫂谈话","找小孩谈话","找阿朱谈话","找旺财嫂谈话","找阿旺婶谈话","进入副本打鱼怪","找阿旺婶谈话"};
		renwuIndex=0;
		// 初始化聊天功能的相关内容
		lt_0_azMessage = new String("小鸡.小鸡.快长大");
		lt_0_wcsMessage = new String("洗刷刷.洗刷刷");
		lt_0_xhMessage = new String("你要一起玩吗？");
		lt_2_azMessage = new String("阿朱已经去找了吧");
		lt_0_lxyMessages = new String[] { "世界那么大,我想去看看", "那我去跟阿旺婶说一下" };
		lt_1_azMessages = new String[] { "李逍遥：阿朱~", "阿朱：逍遥啊！什么事", "李逍遥：你能不能帮我去把旺财领回家", "阿朱：他在哪儿啊", "李逍遥：在村东跳绳呢",
				"一定要你去才肯回家", "阿朱：好的，我这就去" };
		lt_1_1awsMessages = new String[] { "李逍遥：你嚎，阿旺婶", "阿旺婶：哟，是逍遥啊！！", "李逍遥：我跟你说个...", "阿旺婶：你帮我去旺财嫂那边拿几件衣服来",
				"李逍遥：那个...", "阿旺婶：快点", "李逍遥：哦" };
		lt_2_1awsMessages = new String[] { "李逍遥：婶，你要的衣服", "阿旺婶：哦", "李逍遥：我想去外面的世界看看", "你帮我照看一下家里",
				"阿旺婶：就你？你先去杀个鱼怪来看看" };
		lt_2_0awsMessages = new String[] { "阿旺婶：怎么了？不敢", "李逍遥：呵呵，等着" };
		lt_3_1awsMessages = new String[] { "李逍遥：婶，我把鱼怪杀了", "阿旺婶：哟，还行吧", "李逍遥：那我出去闯荡啦！！", "阿旺婶：你要出去，我不拦着你",
				"不过你可千万小心" };
		lt_1_0awsMessages = new String[] { "阿旺婶：你怎么回来了？！！", "李逍遥：溜了溜了.." };
		lt_1_wcsMessages = new String[] { "李逍遥：旺财嫂~~~", "旺财嫂:去把我家旺财找回来", "李逍遥：那个...", "旺财嫂：他和别人去跳绳去了", "李逍遥：哦~",
				"李逍遥：就不能听我把话说完嘛(一脸无奈~~)" };
		lt_3_wcsMessages = new String[] { "李逍遥：你家旺财回来了吧", "旺财嫂：哦，回来了，你走吧", "李逍遥：那我走了", "等一下，我找你是阿旺婶要拿几件衣服",
				"旺财嫂：就这点事？，你不早说", "李逍遥：..." };
		lt_2_wcsMessages = new String[] { "旺财嫂：快去快去", "李逍遥：溜了溜了" };
		lt_1_xhMessages = new String[] { "李逍遥：喂，小屁孩，旺财呢", "旺财：有屁快放", "李逍遥：...(这么狂？？)", "你妈找你回家吃饭呢！！", "旺财：不去，除非...",
				"你让我阿朱姐姐来带我回去", "李逍遥：我懒得去", "旺财：那我就和我妈说你欺负我", "李逍遥：..." };
		lt_2_xhMessages = new String[] { "旺财：嘿，你怎么还在这", "李逍遥：社会社会" };
		ltMessage = "hello";
		faceman = "";
		Dir1 = KeyEvent.VK_DOWN;
		Dir2 = KeyEvent.VK_SPACE;
		lxyNow = 1;
		IsLtShow = false;
		ltIndex = 0;
		isShow_RenWu=false;
		
		//==================
		dg_lxyX=800;
		dg_lxyY=400;
		dg_gj_lxyjnIndex=0;
		dg_bgj_lxyIndex=0;
		dg_gj_lxypgIndex=0;
		dg_gj_gwIndex=0;
		dg_bgj_gwIndex=0;
		isJN=false;
		isZL=false;
		isPG=false;
		isDG_pg_lxy=false;
		isDG_zl_lxy=false;
		isMe=true;
		isbgj_gw=false;
		isgj_gw=false;
		death_lxy=false;
		death_yg=false;
		//=======初始化人物属性==========
		Level=1;
		Red_lxy=100;
		Blue_lxy=200;
		NowYellow_lxy=0;
		NeedYello_lxy=50;
		RedHurt_lxy=20;
		BlueHurt_lxy=50;
		BlueUse_lxy=30;
		DefensivePower_lxy=15;
		canBlue=true;
		//==========初始化怪物属性=========
		Red_yg=100;
		Hurt_yg=20;
		DefensivePower_yg=10;
		//=============物品栏=================
		FishNum=0;
		Add_Red=50;
		Add_Red_Num=5;
		Add_blue=50;
		Add_Blue_Num=5;
	}

	// 绘画方法
	public void paint(Graphics graphics) {
		if (MapId==0) {
			graphics.drawImage(dgImage, 0, 0, this);
			if (death_lxy==true ||death_yg==true) {
				if (death_lxy==true) {
					graphics.drawImage(FightEnd, 0, 0, this);
				}
				if (death_yg==true) {
					graphics.drawImage(Win, 600, 400, this);
				}
			}
			else {
			if (isMe==false) {
				graphics.drawImage(dg_gj_gwImages[dg_gj_gwIndex], 200, 300, this);
				graphics.drawImage(dg_lxyBgjImages[dg_bgj_lxyIndex], dg_lxyX, dg_lxyY, this);
			}
			if (isMe==true) {
				if (isDG_zl_lxy==false&& isDG_pg_lxy==false) {
					graphics.drawImage(dg_lxygj_jnImages[0], dg_lxyX, dg_lxyY, this);
					graphics.drawImage(dg_bgj_gwImages[0], 200, 300, this);
				}
				if (isZL==true && canBlue==true) {
					graphics.drawImage(dg_zlImages[dg_zlIndex], 120, 80, this);
				}
				if (isDG_pg_lxy==true) {
					graphics.drawImage(dg_lxygj_pgImages[dg_gj_lxypgIndex], dg_lxyX, dg_lxyY, this);
					graphics.drawImage(dg_bgj_gwImages[dg_bgj_gwIndex], 200, 300, this);
				}
				if (isDG_zl_lxy==true && canBlue==true) {
					graphics.drawImage(dg_lxygj_jnImages[dg_gj_lxyjnIndex], dg_lxyX, dg_lxyY, this);
					graphics.drawImage(dg_bgj_gwImages[dg_bgj_gwIndex], 200, 300, this);
				}
				if (isPG==true) {
					graphics.drawImage(dg_pgImages[dg_pgIndex], 100, 150, this);
				}
			}
			//人物属性显示
			graphics.drawImage(lxyMessageImage, 600, -30, this);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("微软雅黑", Font.BOLD, 15));
			graphics.drawString(" "+Red_lxy, 830, 34);
			graphics.drawString(" "+NowYellow_lxy, 950, 34);
			graphics.drawString(" "+BlueHurt_lxy, 930, 58);
			graphics.drawString(" "+RedHurt_lxy, 830, 58);
			graphics.drawString(" "+DefensivePower_lxy, 830, 82);
			graphics.drawString(" "+Blue_lxy, 930, 82);
			graphics.drawString(" "+Level, 665, 110);
			//鱼怪属性显示
			graphics.drawImage(lxyMessageImage, -30, -30, this);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("微软雅黑", Font.BOLD, 15));
			graphics.drawString(" "+Red_yg, 200, 34);
			graphics.drawString(" "+Hurt_yg, 200, 58);
			graphics.drawString(" "+DefensivePower_yg, 200, 82);
			graphics.drawString(" 1", 35, 110);
			}
		}
		// c.绘画李家村图片的相关内容
		if (MapId == 1) {
			if (NowYellow_lxy>=NeedYello_lxy) {
				Level+=1;
				NeedYello_lxy=2*NeedYello_lxy;
			}
			graphics.drawImage(ljcImage, ljcX, ljcY, this);
			graphics.drawImage(awsImages[awsIndex], awsX + ljcX, awsY + ljcY, this);
			graphics.drawImage(mjImages[mjIndex], mjX + ljcX, mjY + ljcY, this);
			graphics.drawImage(wcsImages[wcsIndex], wcsX + ljcX, wcsY + ljcY, this);
			graphics.drawImage(xjImages[xjIndex], xjX + ljcX, xjY + ljcY, this);
			graphics.drawImage(xxjImages[xxjIndex], xxjX + ljcX, xxjY + ljcY, this);
			if (lxyNow<=4) {
				graphics.drawImage(azImages[azIndex], azX + ljcX, azY + ljcY, this);
				graphics.drawImage(xhImages[xhIndex], xhX + ljcX, xhY + ljcY, this);
			}
			graphics.drawImage(lxyImage, lxyX, lxyY, this);
			// 绘制加速buff
			if (isHighSpeed == true) {
				graphics.drawImage(jsBuffImages[jsBuffIndex], jsBuffX + lxyX, jsBuffY + lxyY, this);
			}
			// 绘画人物称号
			if (isTitle == true) {
				graphics.drawImage(TitleImages[TitleIndex], xTitle + lxyX, lxyY + yTitle, this);
			}
			if (IsLtShow == true) {
				ltImageX = (this.getWidth() - ltImage.getWidth(null)) / 2;
				ltImageY = this.getHeight() - ltImage.getHeight(null);
				graphics.drawImage(ltImage, ltImageX, ltImageY, this);
				graphics.setColor(Color.RED);
				graphics.setFont(new Font("微软雅黑", Font.BOLD, 20));
				if (lxyNow == 1) {
					if (faceman == "aws") {
						graphics.drawString(lt_1_1awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "az") {
						graphics.drawString(lt_0_azMessage, ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "wcs") {
						graphics.drawString(lt_0_wcsMessage, ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "xh") {
						graphics.drawString(lt_0_xhMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==2) {
					if (faceman == "aws") {
						graphics.drawString(lt_1_0awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "az") {
						graphics.drawString(lt_0_azMessage, ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "wcs") {
						graphics.drawString(lt_1_wcsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "xh") {
						graphics.drawString(lt_0_xhMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==3) {
					if (faceman == "aws") {
						graphics.drawString(lt_1_0awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "az") {
						graphics.drawString(lt_0_azMessage, ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "wcs") {
						graphics.drawString(lt_2_wcsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "xh") {
						graphics.drawString(lt_1_xhMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==4) {
					if (faceman == "aws") {
						graphics.drawString(lt_1_0awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "az") {
						graphics.drawString(lt_1_azMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "wcs") {
						graphics.drawString(lt_2_wcsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman == "xh") {
						graphics.drawString(lt_0_xhMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==5) {
					if (faceman=="aws") {
						graphics.drawString(lt_1_0awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman=="wcs") {
						graphics.drawString(lt_3_wcsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman=="az") {
						graphics.drawString(lt_2_azMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==6) {
					if (faceman=="aws") {
						graphics.drawString(lt_2_1awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman=="wcs") {
						graphics.drawString(lt_0_wcsMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==7) {
					if (faceman=="aws") {
						graphics.drawString(lt_2_0awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman=="wcs") {
						graphics.drawString(lt_0_wcsMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				if (lxyNow==8) {
					if (faceman=="aws") {
						graphics.drawString(lt_3_1awsMessages[ltIndex], ltImageX + 30, ltImageY + 50);
					}
					if (faceman=="wcs") {
						graphics.drawString(lt_0_wcsMessage, ltImageX + 30, ltImageY + 50);
					}
				}
				
			}
			if (isShow_RenWu==true) {
				graphics.drawImage(renwu, -100, -200, this);
				graphics.setFont(new Font("黑体", Font.BOLD, 25));
				graphics.drawString(renwuMessages[lxyNow-1], 770, 450);
			}
			//========绘画物品栏============
			graphics.drawImage(wpIcon, 965, 200, this);
			graphics.drawImage(wpIcon, 965, 350, this);
			graphics.drawImage(redHurtIcon, 974, 244, this);
			graphics.drawImage(blueHurtIcon, 974, 207, this);
			graphics.drawImage(redAddIcon, 974, 280, this);
			graphics.drawImage(blueAddIcon, 974, 316, this);
			graphics.drawImage(renwuIcon, 974, 357, this);
			graphics.drawImage(fishIcon, 974, 393, this);
			//========================================
			graphics.drawImage(lxyMessageImage, -30, -30, this);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("微软雅黑", Font.BOLD, 15));
			graphics.drawString(" "+Red_lxy, 200, 34);
			graphics.drawString(" "+NowYellow_lxy+"/"+NeedYello_lxy, 310, 34);
			graphics.drawString(" "+BlueHurt_lxy, 300, 58);
			graphics.drawString(" "+RedHurt_lxy, 200, 58);
			graphics.drawString(" "+DefensivePower_lxy, 200, 82);
			graphics.drawString(" "+Blue_lxy, 300, 82);
			graphics.drawString(" "+Level, 35, 110);
			if (lxyNow==9) {
				graphics.drawImage(EndImage, 0, 0, this);
				lxyNow++;
			}
		}
	}
	
	// 运动方法
	public void run() {
		// 实现配角的运动效果
		// 本质上来说，也就是不断的修改图片数组的当前下标
		while (true) {
			peopleRun();
			Fighting();

			try {
				Thread.sleep(130);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 重新绘画图片
			repaint();
		}
	}
	//动态效果实现
	private void peopleRun() {
		awsIndex++;
		if (awsIndex >= awsImages.length) {
			awsIndex = 0;
		}
		mjIndex++;
		if (mjIndex >= mjImages.length) {
			mjIndex = 0;
		}
		wcsIndex++;
		if (wcsIndex >= wcsImages.length) {
			wcsIndex = 0;
		}
		xjIndex++;
		if (xjIndex >= xjImages.length) {
			xjIndex = 0;
		}
		xxjIndex++;
		if (xxjIndex >= xxjImages.length) {
			xxjIndex = 0;
		}
		azIndex++;
		if (azIndex >= azImages.length) {
			azIndex = 0;
		}
		xhIndex++;
		if (xhIndex >= xhImages.length) {
			xhIndex = 0;
		}
		jsBuffIndex++;
		if (jsBuffIndex >= jsBuffImages.length) {
			jsBuffIndex = 0;
		}
		TitleIndex++;
		if (TitleIndex >= TitleImages.length) {
			TitleIndex = 0;
		}
	}
	//打怪场景逻辑实现
	private void Fighting() {
		if (Red_yg<=0 || Red_lxy<=0) {
			if (Red_lxy<=0) {
				death_lxy=true;
			}
			if (Red_yg<=0) {
				death_yg=true;
			}
			
		}else {
			//怪物打
			if (isMe==false) {
				dg_gj_gwIndex++;
				if (dg_gj_gwIndex >= dg_gj_gwImages.length) {
					dg_gj_gwIndex = 0;
					Red_lxy=Red_lxy-Hurt_yg+DefensivePower_lxy;
					isMe=true;
				}
				dg_bgj_lxyIndex++;
				if (dg_bgj_lxyIndex >= dg_lxyBgjImages.length) {
					dg_bgj_lxyIndex = 0;
				}
			}
			//人物打
			if (isMe==true) {

					if (isDG_pg_lxy==true) {
						dg_gj_lxypgIndex++;
						if (dg_gj_lxypgIndex >= dg_lxygj_pgImages.length) {
							dg_gj_lxypgIndex = 0;
							isDG_pg_lxy=false;
						}
						dg_bgj_gwIndex++;
						if (dg_bgj_gwIndex >= dg_bgj_gwImages.length) {
							dg_bgj_gwIndex = 0;
						}
					}
					else if (isDG_zl_lxy==true) {
							dg_gj_lxyjnIndex++;
							if (dg_gj_lxyjnIndex >= dg_lxygj_jnImages.length) {
								dg_gj_lxyjnIndex = 0;
								isDG_zl_lxy=false;
							}
							dg_bgj_gwIndex++;
							if (dg_bgj_gwIndex >= dg_bgj_gwImages.length) {
								dg_bgj_gwIndex = 0;
							}
					}
					if (isZL==true) {
							dg_zlIndex++;
							isPG=false;
							if (dg_zlIndex >= dg_zlImages.length) {
								dg_zlIndex = 0;
								isZL=false;
								Blue_lxy-=BlueUse_lxy;
								Red_yg=Red_yg-BlueHurt_lxy+DefensivePower_yg;
								isMe=false;
							}
							dg_bgj_gwIndex++;
							if (dg_bgj_gwIndex >= dg_bgj_gwImages.length) {
								dg_bgj_gwIndex = 0;
							}
							canBlue=true;
						}
					}
					if (isPG==true) {
						dg_pgIndex++;
						isZL=false;
						if (dg_pgIndex >= dg_pgImages.length) {
							dg_pgIndex = 0;
							isPG=false;
							Red_yg=Red_yg-RedHurt_lxy+DefensivePower_yg;
							isMe=false;
						}
						dg_bgj_gwIndex++;
						if (dg_bgj_gwIndex >= dg_bgj_gwImages.length) {
							dg_bgj_gwIndex = 0;
						}
					}
				}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 上=38，下=40，左=37，右=39；w=87,s=83,a=65,d=68，空格=32；
		// 可以将e理解成事件源
		// 实现主角的运动效果
		// 根据玩家按下的键盘上按键情况，进行对应操作（移动或原地不动）

		// 存储按键值
		int KeyCode = e.getKeyCode();
		if (MapId==0) {
			if (KeyCode==KeyEvent.VK_Q) {
				if (isMe==true) {
					isPG=true;
					isDG_pg_lxy=true;
					
				}
			}
			if (KeyCode==KeyEvent.VK_W) {
				if (isMe==true) {
					isJN=true;
				}
			}
			if (KeyCode==KeyEvent.VK_E) {
				if (isMe==true) {
					if (Blue_lxy>BlueUse_lxy) {
						isZL=true;
						isDG_zl_lxy=true;
					}else {
						isZL=false;
						isDG_zl_lxy=false;
					}
				}
		}
			if (death_yg==true) {
				if (KeyCode==KeyEvent.VK_SPACE) {
					FishNum+=1;
					MapId=1;
					NowYellow_lxy+=60;
				}
			}
			if (death_lxy==true) {
				if (KeyCode==KeyEvent.VK_SPACE) {
					MapId=1;
				}
			}
		}
		else if (MapId==1) {
			if (KeyCode==KeyEvent.VK_L) {
				isShow_RenWu=!isShow_RenWu;
			}
			if (KeyCode==KeyEvent.VK_1) {
				if (Add_Red_Num>0) {
					Add_Red_Num-=1;
					Red_lxy+=Add_Red;
				}
			}
			if (KeyCode==KeyEvent.VK_2) {
				if (Add_Blue_Num>0) {
					Add_Blue_Num-=1;
					Blue_lxy+=Add_blue;
				}
			}
			if (IsLtShow == true) {
				if (KeyCode == KeyEvent.VK_SPACE) {
					ltIndex++;
					if (lxyNow==10) {
						//============返回到片头=====片头所有初始化===========
						//MapId=1;
					}
					if (lxyNow == 1) {
						if (faceman == "aws") {
							if (ltIndex >= lt_1_1awsMessages.length) {
								ltIndex = 0;
								lxyNow++;
								IsLtShow = false;
							}
						}
						if (faceman == "az") {
							IsLtShow = false;
						}
						if (faceman == "wcs") {
							IsLtShow = false;
						}
						if (faceman == "xh") {
							IsLtShow = false;
						}
					}
					if (lxyNow==2) {
						if (faceman=="aws") {
							if (ltIndex >=lt_1_0awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
							} 
						}
						if (faceman=="az") {
							IsLtShow = false;
						}
						if (faceman=="wcs") {
							if (ltIndex >= lt_1_wcsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								lxyNow++;
							} 
						}
						if (faceman=="xh") {
							IsLtShow = false;
						}
					}
					if (lxyNow==3) {
						if (faceman=="aws") {
							if (ltIndex >=lt_1_0awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
							} 
						}
						if (faceman=="az") {
							IsLtShow = false;
						}
						if (faceman=="wcs") {
							if (ltIndex >=lt_2_wcsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
							} 
						}
						if (faceman=="xh") {
							if (ltIndex >= lt_1_xhMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								lxyNow++;
							} 
						}
					}
					if (lxyNow==4) {
						if (faceman=="aws") {
							if (ltIndex >=lt_1_0awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
							} 
						}
						if (faceman=="az") {
							if (ltIndex >= lt_1_azMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								lxyNow++;
							} 
						}
						if (faceman=="wcs") {
							if (ltIndex >=lt_2_wcsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
							} 
						}
						if (faceman=="xh") {
							IsLtShow = false;
						}
					}
					if (lxyNow==5) {
						if (faceman=="aws") {
							if (ltIndex >=lt_1_0awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
							} 
						}
						if (faceman=="wcs") {
							if (ltIndex >= lt_3_wcsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								lxyNow++;
							} 
						}
						if (faceman=="az") {
							IsLtShow = false;
						}
					}
					if (lxyNow==6) {
						if (faceman=="aws") {
							if (ltIndex >= lt_2_1awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								lxyNow++;
							} 
						}
						if (faceman=="wcs") {
							IsLtShow = false;
						}
					}
					if (lxyNow==7) {
						if (faceman=="aws") {
							if (ltIndex >= lt_2_0awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								if (FishNum>=5) {
									lxyNow++;
								}
							} 
						}
						if (faceman=="wcs") {
							IsLtShow = false;
						}
					}
					if (lxyNow==8) {
						if (faceman=="aws") {
							if (ltIndex >= lt_3_1awsMessages.length) {
								ltIndex = 0;
								IsLtShow = false;
								lxyNow++;
							} 
						}
						if (faceman=="wcs") {
							IsLtShow = false;
						}
					}
				}
			}else {
				if (KeyCode == KeyEvent.VK_UP) {
					isUp = true;
					Dir1 = KeyCode;
				} else if (KeyCode == KeyEvent.VK_LEFT) {
					isLeft = true;
					Dir1 = KeyCode;
				} else if (KeyCode == KeyEvent.VK_RIGHT) {
					isRight = true;
					Dir1 = KeyCode;
				} else if (KeyCode == KeyEvent.VK_DOWN) {
					isDown = true;
					Dir1 = KeyCode;
				} else if (KeyCode == KeyEvent.VK_V) {
					isHighSpeed = !isHighSpeed;
				}
				if (KeyCode == KeyEvent.VK_SPACE) {
					if (MapId==1) {
						FaceMan_Sure();
					}
					if (MapId==0) {
						MapId++;
					}
					
				}
				if (KeyCode == KeyEvent.VK_T) {
					isTitle = !isTitle;
				}
				
				if (KeyCode==KeyEvent.VK_A) {
					MapId=0;
					Red_yg=100;
					Hurt_yg=20;
					DefensivePower_yg=10;
					death_yg=false;
				}
			}
		}	
		 


		// ===========================================================
		// 读取按键状态值，实现主角的运动状态
		Move_LiXiaoYao();
		// ================================================================
		// 设置李逍遥移动范围
		Range_LiXiaoYao();
		// 设置李家村图片移动范围
		ljcX = Range_X_BackGround(ljcX, ljcImage.getWidth(null));
		ljcY = Range_Y_BackGround(ljcY, ljcImage.getHeight(null));
		// 实现李家村移动
		ljcX = Move_X(ljcX, ljcImage.getWidth(null));
		ljcY = Move_Y(ljcY, ljcImage.getHeight(null));

	}
	//判断faceman+开启聊天
	private void FaceMan_Sure() {
		int x = lxyX;
		int y = lxyY;
		int awsx2 = awsX + ljcX + awsImages[awsIndex].getWidth(null);
		int awsy2 = awsY + ljcY + awsImages[awsIndex].getHeight(null);
		int awsx1 = awsx2 - 100;
		int awsy1 = awsy2 - 60;
		// --------------阿朱----------
		int azx2 = azX + ljcX + azImages[azIndex].getWidth(null);
		int azy2 = azY + ljcY + azImages[azIndex].getHeight(null)-20;
		int azx1 = azx2 + 68;
		int azy1 = azy2 - 100;
		// -------------旺财嫂-------------
		int wcsx2 = wcsX + ljcX + wcsImages[wcsIndex].getWidth(null)+30;
		int wcsy2 = wcsY + ljcY + wcsImages[wcsIndex].getHeight(null)-50;
		int wcsx1 = wcsx2 - 68;
		int wcsy1 = wcsy2 - 50;
		//---------------小孩-----------------
		int xhx2 = xhX + ljcX + xhImages[xhIndex].getWidth(null);
		int xhy2 = xhY + ljcY + xhImages[xhIndex].getHeight(null);
		int xhx1 = xhx2 - 100;
		int xhy1 = xhy2 - 60;
		// =======================
//				System.out.println(Dir1);
//				System.out.println(
//						"x " + x + " x1 " + xhx1 + " x2 " + xhx2 + " y " + lxyY + " y1 " + xhy1 + " y2 " + xhy2);
//				System.out.println(IsLtShow);
//				System.out.println(Dir1);
		if (Dir1 == KeyEvent.VK_UP && x > awsx1 && awsy1 < y && x < awsx2 && y < awsy2) {
			IsLtShow = true;
			faceman = "aws";
		}
		if (Dir1 == KeyEvent.VK_LEFT && x > azx2 && azy1 < y && x < azx1 && y < azy2 && lxyNow<=5) {
			IsLtShow = true;
			faceman = "az";
		}
		if (Dir1 == KeyEvent.VK_LEFT && x > wcsx1 && wcsy1 < y && x < wcsx2 && y < wcsy2) {
			IsLtShow = true;
			faceman = "wcs";
		}
		if (Dir1 == KeyEvent.VK_UP && x > xhx1 && xhy1 < y && x < xhx2 && y < xhy2 && lxyNow<=4) {
			IsLtShow = true;
			faceman = "xh";
		}
	}

	// 实现背景地图移动
	private int Move_X(int X1, int X_BackGround) {
		if (lxyX <= 300 && X1 < 0) {
			if (isHighSpeed == false) {
				X1 += Speed;
				lxyX += Speed;
			} else {
				X1 += HighSpeed;
				lxyX += HighSpeed;
			}
		}
		if (lxyX >= 600 && X1 > 1024 - X_BackGround) {
			if (isHighSpeed == false) {
				lxyX -= Speed;
				X1 -= Speed;
			} else {
				lxyX -= HighSpeed;
				X1 -= HighSpeed;
			}
		}
		return X1;
	}

	private int Move_Y(int Y, int Y_BackGround) {
		if (lxyY <= 300 && Y < 0) {
			if (isHighSpeed == false) {
				lxyY += Speed;
				Y += Speed;
			} else {
				lxyY += HighSpeed;
				Y += HighSpeed;
			}
		}
		if (lxyY >= 500 && Y > 768 - Y_BackGround) {
			if (isHighSpeed == false) {
				lxyY -= Speed;
				Y -= Speed;
			} else {
				lxyY -= HighSpeed;
				Y -= HighSpeed;
			}
		}
		return Y;

	}

	// 设置李家村图片移动范围
	private int Range_X_BackGround(int X1, int X_BackGround) {
		if (X1 >= 0) {
			X1 = 0;
		}

		if (X1 <= 1024 - X_BackGround) {
			X1 = 1024 - X_BackGround;
		}
		return X1;

	}

	private int Range_Y_BackGround(int Y1, int Y_BackGround) {
		if (Y1 >= 0) {
			Y1 = 0;
		}
		if (Y1 <= 768 - Y_BackGround) {
			Y1 = 768 - Y_BackGround;
		}
		return Y1;
	}

	// 设置李逍遥移动范围
	private void Range_LiXiaoYao() {
		if (lxyX <= 0) {
			lxyX = 0;
		}
		if (lxyX >= 960) {
			lxyX = 960;
		}
		if (lxyY <= 0) {
			lxyY = 0;
		}
		if (lxyY >= 630) {
			lxyY = 630;
		}
	}

	// 李逍遥的移动方法+障碍物检测
	private void Move_LiXiaoYao() {
		if (IsLtShow == false) {
			if (isDown == true) {
				if (isHighSpeed == false) {
					lxyY += Speed;
					// 检测障碍物
					int x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
					int y = lxyY - ljcY + lxyImage.getHeight(null);
					if (ljcDateImage.getRGB(x, y) == -521461) {
						lxyY -= Speed;
					}
				} else {
					lxyY += HighSpeed;
					// 检测障碍物
					int x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
					int y = lxyY - ljcY + lxyImage.getHeight(null);
					if (ljcDateImage.getRGB(x, y) == -521461) {
						lxyY -= HighSpeed;
					}
				}
				repaint();
				lxyIndex++;
				if (lxyIndex >= down_lxyImages.length) {
					lxyIndex = 0;
				}
				// ----------
				if (isLeft == false && isRight == false) {
					lxyImage = down_lxyImages[lxyIndex];
				} else if (isLeft == true) {
					lxyImage = Down_Left_lxyImages[lxyIndex];
					if (isHighSpeed == false) {
						lxyX -= Speed;
						// 检测障碍物
						x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
						y = lxyY - ljcY + lxyImage.getHeight(null);
						if (ljcDateImage.getRGB(x, y) == -521461) {
							lxyX += Speed;
						}
					} else {
						lxyX -= HighSpeed;
						// 检测障碍物
						x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
						y = lxyY - ljcY + lxyImage.getHeight(null);
						if (ljcDateImage.getRGB(x, y) == -521461) {
							lxyX += HighSpeed;
						}
					}
				} else if (isRight == true) {
					lxyImage = Down_Right_lxyImages[lxyIndex];
					if (isHighSpeed == false) {
						lxyX += Speed;
						// 检测障碍物
						x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
						y = lxyY - ljcY + lxyImage.getHeight(null);
						if (ljcDateImage.getRGB(x, y) == -521461) {
							lxyX -= Speed;
						}
					} else {
						lxyX += HighSpeed;
						// 检测障碍物
						x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
						y = lxyY - ljcY + lxyImage.getHeight(null);
						if (ljcDateImage.getRGB(x, y) == -521461) {
							lxyX -= HighSpeed;
						}
					}
				}
				// ================================
			} else {
				if (isLeft == true) {
					if (isHighSpeed == false) {
						lxyX -= Speed;
						// 检测障碍物
						x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
						y = lxyY - ljcY + lxyImage.getHeight(null);
						if (ljcDateImage.getRGB(x, y) == -521461) {
							lxyX += Speed;
						}
					} else {
						lxyX -= HighSpeed;
						// 检测障碍物
						x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
						y = lxyY - ljcY + lxyImage.getHeight(null);
						if (ljcDateImage.getRGB(x, y) == -521461) {
							lxyX += HighSpeed;
						}
					}
					repaint();
					lxyIndex++;
					if (lxyIndex >= left_lxyImages.length) {
						lxyIndex = 0;
					}
					// ------------
					if (isUp == false) {
						lxyImage = left_lxyImages[lxyIndex];
					} else if (isUp == true) {
						lxyImage = Up_Left_lxyImages[lxyIndex];
						if (isHighSpeed == false) {
							lxyY -= Speed;
							// 检测障碍物
							x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
							y = lxyY - ljcY + lxyImage.getHeight(null);
							if (ljcDateImage.getRGB(x, y) == -521461) {
								lxyY += Speed;
							}
						} else {
							lxyY -= HighSpeed;
							// 检测障碍物
							x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
							y = lxyY - ljcY + lxyImage.getHeight(null);
							if (ljcDateImage.getRGB(x, y) == -521461) {
								lxyY += HighSpeed;
							}
						}
					}
					// ================================
				} else {
					if (isRight == true) {
						if (isHighSpeed == false) {
							lxyX += Speed;
							// 检测障碍物
							x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
							y = lxyY - ljcY + lxyImage.getHeight(null);
							if (ljcDateImage.getRGB(x, y) == -521461) {
								lxyX -= Speed;
							}
						} else {
							lxyX += HighSpeed;
							// 检测障碍物
							x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
							y = lxyY - ljcY + lxyImage.getHeight(null);
							if (ljcDateImage.getRGB(x, y) == -521461) {
								lxyX -= HighSpeed;
							}
						}
						repaint();
						lxyIndex++;
						if (lxyIndex >= right_lxyImages.length) {
							lxyIndex = 0;
						}
						if (isUp == false) {
							lxyImage = right_lxyImages[lxyIndex];
						} else if (isUp == true) {
							lxyImage = Up_Right_lxyImages[lxyIndex];
							if (isHighSpeed == false) {
								lxyY -= Speed;
								// 检测障碍物
								x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
								y = lxyY - ljcY + lxyImage.getHeight(null);
								if (ljcDateImage.getRGB(x, y) == -521461) {
									lxyY += Speed;
								}
							} else {
								lxyY -= HighSpeed;
								// 检测障碍物
								x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
								y = lxyY - ljcY + lxyImage.getHeight(null);
								if (ljcDateImage.getRGB(x, y) == -521461) {
									lxyY += HighSpeed;
								}
							}
						}
						// ===============================
					} else {
						if (isUp == true) {
							if (isHighSpeed == false) {
								lxyY -= Speed;
								// 检测障碍物
								x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
								y = lxyY - ljcY + lxyImage.getHeight(null);
								if (ljcDateImage.getRGB(x, y) == -521461) {
									lxyY += Speed;
								}
							} else {
								lxyY -= HighSpeed;
								// 检测障碍物
								x = lxyX - ljcX + lxyImage.getWidth(null) / 2;
								y = lxyY - ljcY + lxyImage.getHeight(null);
								if (ljcDateImage.getRGB(x, y) == -521461) {
									lxyY += HighSpeed;
								}
							}
							repaint();
							lxyIndex++;
							if (lxyIndex >= up_lxyImages.length) {
								lxyIndex = 0;
							}
							lxyImage = up_lxyImages[lxyIndex];
						}
					}
				}
			}
		}
	}

	// 按键松开的方法
	@Override
	public void keyReleased(KeyEvent e) {
		// DirSure();
		// 键盘按键被松开
		int KeyCode = e.getKeyCode();
		if (KeyCode == KeyEvent.VK_UP) {
			isUp = false;
		}
		if (KeyCode == KeyEvent.VK_DOWN) {
			isDown = false;
		}
		if (KeyCode == KeyEvent.VK_LEFT) {
			isLeft = false;
		}
		if (KeyCode == KeyEvent.VK_RIGHT) {
			isRight = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
