/**
 * 功能：坦克游戏的1.0版本
 * 1：画出坦克
 * 
 */
package com.test1;
import javax.swing.*;
import java.awt.*;
public class MyTankGame1 extends JFrame{

	MyPanel mp=null;
	public static void main(String[] args) {
		
		MyTankGame1 mtg=new MyTankGame1();
	}
	//构造函数
	public MyTankGame1()
	{
		mp=new MyPanel();
		this.add(mp);
		this.setSize(400,300);
		this.setVisible(true);
	}
}
//我的面板
class MyPanel extends JPanel
{
	//定义一个我的坦克
	Hero hero=null;
	
	//构造函数
	public MyPanel()
	{
		hero=new Hero(100,100);
	}
	
	//重写paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//设置图像的背景色
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getX(), g, 0, 1);
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
			g.fill3DRect(y+15,y, 5, 30,false);
			//3:绘制中间矩形
			g.fill3DRect(x+5, y+5,10, 20,false);
			//4:画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5:绘制炮筒
			g.drawLine(x+10, x+15, y+10, y);	
			break;
		}
		
		
	}
	
}
	

//定义一个坦克类
class Tank
{
	//b表示坦克的横坐标x 和纵坐标y
	int x=0;
	int y=0;
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
}
//我的坦克
class Hero extends Tank
{
	public Hero(int x, int y)
	{
		super(x,y);
	}
}

