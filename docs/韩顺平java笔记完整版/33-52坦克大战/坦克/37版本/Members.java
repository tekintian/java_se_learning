package com.test6;

//子弹类
class Shot 
{
	int x ;
	int y;
	public Shot(int x, int y)
	{
		this.x=x;
		this.y=y;
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
	//子弹
	Shot s=null;
	public Hero(int x, int y)
	{
		super(x,y);
		
	}
	
	public void moveEnemy()
	{
		switch(this.direct)
		{
		case 0:
			s=new Shot(x+10, y);
			break;
		case 1:
			s=new Shot(x+30,y+10);
			break;
		case 2:
			s=new Shot(x+10, y+30);
			break;
		case 3:
			s=new Shot(x+30, y+10);
			break;
		}
	}
	//坦克向上移动
	public void moveUp()
	{
	//	y-=speed;
	}
	//坦克向右移动
	public void moveRight()
	{
	//	x+=speed;
	}
	//向下移动
	public void moveDown()
	{
	//	y+=speed;
	}
	//向左边移动
	public void moveLeft()
	{
	//	x-=speed;
//		switch(this.direct)
//		{
//		case 0:
//			s=new Shot(x+10, y);
//			break;
//		case 1:
//			s=new Shot(x+30,y+10);
//			break;
//		case 2:
//			s=new Shot(x+10, y+30);
//			break;
//		case 3:
//			s=new Shot(x+30, y+10);
//			break;
		}
}

