/**遇到的问题：如果坦克不自动走的话，可能是内层的循环的get(j) 写成 get(i) 了
 * 
 * 
 * 功能：坦克游戏的3.0版本
 * 1：画出坦克
 * 2:实现坦克上下左右移动
 * 3:实现坦克发第一颗子弹.
 * 4：如果果想让子弹实现连续发射，则只需把 按下J 键的时候去掉一个条件就可以了
 * 5:实现子弹打到敌人坦克坦克会消失(并产生爆炸的效果)
 * 6;实现敌人坦克发子弹并连发,防止敌人坦克重叠运动
 *   6.1：决定把判断是否碰撞的函数写道EnemyTank
 * 7:分关：
 *  7.1；做一个空的Panel 主要用于提示
 *  7.2 字体闪烁
 *  8.可以在玩游戏的时候暂停核继续*
 *   	8.1用户点击暂停的时候，子弹速度设为0，并让坦克方向不改变*
 *  9：记录玩家的成绩
 *  	9.1用文件流的方式
 *  	9.2单一写一个记录类,完成玩家记录
 *  	9.3先完成保存一共击毁敌人多少辆坦克的功能
 *  	9.5存盘退出游戏，可以记录当时的地敌人，并可以恢复
 */
package com.test3;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class MyTankGame4 extends JFrame implements ActionListener{

	MyPanel mp=null;
	//定义一个开始面板
	MyStartPanel msp=null;
	//做出我需要的菜单
	JMenuBar jmb=null;
	//开始游戏
	JMenu jm1=null;
	JMenuItem jmi1=null;
	//退出系统
	JMenuItem jmi2=null;
	//存盘退出
	JMenuItem jmi3=null;
	//去上局
	JMenuItem jmi4=null;
	public static void main(String[] args) {
		
		MyTankGame4 mtg=new MyTankGame4();
	}
	//构造函数
	public MyTankGame4()
	{
//		mp=new MyPanel();
//		//启东mp线程
//		Thread t=new Thread(mp);
//		t.start();
//		this.add(mp);
//		//注册监听
//		this.addKeyListener(mp);
		
		//创建菜单以及菜单选项
		jmb=new JMenuBar ();
		jm1=new JMenu("游戏(G))");
		//设置快捷方式
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始新游戏(N)");
		jmi2=new JMenuItem("退出游戏(E)");
		jmi3=new JMenuItem("存盘退出游戏(C)");
		jmi4=new JMenuItem("继续上局游戏(S)");
		
		//注册监听
		jmi4.addActionListener(this);
		jmi4.setActionCommand("conGame");
		//注册监听 
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveExit");
		
		//对jmi1进行相应 开始游戏
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		
		
		//设置快捷方式
		jm1.setMnemonic('E');
		
		//对jmi1进行相应 开始游戏
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		
		//加入到下拉菜单
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		
		//下拉菜单加入到菜单条
		jmb.add(jm1);
		
		
		msp=new MyStartPanel();
		Thread t=new Thread(msp);
		t.start();
		
		//加入菜单条
		this.setJMenuBar(jmb);
		this.add(msp);
		this.setSize(600,500);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("newgame"))
		{
			//创建战场的面板
			mp=new MyPanel("newGame");
			//启东mp线程
			Thread t=new Thread(mp);
			t.start();
			//删掉旧的面板msp
			this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示刷新JFrame
			this.setVisible(true);
		}else if(arg0.getActionCommand().equals("exit"))
		{
			//用户点击了退出系统的菜单
			//保存击毁敌人坦克数量
			Recorder.keepRecording();
			System.exit(0);
		}
		else if(arg0.getActionCommand().equals("saveExit"))
		{
			//存盘退出
			//保存机会敌人的数量和敌人的坐标
		//	System.out.println(222);
			Recorder rd=new Recorder();
			rd.setEts(mp.ets);
			rd.keeprRecAndEnemyTank();
			//退出
			System.exit(0);
		}else if(arg0.getActionCommand().equals("conGame"))
		{
			//去上局
			//创建战场的面板
			mp=new MyPanel("con");
			
			//启东mp线程
			Thread t=new Thread(mp);
			t.start();
			//删掉旧的面板msp
			this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示刷新JFrame
			this.setVisible(true);
		}
	}
}

