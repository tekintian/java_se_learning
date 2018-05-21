/**
 * 这是与好友聊天的界面
 */
package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class QqChart extends JFrame{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqChart QQ=new QqChart("1");
	}

	public 	QqChart(String friend)
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		//设置窗口的图标
		this.setTitle("你正在和"+friend+"聊天");
		this.setIconImage((new ImageIcon("image/qq.gif").getImage()));
		this.setSize(300,200);
		this.setVisible(true);
		
		
	}
}
