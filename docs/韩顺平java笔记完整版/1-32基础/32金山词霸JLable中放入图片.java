/**
 * 词霸
 * 列表 JList
   标签可以 做图标
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demo8_9 extends JFrame {
	 //定义组件
	JSplitPane jsp;
	JList jlist;
	JLabel jl1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_9 abc=new Demo8_9();
	}
	public Demo8_9()
	{
		//创建组件
		String []words={"boy","girl","bird"};
		jlist=new JList(words);
		jl1=new JLabel(new ImageIcon("images/ciba.jpg"));
		
		// 拆分窗格
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jlist, jl1);
		// 可以变化 单机一下就可以把窗口拆分
		jsp.setOneTouchExpandable(true);
		//设置布局管理器
		
		//添加组件
		this.add(jsp);
		
		this.setSize(500,500);
		this.setLocation(200, 200);
		
		this.setTitle("注册新用户");
		this.setResizable(false);    // 不支持最大化
		//退出窗口退出jvm
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 退出时候关闭JVM
		
		//显示
		this.setVisible(true);
	}
}
