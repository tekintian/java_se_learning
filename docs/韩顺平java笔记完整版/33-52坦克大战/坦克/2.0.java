/**
 * 功能：坦克游戏的2.0版本
 * 1：画出坦克
 * 2:实现坦克上下左右移动
 */
package com.test6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyTankGame2 extends JFrame{

	MyPanel mp=null;
	public static void main(String[] args) {
		
		MyTankGame2 mtg=new MyTankGame2();
	}
	//构造函数
	public MyTankGame2()
	{
		mp=new MyPanel();
		this.add(mp);
		//注册监听
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setVisible(true);
	}
}
//我的面板
class MyPanel extends JPanel implements KeyListener
{
	//定义一个我的坦克
	Hero hero=null;
	
	//构造函数
	public MyPanel()
	{
		hero=new Hero(150,150);
	}
	
	//重写paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//设置图像的背景色
		g.fillRect(0, 0, 600, 400);
		this.drawTank(hero.getX(),hero.getY(), g,hero.direct,1);
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
			g.fill3DRect(x+5, y+5,10, 20,true);
			//4:画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5:绘制炮筒
			g.drawLine(x+10, y+15, x+10, y);	
			break;
		}
		
		
	}
	//键按下处理 a s w d
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			//向上
		//	this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//向右
		//	this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//向下
		//	this.hero.setDirect(2);
			this.hero.moveDown();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//向左
		//	this.hero.setDirect(3);
			this.hero.moveLeft();
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
	
}
	

//定义一个坦克类
class Tank
{
	//b表示坦克的横坐标x 和纵坐标y
	int x=0;
	int y=0;
	// 定义方向  0表示向上 1表示右， 2表示下 3表示左
	int direct=0;
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
}
//我的坦克
class Hero extends Tank
{
	public Hero(int x, int y)
	{
		super(x,y);
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

