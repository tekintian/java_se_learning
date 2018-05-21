/**
 * 网格布局演示
 * 
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demo8_4 extends JFrame{

	//定义组件
	int size=9;
	JButton jbs[]=new JButton[size];
	public static void main(String[] args) {
		Demo8_4 abc=new Demo8_4();

	}
	//构造函数
	public Demo8_4()
	{
		for(int i=0; i<9; i++)
		{
			jbs[i]=new JButton(String.valueOf(i));
		}
		//设置布局管理
		this.setLayout(new GridLayout(3,3)); //三行三列
		
		//添加组件
		for(int i=0; i<size; i++)
		{
			this.add(jbs[i]);
		}
		//设置窗体属性
		this.setSize(300,200);
		this.setLocation(200,200);
		//禁止用户改变窗体大小
		this.setResizable(false);
		//退出窗口退出jvm
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//显示
		this.setVisible(true);
	}
}