//提示的面板 
class MyStartPanel extends JPanel implements Runnable
{
	int times=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		//提示信息
		if(times%2==0)
		{
			 // 设置字体颜色
			g.setColor(Color.yellow);
			//设置字体
			Font myFont=new Font("华文新魏",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("stage: 1", 150, 150);
		}
		
	}

	public void run() {
		
		while(true)
		{
			//休眠
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			times++;
			//重画
			this.repaint();
			 
		}
	}
}
//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的坦克
	Hero hero=null;
	
	//判断是去上局，还是新游戏
	
	//定义敌人的坦克
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	//恢复容器
	Vector<Node> nodes=new Vector<Node>();
	
	//定义炸弹的集合 
	Vector<Bomb> bombs=new Vector<Bomb>();
	int enSize=7;
	
	//定义三张爆炸需要的图片
	Image image1=null;
	Image image2=null;
	Image image3=null;
	//构造函数
	public MyPanel(String flag)
	{	
		//恢复记录
		Recorder.getRecoring();
		
		
		//我的坦克
		hero=new Hero(150,150);
		
		if(flag.equals("newGame"))
		{
		
			//初始化敌人的坦克
			for(int i=0; i<enSize; i++)
			{	
				
				
				// 创建一个敌人坦克
				EnemyTank  et=new EnemyTank((i+1)*50,0);
				et.setColor(0);
				et.setDirect(2);
				
				//将MyPanel的敌人的坦克容器交给该敌人的坦克
				//启东敌人的坦克
				et.setEts(ets);
				
				Thread t=new Thread(et);
				t.start();
				//给敌人坦克添加一颗子弹
				Shot s=new Shot(et.x+10, et.y+30, 2);
				//加入到敌人子弹的向量里面
				et.ss.add(s);
				//启东线程
				Thread t2=new Thread(s);
				t2.start();
				//加入到面板中
				ets.add(et);
			}
		}else{
			
		//	System.out.println("接着玩");
			nodes=new Recorder().getNodesAndEnNums();
			//初始化敌人的坦克
			for(int i=0; i<nodes.size(); i++)
			{	
				Node node=nodes.get(i);
				// 创建一个敌人坦克
				EnemyTank  et=new EnemyTank(node.x,node.y);
				et.setColor(0);
				et.setDirect(node.direct);
				
				//将MyPanel的敌人的坦克容器交给该敌人的坦克
				//启东敌人的坦克
				et.setEts(ets);
				
				Thread t=new Thread(et);
				t.start();
				//给敌人坦克添加一颗子弹
				Shot s=new Shot(et.x+10, et.y+30, 2);
				//加入到敌人子弹的向量里面
				et.ss.add(s);
				//启东线程
				Thread t2=new Thread(s);
				t2.start();
				//加入到面板中
				ets.add(et);
			}
		}
		//初始化图片. 注意图片的位置的写法图片必须在src 下  Class11下面
		try {
			image1=ImageIO.read(new File("bomb_1.gif"));
			image2=ImageIO.read(new File("bomb_2.gif"));
			image3=ImageIO.read(new File("bomb_3.gif"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 //初始化图片,这个方法第一颗子弹爆炸效果不明显 图片必须在 src 下面
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	}
	
	//绘制提示信息
	public void showInfo(Graphics g)
	{
		//画出提示信息敌人的坦克
		this.drawTank(80,330, g, 0, 0);
		//设置字体的颜色
		g.setColor(Color.red);
		g.drawString(Recorder.getEnNum()+"",110, 350);
		
		//画出提示信息我的坦克记录信息
		this.drawTank(130,330, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMyLife()+"",160, 350);
		
		//画出玩家的总成绩提示信息
		g.setColor(Color.black);
		//设置字体的大小
		Font f=new Font("宋体",Font.BOLD,20);
		g.setFont(f);
		g.drawString("您的总成绩",420 , 30);
		//画出玩家的总共摧毁敌人多少坦克的记录
		this.drawTank(420,60, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnEum()+"",460,80);
	}
	
	
	//重写paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//设置图像的背景色
		g.fillRect(0, 0, 400, 300);
		
			
		//画出提示信息
		this.showInfo(g);
		
		//画出自己的坦克
		if(hero.isLive==true)
		{
			this.drawTank(hero.getX(),hero.getY(), g, hero.direct, 1);
		}
		//ss中取出每一颗子弹并画出
		for(int i=0; i<hero.ss.size(); i++)
		{
			Shot myShot=hero.ss.get(i);
			//画子弹
			if(myShot!=null&&myShot.isLive==true)
			{
				g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
			}
			//删除符合条件的子弹
			if(myShot.isLive==false)
			{
				//从ss中删掉该子弹
				hero.ss.remove(myShot);
			}
		}
		
		
		//画出炸弹
		for (int i=0; i<bombs.size(); i++)
		{
			System.out.println("bombs.size()="+bombs.size());
			//取出炸弹
			Bomb b=bombs.get(i);
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30, 30, this);  // this表示就在当前面板上绘制
			}
			else if(b.life>4)
			{
				g.drawImage(image2, b.x, b.y, 30, 30, this);  // this表示就在当前面板上绘制
			}
			else
			{
				g.drawImage(image3, b.x, b.y, 30, 30, this);  // this表示就在当前面板上绘制
			}
			//减小b的生命值
			b.lifeDown();
			//如果炸弹的生命值为0，就把炸弹bombs去掉
			 if(b.life==0)
			 {
				 bombs.remove(b);
			 }
		}
		
		//画出敌人的坦克
		for(int i=0; i<ets.size(); i++)
		{
			EnemyTank et=ets.get(i);
			if(et.isLive)
			{
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 0);
				//画出敌人的子弹
				for(int j=0; j<et.ss.size(); j++)
				{
					//取出子弹
					Shot enemyShot=et.ss.get(j);
					if(enemyShot.isLive)
					{
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
					}else
					{
						//如果敌人的坦克死亡就从Vector中移除子弹
						et.ss.remove(enemyShot);
					}
				}
			}
		}
		
	}
	
	
	//敌人的坦克是否击中我
	public void hitMe()
	{
		//取出每一个敌人的坦克
		for(int i=0; i<this.ets.size(); i++)
		{
			//取出坦克
			EnemyTank et=ets.get(i);
			
			//取出每一颗子弹
			for(int j=0; j<et.ss.size(); j++)
			{
				//取出子弹
				Shot enemyShot=et.ss.get(j);
				//如果我的坦克还有生命
				if(hero.isLive)
				{
					//判断敌人的子弹是否击中我的坦克,击中之后我的她坦克的生命自动设置为false
					if(this.hitTank(enemyShot, hero))
					{
						//判断我的坦克生命是否大于零大于等于2 ，  我的坦克是三次生命 分别是  myLife 的值是 true 3， 2 ture,  true 1 ,false， 
						//所以够我坦克的生命就延续了三次   
						if(Recorder.getMyLife()>=2)
						{
							//生命重新设为真
							hero.isLive=true;
						}
						else
						{
							hero.isLive=false;
						}
						//如果打中我的坦克，我的坦克生命就减小一个
						Recorder.reduceMyNum();
					}
				}
				
			}
		}
		
	}
	
	//判断我的子弹是否击中敌人的坦克
	public void hitEnemyTank()
	{
		//判断是否击中敌人的坦克
		for(int i=0; i<hero.ss.size(); i++)
		{
			//取出子弹
			Shot myShot=hero.ss.get(i);
			//判断子弹是否有效
			if(myShot.isLive)
			{
				//取出坦克，与它判断
				for(int j=0; j<ets.size(); j++)
				{
					//取出坦克
					EnemyTank et=ets.get(j);	
					if(et.isLive)
					{
						if(this.hitTank(myShot, et))
						{
							Recorder.reduceEnNum();
							Recorder.addEnNumRec();
						}
					}
				}
			}
		}
	}
	
	
	//写一个函数专门判断子弹对否击中坦克
	public boolean hitTank(Shot s, Tank t)
	{
		//判断该坦克的方向
		boolean isShotTank=false;
		switch(t.direct)
		{
		//如果敌人的坦克的方向是向上或者向下
		case 0:
		case 2:
			if(s.x>t.x&&s.x<t.x+20&&s.y>t.y&&s.y<t.y+30)
			{
				//击中
				//子弹死亡
				s.isLive=false;
				
				//坦克死亡
				t.isLive=false;
				
				//敌人数量减少一个
			//	Recorder.reduceEnNum();
				//创建一颗炸弹，放入到Vcetor
				Bomb b=new Bomb(t.x, t.y);
				//放入到Vector
				bombs.add(b);
				isShotTank=true;
			};
			break;
		case 1:
		case 3:
			if(s.x>t.x&&s.x<t.x+30&&s.y>t.y&&s.y<t.y+20)
			{
				//击中
				//子弹死亡
				s.isLive=false;
				//敌人数量减少一个
			//	Recorder.reduceEnNum();
				//敌人坦克死亡
				t.isLive=false;
				//创建一颗炸弹，放入到Vcetor
				Bomb b=new Bomb(t.x, t.y);
				//放入到Vector
				bombs.add(b);
				isShotTank=true;
			};
			break;
		}
		return isShotTank;
	}
	//绘制坦克的函数
	public void drawTank(int x, int y, Graphics g, int direct, int type)
	{
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		// 判断方向
		switch(direct)
		{
		case 0:   // 向上
			
			//画出我的坦克（到时候会封装成一个函数）
			//1：画出左面的矩形
			//设置画笔的颜色，绘制矩形
			//1：绘制左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2：绘制右边的矩形
			g.fill3DRect(x+15,y, 5, 30,false);
			//3:绘制中间矩形
			g.fill3DRect(x+5, y+5,10, 20,false);
			//4:画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5:绘制炮筒
			g.drawLine(x+10, y+15, x+10, y);	
			break;
		case 1:    //  向右
			g.fill3DRect(x, y, 30, 5, false);
			//
			g.fill3DRect(x, y+15, 30, 5, false);
			//
			g.fill3DRect(x+5, y+5, 20, 10, false);
			//
			g.fillOval(x+10, y+5, 10, 10);
			//
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2: // 向下
			//画出我的坦克（到时候会封装成一个函数）
			//1：画出左面的矩形
			//设置画笔的颜色，绘制矩形
			//1：绘制左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2：绘制右边的矩形
			g.fill3DRect(x+15,y, 5, 30,false);
			//3:绘制中间矩形
			g.fill3DRect(x+5, y+5,10, 20,false);
			//4:画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5:绘制炮筒
			g.drawLine(x+10, y+15, x+10, y+30);	
			break;
		case 3:  //向左
			g.fill3DRect(x, y, 30, 5, false);
			//
			g.fill3DRect(x, y+15, 30, 5, false);
			//
			g.fill3DRect(x+5, y+5, 20, 10, false);
			//
			g.fillOval(x+10, y+5, 10, 10);
			//
			g.drawLine(x+15, y+10, x-3, y+10);
			break;
			
		}
		
		
	}
	//键按下处理 a s w d
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			//向上 前进
			this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//向右前进
			this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//向下前进
			this.hero.setDirect(2);
			this.hero.moveDown();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//向左前进
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		//判断玩家是否按下J键
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			//如果我的坦克还活着
			if(hero.isLive)
			{
				if(this.hero.ss.size()<=20)
				{
					this.hero.shotEnemy();
				}
			}
		}
		//重新绘制窗口
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		//每隔100毫秒重新绘制子弹
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//判断我的子弹是否击中敌人
			this.hitEnemyTank();
			//函数，判断敌人的子弹是否击中我
			this.hitMe();
		
			//重新绘制panel
			this.repaint();
		}
		
	}
	
}
	

