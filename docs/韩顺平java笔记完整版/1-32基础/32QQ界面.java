/**
 * QQ聊天界面
 * 
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class Demo8_10 extends JFrame{
  
	JTextArea jta=null;    //多行文本
	JScrollPane jsp=null;    // 滚动条
	JPanel jpl=null;
	JComboBox jcb=null;    // 复选框
	JTextField jtf=null;    // 单行文本
	JButton jb=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Demo8_10 abc=new  Demo8_10();
	}
	public Demo8_10()
	{
		jta=new JTextArea();
		jsp=new JScrollPane(jta);   //多行文本中加入滚动条
		jpl=new JPanel();  // 默认是流式布局
		String []chartter={"布森","拉登"};
		jcb=new JComboBox(chartter);
		jtf=new JTextField(10);
		jb=new JButton("发送");
		
		
		//设置布局
		jpl.add(jcb);
		jpl.add(jtf);
		jpl.add(jb);
		
		//加入JFrame
		this.add(jsp);
		this.add(jpl, BorderLayout.SOUTH);
		this.setSize(300,200);
		this.setIconImage(new ImageIcon("images/qq.jpg").getImage());    //标题图标
		this.setLocation(200, 200);
		
		this.setTitle("腾讯QQ");
		this.setResizable(false);    // 不支持最大化
		//退出窗口退出jvm
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 退出时候关闭JVM
		
		//显示
		this.setVisible(true);
		
	}

}
