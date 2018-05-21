/***
 * BoderLayout 布局演示
 * 1：继承JFrame
 * 2：定义需要的各个组件
 * 3:创建逐渐（构造函数）
 * 4：添加组件
 * 5:对窗体设置
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demo8_2 extends JFrame{

	//定义组件
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_2 demo=new Demo8_2();
	}
	public Demo8_2()
	{
		jb1=new JButton("中部");
		jb2=new JButton("北部");
		jb3=new JButton("东部");
		jb4=new JButton("南部");
		jb5=new JButton("西部");
		//添加组件
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.NORTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(jb4,BorderLayout.SOUTH);
		this.add(jb5,BorderLayout.WEST);
		//设置窗体属性
		this.setTitle("边界布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗体
		this.setVisible(true);
		
	}
}
