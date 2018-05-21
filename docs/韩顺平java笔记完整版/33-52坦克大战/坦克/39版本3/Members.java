package com.test4;

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
			System.out.println("子弹的坐标x="+x+"子弹的y坐标y="+y);
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
	int speed=20;
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
//敌人的坦克
class EnemyTank extends Tank
{
	public EnemyTank(int x, int y)
	{
		super(x, y);
	}
	
}
//我的坦克
class Hero extends Tank
{
	Shot s=null;
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
			break;
		case 1:
			s=new Shot(x+30,y+10, 1);
			break;
		case 2:
			s=new Shot(x+10,y+30, 2);
			break;
		case 3:
			s=new Shot(x,y+10, 3);
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
