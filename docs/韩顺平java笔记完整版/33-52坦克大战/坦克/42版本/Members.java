package com.test3;

import java.util.Vector;

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
}
//敌人的坦克,做成线程类
class EnemyTank extends Tank implements Runnable
{
	boolean isLive=true;
	int times=0;
	//定义一个容器，可以存放敌人的子弹
	Vector<Shot> ss=new Vector<Shot>();
	//敌人添加子弹，应当在刚刚创建坦克和敌人的子弹死亡以后去除子弹
	public EnemyTank(int x, int y)
	{
		super(x, y);
	}
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			switch(this.direct)
			{
			case 0:
				//说明坦克正在向上移动
				for(int i=0; i<30; i++)
				{
					if(y>0)
					{
						y-=speed;
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 1:
				for(int i=0; i<30; i++)
				{
					if(x<400)
					{
						x+=speed;
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 2:
				for(int i=0; i<30; i++)
				{
					if(y<300)
					{
						y+=speed;
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 3:
				for(int i=0; i<30; i++)
				{
					if(x>0)
					{
						x-=speed;
						try {
							Thread.sleep(50);
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
