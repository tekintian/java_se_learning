package com.test3;
import java.io.*;
import java.util.Vector;

class Node
{
	int x;
	int y;
	int direct;
	public Node(int x, int y, int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	
}
//记录类，同事可以保存玩家的设置
class Recorder
{
	//记录每关有多少敌人
	private static int enNum=7;
	//设置我有多少可以用人
	private static int myLife=3;
	//记录总共消灭了多少敌人的坦克
	private static int allEnEum=0;
	//从文件恢复记录点
	static Vector<Node> nodes=new Vector<Node>();
	
	//创建文件流，记录退出的信息导入到文件
	private static  FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	private static Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	
	//完成读取
	public Vector<Node> getNodesAndEnNums()
	{
		try {
			fr=new FileReader("d:\\myRecording.txt");
			br=new BufferedReader(fr);
			
			String n="";
			//读取第一行
			n=br.readLine();
			allEnEum=Integer.parseInt(n);
			while ((n=br.readLine())!=null)
			{
				String []xyz=n.split(" ");   //以空格分隔字符串，得到字符串数组
				for(int i=0; i<xyz.length; i++)
				{
					Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
					nodes.add(node);
				}
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return nodes;
	}
	
	
	//保存机会敌人的数量和敌人坦克坐标,方向
	public  void keeprRecAndEnemyTank()
	{
		try {
			//创建
			fw=new FileWriter("d:\\myRecording.txt");
			bw=new BufferedWriter(fw);
			bw.write(allEnEum+"\r\n");
			//保存当前还活着的敌人的坦克的坐标和方向
			for(int i=0; i<ets.size(); i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				if(et.isLive)
				{
					//活的就保存
					String recode=et.x+" "+et.y+" "+et.direct;
					//写入到文件中
					bw.write(recode+"\r\n");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				//关闭流,先开的后关闭
				bw.close();
				fw.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	//从文件中读取，记录
	public static void getRecoring()
	{
		try {
			fr=new FileReader("d:\\myRecording.txt");
			br=new BufferedReader(fr);
			String n=br.readLine();
			allEnEum=Integer.parseInt(n);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	//把玩击毁敌人坦克数量保存到文件中
	public static void keepRecording()
	{
		try {
			//创建
			fw=new FileWriter("d:\\myRecording.txt");
			bw=new BufferedWriter(fw);
			bw.write(allEnEum+"\r\n");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				//关闭流,先开的后关闭
				bw.close();
				fw.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	//减少敌人生命的的数量
	public static void reduceEnNum()
	{
		enNum--;
	}
	//减少我的生命数量
	public static void reduceMyNum()
	{
		myLife--;
	}
	//当消灭敌人的时候
	public static void addEnNumRec()
	{
		allEnEum++;
	}
	public static int getAllEnEum() {
		return allEnEum;
	}
	public static void setAllEnEum(int allEnEum) {
		Recorder.allEnEum = allEnEum;
	}

	public   Vector<EnemyTank> getEts() {
		return ets;
	}

	public  void setEts(Vector<EnemyTank> ets) {
		this.ets = ets;
	}
}

//炸弹类
class Bomb
{
	//定义砸蛋的坐标
	int x, y;
	//炸弹的生命
	int life=9;
	boolean isLive=true;
	
	public Bomb(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	//减少生命值
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}
		else
		{
			this.isLive=false;
		}
	}
	
}

//子弹类
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=1;
	//是否还活着
	boolean isLive=true;
	public Shot(int x, int y, int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			switch(direct)
			{
			case 0:
				//子弹向上
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
		//	System.out.println("子弹的坐标x="+x+"子弹的y坐标y="+y);
			//子弹何时死亡
			
			//判断该子弹是否碰到边缘
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
			
		}
		
	}
}

//定义一个坦克类
class Tank
{
	//b表示坦克的横坐标x 和纵坐标y
	int x=0;
	int y=0;
	// 定义方向  0表示向上 1表示右， 2表示下 3表示左
	int direct=0;
	//坦克颜色
	int color=0;
	//坦克速度
	
	boolean isLive=true;
	int speed=5;
	public Tank(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
}
//敌人的坦克,做成线程类
class EnemyTank extends Tank implements Runnable
{
	
	int times=0;
	
	//定义一个容器，可以访问到MyPanel 上所有的坦克
	
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	
	//定义一个容器，可以存放敌人的子弹
	Vector<Shot> ss=new Vector<Shot>();
	//敌人添加子弹，应当在刚刚创建坦克和敌人的子弹死亡以后去除子弹
	public EnemyTank(int x, int y)
	{
		super(x, y);
	}
	
	//得到MyPanel 的敌人的坦克容器
	public void setEts(Vector<EnemyTank> vv)
	{
		this.ets=vv;
	}
	
	//判断是否碰到了别的敌人的坦克
	public boolean isTouchOtherEnemy()
	{
		boolean b=false;
		
		switch(this.direct)
		{
		case 0:
			//我的坦克向上
			//取出所有的敌人的坦克
			for(int i=0; i<ets.size(); i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向上或者向下
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//我的坦克向右
			//取出所有的敌人的坦克
			for(int i=0; i<ets.size(); i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向上或者向下
					if(et.direct==0||et.direct==2)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//我的坦克向下
			//取出所有的敌人的坦克
			for(int i=0; i<ets.size(); i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向上或者向下
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=y&&this.y+30<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=y&&this.y+30<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//我的坦克向左
			//取出所有的敌人的坦克
			for(int i=0; i<ets.size(); i++)
			{
				//取出第一个坦克
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this)
				{
					//如果敌人的方向是向上或者向下
					if(et.direct==0||et.direct==2)
					{
						//我的上一点
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=y&&this.y<=et.y+30)
						{
							return true;
						}
						//我的下一点
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		}
		return b;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
			switch(this.direct)
			{
			case 0:
				//说明坦克正在向上移动
				for(int i=0; i<30; i++)
				{
					if(y>0&&!this.isTouchOtherEnemy())
					{
						y-=speed;
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 1:
				for(int i=0; i<30; i++)
				{
					if(x<400&&!this.isTouchOtherEnemy())
					{
						x+=speed;
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 2:
				for(int i=0; i<30; i++)
				{
					if(y<300&&!this.isTouchOtherEnemy())
					{
						y+=speed;
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 3:
				for(int i=0; i<30; i++)
				{
					if(x>0&&!this.isTouchOtherEnemy())
					{
						x-=speed;
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			}
			this.times++;
			//判断是否需要给坦克加入新的子弹
			if(times%2==0)
			{
					if(isLive)
					{
						if(ss.size()<5)
						{
					//		System.out.println("et.ss.size()"+et.ss.size());
							//没有子弹
							 Shot s=null;
							 //添加子弹
							switch(direct)
							{
								case 0:
									s=new Shot(x+10,y ,0);
									ss.add(s);
									break;
								case 1:
									s=new Shot(x+30,y+10, 1);
									ss.add(s);
									break;
								case 2:
									s=new Shot(x+10,y+30, 2);
									ss.add(s);
									break;
								case 3:
									s=new Shot(x, y+10, 3);
									ss.add(s);
									break;
							}
							// 启动子弹
							Thread t=new Thread(s);
							t.start();
						}	
						
					}
			}	
			
			
			//让坦克随机产生一个新的方向
			this.direct=(int)(Math.random()*4);
			
			//判断敌人的坦克是否死亡
			
			if(this.isLive==false)
			{
				//让坦克死亡后推出线程
				break;
			}
			
		}
	}
	
}
//我的坦克
class Hero extends Tank
{
	 Shot s=null;
	//定义子弹容器
	 Vector<Shot> ss=new Vector<Shot>();
	public Hero(int x, int y)
	{
		super(x,y);
	}
	public void shotEnemy()
	{
		
		switch(this.direct)
		{
		case 0:
			s=new Shot(x+10,y ,0);
			ss.add(s);
			break;
		case 1:
			s=new Shot(x+30,y+10, 1);
			ss.add(s);
			break;
		case 2:
			s=new Shot(x+10,y+30, 2);
			ss.add(s);
			break;
		case 3:
			s=new Shot(x,y+10, 3);
			ss.add(s);
			break;
		}
		//创建线程并启动
		Thread t=new Thread(s);
		t.start();
	}
	//坦克向上移动
	public void moveUp()
	{
		y-=speed;
	}
	//坦克向右移动
	public void moveRight()
	{
		x+=speed;
	}
	//向下移动
	public void moveDown()
	{
		y+=speed;
	}
	//向左边移动
	public void moveLeft()
	{
		x-=speed;
	}
}
