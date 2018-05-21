/**
 * 这个是系统管理员，经理，主管可以进入的操作界面
 * 完成界面的顺序，从上到下，从左到右，
 */
package com.myl.view;
import com.mhl.tools.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;
import java.util.*;
public class Windows1 extends JFrame implements ActionListener , MouseListener{

	//定义需要的组件
	Image titleIcon, timeGg;    //定义小图标  标题左边上的小图标
	JMenuBar jmb;     //定义菜单条
	//定义一级菜单
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;   //定义菜单选项
	//定义二级菜单
	JMenuItem jmm1, jmm2, jmm3, jmm4, jmm5;   
	
	//图标
	ImageIcon jmm1_icon1, jmm1_icon2, jmm1_icon3, jmm1_icon4, jmm1_icon5;
	//工具栏
	JToolBar jtb;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;
	//定义需要的五个JPanel
	JPanel p1, p2, p3, p4, p5;
	//显示当前时间
	JLabel timeNow;
	JLabel p1_lab1,p1_lab2,p1_lab3,p1_lab4,p1_lab5,p1_lab6,p1_lab7,p1_lab8;
	//给p2面板定义需要的JLable
	JLabel p2_lab1, p2_lab2;
	//javax.swing 包中的Timer可以定时的触发Action事件， 我们可以用它来完成一些事
	javax.swing.Timer t;
	ImagePanel p1_imgPanel;
	JSplitPane jsp1;
	CardLayout cardp3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Windows1 w1=new Windows1();
	}
	
	//初始化中间的Panel
	public void initallPanels()
	{
		//处理p1面板
		p1=new JPanel(new BorderLayout());
		Image p1_bg=null;
		try {
			p1_bg = ImageIO.read(new File("image\\jp1.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//定义一个手状光标
		Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);
		
		this.p1_imgPanel=new ImagePanel(p1_bg);
		this.p1_imgPanel.setLayout(new GridLayout(8,1));
		//p1的第一个Label
		p1_lab1=new JLabel(new ImageIcon("image\\label_1.gif"));
		p1_lab1.setFont(MyTools.f3);
		p1_imgPanel.add(p1_lab1);
		//第二个label
		p1_lab2=new JLabel("人 事 管 理",new ImageIcon("image\\label_2.jpg"),0);
		p1_lab2.setFont(MyTools.f3);
		p1_lab2.setCursor(myCursor);
		//让该lable 不可用
		p1_lab2.setEnabled(false);
		//注册监监听
		p1_lab2.addMouseListener(this);
		p1_imgPanel.add(p1_lab2);
		//第三个
		p1_lab3=new JLabel("登 录 管 理",new ImageIcon("image\\label_3.jpg"),0);
		p1_lab3.setFont(MyTools.f3);
		p1_lab3.setCursor(myCursor);
		p1_lab3.setEnabled(false);
		p1_lab3.addMouseListener(this);
		p1_imgPanel.add(p1_lab3);
		p1_lab4=new JLabel("菜 谱 价 格",new ImageIcon("image\\label_4.jpg"),0);
		p1_lab4.setFont(MyTools.f3);
		p1_lab4.setCursor(myCursor);
		p1_lab4.setEnabled(false);
		p1_lab4.addMouseListener(this);
		p1_imgPanel.add(p1_lab4);
		p1_lab5=new JLabel("报 表 统 计",new ImageIcon("image\\label_5.jpg"),0);
		p1_lab5.setFont(MyTools.f3);
		p1_lab5.setCursor(myCursor);
		p1_lab5.setEnabled(false);
		p1_lab5.addMouseListener(this);
		p1_imgPanel.add(p1_lab5);
		p1_lab6=new JLabel("成 本 及 库 房",new ImageIcon("image\\label_6.jpg"),0);
		p1_lab6.setFont(MyTools.f3);
		p1_lab6.setCursor(myCursor);
		p1_lab6.setEnabled(false);
		p1_lab6.addMouseListener(this);
		p1_imgPanel.add(p1_lab6);
		p1_lab7=new JLabel("系 统 设 置",new ImageIcon("image\\label_7.jpg"),0);
		p1_lab7.setFont(MyTools.f3);
		p1_lab7.setCursor(myCursor);
		p1_lab7.setEnabled(false);
		p1_lab7.addMouseListener(this);
		p1_imgPanel.add(p1_lab7);
		p1_lab8=new JLabel("动 画 帮 助",new ImageIcon("image\\label_8.jpg"),0);
		p1_lab8.setFont(MyTools.f3);
		p1_lab8.setCursor(myCursor);
		p1_lab8.setEnabled(false);
		p1_lab8.addMouseListener(this);
		p1_imgPanel.add(p1_lab8);
		p1.add(this.p1_imgPanel);
		
		
		//处理p2, p3, p4,
		p4=new JPanel(new BorderLayout());
		p2=new JPanel(new CardLayout());
		p2_lab1=new JLabel(new ImageIcon("image\\jp2_left.jpg"));
		p2_lab2=new JLabel(new ImageIcon("image\\jp2_right.jpg"));
		//把p2_lab1...加入到p2中
		p2.add(p2_lab1,"0");
		p2.add(p2_lab2,"1");
		this.cardp3=new CardLayout();
		p3=new JPanel(this.cardp3);
		//先给p3加入一个主界面卡片
		Image zhu_image=null;
		try {
			zhu_image = ImageIO.read(new File("image\\zhujiemian.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImagePanel ip=new  ImagePanel(zhu_image);
		p3.add(ip, "0");
		//对p3做添加几个JLable
		JLabel rs=new JLabel (new ImageIcon("image\\renshi.jpg"));
		p3.add(rs, "1");
		JLabel dlgl=new JLabel (new ImageIcon("image\\dlgl.jpg"));
		p3.add(dlgl,"2");
		//把p2,p3, 加入到p4
		p4.add(p2,"West");
		p4.add(p3,"Center");
	}
	
	//初始化工具栏
	public void initToolBar()
	{
		//处理工具栏的组件
		jtb=new JToolBar();
		jb1=new JButton(new ImageIcon("image\\jb1.jpg"));
		jb2=new JButton(new ImageIcon("image\\jb2.jpg"));
		jb3=new JButton(new ImageIcon("image\\jb3.jpg"));
		jb4=new JButton(new ImageIcon("image\\jb4.jpg"));
		jb5=new JButton(new ImageIcon("image\\jb5.jpg"));
		jb6=new JButton(new ImageIcon("image\\jb6.jpg"));
		jb7=new JButton(new ImageIcon("image\\jb7.jpg"));
		jb8=new JButton(new ImageIcon("image\\jb8.jpg"));
		jb9=new JButton(new ImageIcon("image\\jb9.jpg"));
		jb10=new JButton(new ImageIcon("image\\jb10.jpg"));
		//把按钮加到jb1中
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
	}
	
	//初始化菜单
	public void initMenu()
	{
		//创建图标
		jmm1_icon1=new ImageIcon("image\\jm1_icon1.jpg");
		jmm1_icon2=new ImageIcon("image\\jm1_icon2.jpg");
		jmm1_icon3=new ImageIcon("image\\jm1_icon3.jpg");
		jmm1_icon4=new ImageIcon("image\\jm1_icon4.jpg");
		jmm1_icon5=new ImageIcon("image\\jm1_icon5.jpg");
		
		//创建一级菜单
		jm1=new JMenu("系统管理");
		jm1.setFont(MyTools.f1);
		//创建二级菜单
		jmm1=new JMenuItem("切换到用户界面", jmm1_icon1);
		jmm1.setFont(MyTools.f2);
		jmm2=new JMenuItem("切换到收款界面", jmm1_icon2);
		jmm2.setFont(MyTools.f2);
		jmm3=new JMenuItem("登录界面", jmm1_icon3);
		jmm3.setFont(MyTools.f2);
		jmm4=new JMenuItem("万年历", jmm1_icon4);
		jmm4.setFont(MyTools.f2);
		jmm5=new JMenuItem("退出", jmm1_icon5);
		jmm5.setFont(MyTools.f2);
		//加入
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		jm2=new JMenu("人事管理");
		jm2.setFont(MyTools.f1);
		jm3=new JMenu("菜单服务");
		jm3.setFont(MyTools.f1);
		jm4=new JMenu("报表统计");
		jm4.setFont(MyTools.f1);
		jm5=new JMenu("成本及库房");
		jm5.setFont(MyTools.f1);
		jm6=new JMenu("帮助");
		jm6.setFont(MyTools.f1);
		
		//把一级菜单加入到JMenuBar
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
	}
	
	
	public Windows1()
	{
		//创建组件
		try {
			titleIcon=ImageIO.read(new File("image\\jiubei.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用初始化菜单函数
		this.initMenu();
		//初始化工具栏
		this.initToolBar();
		//调用初始化面板的函数
		this.initallPanels();
		
		//把JMenuBar添加到JFrame中
		this.setJMenuBar(jmb);
		
		
		
		
		
		//做一个拆分窗口分别存放P1，和p4
		jsp1=new JSplitPane (JSplitPane.HORIZONTAL_SPLIT, true, p1, p4);
		//指定左边的面板占多大的像素
		jsp1.setDividerLocation(120);
		//把边界线设置为0
		jsp1.setDividerSize(0);
		//处理p5面板
		p5=new JPanel(new BorderLayout());
		//创建Timer
		t=new Timer(1000, this);  //每隔1秒去触发一个acction event 时间
		t.start();
		
		
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString()+"  ");
		timeNow.setFont(MyTools.f2);
		try {
			timeGg=ImageIO.read(new File("image\\zhuangtailan.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip1=new ImagePanel(timeGg);
		
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow, "East");
		p5.add(ip1);
		
		//从JFrame 中取出	Container
		Container ct=this.getContentPane();
		
		ct.add(jtb, "North");
		ct.add(jsp1, "Center");
		ct.add(p5, "South");
		//设置工具栏是否可以浮动
		jtb.setFloatable(false);
		//设置大小
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		//关闭窗口是侯退出系统
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的图片
		this.setIconImage(titleIcon);
		this.setTitle("满汉楼餐饮系统");
		this.setSize(w, h-30);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.timeNow.setText("当前时间 "+Calendar.getInstance().getTime().toLocaleString()+"  ");
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//判断用户点击那个lable
		if(arg0.getSource()==this.p1_lab2)
		{
			this.cardp3.show(p3, "1");
		}else if(arg0.getSource()==this.p1_lab3)
		{
			this.cardp3.show(p3, "2");
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户选中了某个操作jlabel则高亮
		if(arg0.getSource()==this.p1_lab2)
		{
			//鼠标到达label区域显示高亮
			this.p1_lab2.setEnabled(true);
		}else if(arg0.getSource()==this.p1_lab3)
		{
			this.p1_lab3.setEnabled(true);
		}else if(arg0.getSource()==this.p1_lab4)
		{
			this.p1_lab4.setEnabled(true);
		}else if(arg0.getSource()==this.p1_lab5)
		{
			this.p1_lab5.setEnabled(true);
		}else if(arg0.getSource()==this.p1_lab6)
		{
			this.p1_lab6.setEnabled(true);
		}else if(arg0.getSource()==this.p1_lab7)
		{
			this.p1_lab7.setEnabled(true);
		}else if(arg0.getSource()==this.p1_lab8)
		{
			this.p1_lab8.setEnabled(true);
		}
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户选中了某个操作jlabel则禁用
		if(arg0.getSource()==this.p1_lab2)
		{
			this.p1_lab2.setEnabled(false);
		}else if(arg0.getSource()==this.p1_lab3)
		{
			this.p1_lab3.setEnabled(false);
		}else if(arg0.getSource()==this.p1_lab4)
		{
			this.p1_lab4.setEnabled(false);
		}else if(arg0.getSource()==this.p1_lab5)
		{
			this.p1_lab5.setEnabled(false);
		}else if(arg0.getSource()==this.p1_lab6)
		{
			this.p1_lab6.setEnabled(false);
		}else if(arg0.getSource()==this.p1_lab7)
		{
			this.p1_lab7.setEnabled(false);
		}else if(arg0.getSource()==this.p1_lab8)
		{
			this.p1_lab8.setEnabled(false);
		}
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}