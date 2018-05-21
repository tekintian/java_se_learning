/**
 * 功能： 界面开发
 * 
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demo8_1 extends JFrame{
	  // 把需要的组件定义到这里
		JButton jb1=null;
	public static void main(String[] args) {
		
		   Demo8_1 demp8_1=new  Demo8_1();
		
		
	}
		//构造函数
		public Demo8_1()
		{
			//创建一个button按钮
			jb1=new JButton("我是按钮");
			
			//给窗口设置标题
			 this.setTitle("hello");
			//设置大小，按照像素计算的，，像素是密度单位，和长度不一样
			this.setSize(200, 200);
			//添加Jbutton组件
			this.add(jb1);
			//设置初始坐标
			this.setLocation(100,200);
			
			// 显示
			this.setVisible(true);
			//设置当关闭窗口时候退出JVM 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
	}

