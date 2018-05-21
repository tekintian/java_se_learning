/**
 * 复选框:JCheckBox
 * 单选框：JRadioButton
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demmo8_7 extends JFrame{

	//定义
	JPanel jp1, jp2, jp3;
	JLabel jl1, jl2;
	JButton jb1, jb2;
	JCheckBox jcb1, jcb2, jcb3;
	JRadioButton jrb1, jrb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demmo8_7 demo=new Demmo8_7();
	}
	//构造函数
	public Demmo8_7()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jl1=new JLabel("你喜欢的运动");
		jl2=new JLabel("你的性别");
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		
		jcb1=new JCheckBox("足球");
		jcb2=new JCheckBox("篮球");
		jcb3=new JCheckBox("网球");
		
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		//一定要把jrb1和jrb2放到一个ButtonGroup组中
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		// 设置JFRAME的布局是GridLayout 网格布局
		this.setLayout(new GridLayout(3,1));
		
		//向 JPanel 里面添加内容 默认是流式布局
		jp1.add(jl1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jl2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//把三个Panel添加到JFrame里面
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,150);
		this.setLocation(200, 200);
		
		this.setTitle("注册新用户");
		this.setResizable(false);
		//退出窗口退出jvm
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示
		this.setVisible(true);
				
	}
	
}
