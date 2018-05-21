/**
 * 登陆界面
 * JTextField
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demo8_6 extends JFrame{
	//定义组件
	JPanel jp1,jp2,jp3, jp4;
	JLabel jlb1, jlb2;
	JButton jb1, jb2;
	JTextField jtf1, jtf2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_6 demo=new Demo8_6();
	}
	//构造函数
	public Demo8_6()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("用户名");
		jlb2=new JLabel("密 码");
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		
		//设置布局管理
		 this.setLayout(new GridLayout(3,1));
		 
		 //加入各个组件
		 jp1.add(jlb1);
		 jp1.add(jtf1);
		 
		 jp2.add(jlb2);
		 jp2.add(jtf2);
		 
		 jp3.add(jb1);
		 jp3.add(jb2);
		 
		 //加入到JFrame
		 this.setTitle("登录界面");
		 this.add(jp1);
		 this.add(jp2);
		 this.add(jp3);
		
		 this.setSize(300,150);
		 
		 this.setResizable(false);
			//退出窗口退出jvm
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//显示
			this.setVisible(true);
		
		
	}
}
