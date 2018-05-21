/**
 * java 绘图原理
 */
package com.test1;
import javax.swing.*;
import java.awt.*;
public class Demo9_1 extends JFrame {

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_1 demo=new Demo9_1();
	}
	public Demo9_1()
	{
		mp=new MyPanel();
		this.add(mp);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
//定义一个MyPanel  用于绘图和实现绘图的区域
class MyPanel extends JPanel
{
	//覆盖 JPanel的paint 方法  
	//Graphics 绘图的重要类
	public void paint(Graphics g)  //这个方法会被系统自动调用, 如果调解窗口的大小会重新被调用，
	{
		//1:调用父类函数完成初始化任务
		super.paint(g);      //这行代码不能少，少了就不能绘图了  
		//画一个圆
//		System.out.println("paint被调用");
//		g.drawOval(10, 10, 30, 30);   // 画圆
//		
//		g.drawLine(10, 10, 50, 50);   // 画直线
//		
//		g.drawRect(10,10, 50, 50);

		
		
		
//		//画一个蓝颜色的矩形
//		g.setColor(Color.blue);
//		g.fillRect(50,50, 60, 80);
//		
//		//画一个红颜色的矩形
//		g.setColor(Color.red);
//		g.fillRect(150,150, 60, 80);
	
		
		
//		
//		//在面板上画出图片
//		Image im=Toolkit.getDefaultToolkit().getImage
//		(Panel.class.getResource("/mengmeng.jpg"));
//		//实现图片
//		 g.drawImage(im, 10, 10, 100 , 150, this);
		
		
		 
		
		//画字体
		g.setColor(Color.red);    //设置字体颜色
		g.setFont(new Font("华文彩云",Font.BOLD, 30));  //设置字体格式
		g.drawString("老桑万岁", 100,100);  //字体内容
		 
		 
	}
}
