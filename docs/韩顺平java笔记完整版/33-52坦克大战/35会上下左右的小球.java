/**
 * 功能是加深对事件处理机制的理解
 * 1：通过上下左右键来控制小球为位置的移动
 */
package com.test4;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class Demo9_4 extends JFrame {

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_4 demo=new Demo9_4();

	}
	//构造函数
	public Demo9_4()
	{
		mp=new MyPanel();
	  	//mp加入到JFrame
		this.add(mp);   // 每定义一个 Demo9_4 都会产生一个对应的this
		
		//添加监听
		this.addKeyListener(mp);     // 键盘监听这个类所定义的对象  用mp对象进行监听
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
//定义自己的面板

class MyPanel extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 20, 20);
	}
    //键被按下
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	//	 System.out.println("键被按下"+(char)arg0.getKeyCode() );
		if(arg0.getKeyCode()==KeyEvent.VK_UP)
		{
			//System.out.println("键被按上");
			y-=10;	
		}
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//System.out.println("键被按上");
			y+=10;
					
		}
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			//System.out.println("键被按左");
			x-=10;
		}
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			//System.out.println("键被按右");
			x+=10;
		}
		//调用 repaint() 函数，来重绘制界面
		this.repaint();
	}
	//键被释放
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//键的一个值被打印输出
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}