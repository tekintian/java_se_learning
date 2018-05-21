/*
 * 该界面只有经理，主管，系统管理员可以进入的操作界面
 * 完成界面的顺序是从左到右，从上到下
 * */
package com.mhl.view;
//引入字体包
import com.mhl.mytools.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;

import com.sun.java.swing.plaf.windows.resources.windows;
public class Windows1 extends JFrame implements ActionListener,MouseListener{
	
	//定义界面中需要的组件
	//标题图标
	Image titleIcon,timebg;
	//菜单条
	JMenuBar jmb;
	//一级菜单
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//二级菜单
	
	//第一个菜单的二级菜单
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5;
	
	//二级菜单的图标
	
	//第一个菜单的二级菜单图标
	ImageIcon jm1_icon1,jm1_icon2,jm1_icon3,jm1_icon4,jm1_icon5;
	
	//创建工具条
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	//定义需要的五个面板（JPanel）及JLabel
	JPanel jp1,jp2,jp3,jp4,jp5;
	//再定义7个面板，用于处理当点击jp1面板上的标签时，应该在jp3卡片上显示的卡片（每一张卡片用一个面板，这样可显示不同的功能模块，如人事管理，登陆管理的界面）
	JPanel jp3_1,jp3_2,jp3_3,jp3_4,jp3_5,jp3_6,jp3_7;
	
	//定义jp1面板上需要的组件
	//调用ImagePanel类，用于画jp1背景图片
	ImagePanel jp1_imgPanel;
	//定义jp1面板所需的背景图片
	Image jp1_bg;
	//jp1面板上的六个小图标（标签）
	JLabel jp1_lab1,jp1_lab2,jp1_lab3,jp1_lab4,jp1_lab5,jp1_lab6,jp1_lab7,jp1_lab8;
	//给jp2定义需要的JLabel，即两个左右图标，用于控制卡片区域的显示
	JLabel jp2_lab1,jp2_lab2;
	//定义jp3需要的组件
	Image jp3_bg;
	//定义jp3卡片测试需要的图片标签
	JLabel jp3_l1,jp3_l2,jp3_l3,jp3_l4,jp3_l5,jp3_l6,jp3_l7;
	//定义jp2,jp3为卡片布局，必须在这里定义，后的的监听才能切换卡片
	CardLayout cardjp2,cardjp3;
	//定义一个拆分窗口的组件，用于分别存放jp1,jp4
	JSplitPane jsp1;
	
	//在状态栏中显示当前时间
	JLabel timeNow;
	//javax.swing包中的Timer可以定时的处理Action事件，因此可以用它来完成一些功能
	//但是在JAVA中，Timer存在于多个包中，其功能也不一样，因此使用时必须指定包
	//同时必须实现接口监听,implements ActionListener
	javax.swing.Timer t;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Windows1 w1=new Windows1();
	}
	//初始化菜单条的函数
	public void initMenu()
	{
		//创建第一个菜单的二级菜单图标
		jm1_icon1=new ImageIcon("image/jm1_icon1.jpg");
		jm1_icon2=new ImageIcon("image/jm1_icon2.jpg");
		jm1_icon3=new ImageIcon("image/jm1_icon3.jpg");
		jm1_icon4=new ImageIcon("image/jm1_icon4.jpg");
		jm1_icon5=new ImageIcon("image/jm1_icon5.jpg");
		
		//创建一级菜单
		jm1=new JMenu("系统管理");
		jm1.setFont(MyFont.f1);
		//对其子菜单采取就近原则，可读性高，同时便于查看代码
		//创建二级菜单
		jmm1=new JMenuItem("切换用户",jm1_icon1);
		jmm1.setFont(MyFont.f2);
		
		jmm2=new JMenuItem("切换到收款界面",jm1_icon2);
		jmm2.setFont(MyFont.f2);
		
		jmm3=new JMenuItem("登陆管理",jm1_icon3);
		jmm3.setFont(MyFont.f2);
		
		jmm4=new JMenuItem("万年历",jm1_icon4);
		jmm4.setFont(MyFont.f2);
		
		jmm5=new JMenuItem("退出",jm1_icon5);
		jmm5.setFont(MyFont.f2);
		//添加到一级菜单
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		
		
		jm2=new JMenu("人事管理");
		jm2.setFont(MyFont.f1);
		
		jm3=new JMenu("菜单服务");
		jm3.setFont(MyFont.f1);
		
		jm4=new JMenu("报表统计");
		jm4.setFont(MyFont.f1);
		
		jm5=new JMenu("成本及库房");
		jm5.setFont(MyFont.f1);
		
		jm6=new JMenu("帮助");
		jm6.setFont(MyFont.f1);
		
		//把一级菜单添加菜单条
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		//把菜单条JMenuBar添加到JFrame上面去
		this.setJMenuBar(jmb);
	}
	//初始化工具条的函数
	public void initToolBar()
	{
		//处理工具栏的组件
		//创建工具条
		jtb=new JToolBar();
		//设置工具条不可以浮动，即固定不动
		jtb.setFloatable(false);
		//创建工具条上面的按钮
		jb1=new JButton(new ImageIcon("image/toolBar_image/jb1.jpg"));
		jb2=new JButton(new ImageIcon("image/toolBar_image/jb2.jpg"));
		jb3=new JButton(new ImageIcon("image/toolBar_image/jb3.jpg"));
		jb4=new JButton(new ImageIcon("image/toolBar_image/jb4.jpg"));
		jb5=new JButton(new ImageIcon("image/toolBar_image/jb5.jpg"));
		jb6=new JButton(new ImageIcon("image/toolBar_image/jb6.jpg"));
		jb7=new JButton(new ImageIcon("image/toolBar_image/jb7.jpg"));
		jb8=new JButton(new ImageIcon("image/toolBar_image/jb8.jpg"));
		jb9=new JButton(new ImageIcon("image/toolBar_image/jb9.jpg"));
		jb10=new JButton(new ImageIcon("image/toolBar_image/jb10.jpg"));
		
		//把按钮添加到工具条
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
		
		//把工具条添加到窗口的北部
		this.add(jtb,BorderLayout.NORTH);
	}
	//初始化窗口主体部分（中间部分，四个面板）的函数
	public void initAllPanel()
	{
		//处理窗口主体（即中间部分）
		//创建jp1面板
		jp1=new JPanel(new BorderLayout());//创建并设置为边界布局
		try {
			jp1_bg=ImageIO.read(new File("image/center_image/jp1_bg.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//定义一个鼠标指针的类型
		Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);//手型鼠标
		jp1_imgPanel=new ImagePanel(jp1_bg);
		//对图片面板设置为网格布局
		this.jp1_imgPanel.setLayout(new GridLayout(8,1));
		//在图片面板上添加小图标，也就是Label
		//new JLabel()构造函数中的参数顺序是：文字说明，图标，序号
		jp1_lab1=new JLabel(new ImageIcon("image/center_image/label_1.gif"));
		jp1_imgPanel.add(jp1_lab1);
		jp1_lab2=new JLabel("人 事 管 理",new ImageIcon("image/center_image/label_2.jpg"),0);
		jp1_lab2.setFont(MyFont.f4);
		//当鼠标移到JLabel上面时变成一只小手
		jp1_lab2.setCursor(myCursor);
		//默认让JLabel不可用
		jp1_lab2.setEnabled(false);
		//给jp1_lab2添加鼠标监听
		jp1_lab2.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab2);
		jp1_lab3=new JLabel("登 陆 管 理",new ImageIcon("image/center_image/label_3.jpg"),0);
		jp1_lab3.setFont(MyFont.f4);
		jp1_lab3.setCursor(myCursor);
		jp1_lab3.setEnabled(false);
		jp1_lab3.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab3);
		jp1_lab4=new JLabel("菜 谱 价 格",new ImageIcon("image/center_image/label_4.jpg"),0);
		jp1_lab4.setFont(MyFont.f4);
		jp1_lab4.setCursor(myCursor);
		jp1_lab4.setEnabled(false);
		jp1_lab4.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab4);
		jp1_lab5=new JLabel("报 表 统 计",new ImageIcon("image/center_image/label_5.jpg"),0);
		jp1_lab5.setFont(MyFont.f4);
		jp1_lab5.setCursor(myCursor);
		jp1_lab5.setEnabled(false);
		jp1_lab5.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab5);
		jp1_lab6=new JLabel("成本及库房",new ImageIcon("image/center_image/label_6.jpg"),0);
		jp1_lab6.setFont(MyFont.f4);
		jp1_lab6.setCursor(myCursor);
		jp1_lab6.setEnabled(false);
		jp1_lab6.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab6);
		jp1_lab7=new JLabel("系 统 设 置",new ImageIcon("image/center_image/label_7.jpg"),0);
		jp1_lab7.setFont(MyFont.f4);
		jp1_lab7.setCursor(myCursor);
		jp1_lab7.setEnabled(false);
		jp1_lab7.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab7);
		jp1_lab8=new JLabel("动 画 帮 助",new ImageIcon("image/center_image/label_8.jpg"),0);
		jp1_lab8.setFont(MyFont.f4);
		jp1_lab2.setCursor(myCursor);
		jp1_lab8.setEnabled(false);
		jp1_lab8.addMouseListener(this);
		jp1_imgPanel.add(jp1_lab8);
		//将图片面板放入到jp1面板
		jp1.add(jp1_imgPanel);
		
		//创建jp2，jp3,jp4面板，其中jp2,jp3是被jp4包起来的
		//其中jp4是边界布局,jp2位于jp4的西边，jp3位于中间（占据大部分位置），jp2、jp3是卡片布局
		//分别设置三个面板的布局模式
		jp4=new JPanel(new BorderLayout());
		
		this.cardjp2=new CardLayout();
		//设置jp2为卡片布局
		jp2=new JPanel(cardjp2);
		//创建两个标签（左，右）用于当点击时，拆分窗口的显示区域
		jp2_lab1=new JLabel(new ImageIcon("image/center_image/jp2_left.jpg"));
		jp2_lab1.addMouseListener(this);
		jp2_lab2=new JLabel(new ImageIcon("image/center_image/jp2_right.jpg"));
		jp2_lab2.addMouseListener(this);
		//把jp2_lab1,jp2_lab2加入到jp2中,jp2是卡片布局
		jp2.add(jp2_lab1,"0");
		jp2.add(jp2_lab2,"1");
		
		this.cardjp3=new CardLayout();
		jp3=new JPanel(cardjp3);
		//先给jp3加入一个主界面的卡片（图片面板）
		try {
			jp3_bg=ImageIO.read(new File("image/center_image/jp3_bg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImagePanel ip_jp3=new ImagePanel(jp3_bg);
		//创建两个图片标签用于测试卡片布局
		jp3_l1=new JLabel(new ImageIcon("image/jp3_test/jp3_1.jpg"));
		jp3_l2=new JLabel(new ImageIcon("image/jp3_test/jp3_2.jpg"));
		jp3_l3=new JLabel(new ImageIcon("image/jp3_test/jp3_3.jpg"));
		jp3_l4=new JLabel(new ImageIcon("image/jp3_test/jp3_4.jpg"));
		jp3_l5=new JLabel(new ImageIcon("image/jp3_test/jp3_5.jpg"));
		jp3_l6=new JLabel(new ImageIcon("image/jp3_test/jp3_6.jpg"));
		jp3_l7=new JLabel(new ImageIcon("image/jp3_test/jp3_7.jpg"));
		
		
		//创建各功能块对应的卡片面板
		
		jp3_1=new JPanel();
		jp3_1.add(jp3_l1);
		
		jp3_2=new JPanel();
		jp3_2.add(jp3_l2);
		
		jp3_3=new JPanel();
		jp3_3.add(jp3_l3);
		
		jp3_4=new JPanel();
		jp3_4.add(jp3_l4);
		
		jp3_5=new JPanel();
		jp3_5.add(jp3_l5);
		
		jp3_6=new JPanel();
		jp3_6.add(jp3_l6);
		
		jp3_7=new JPanel();
		jp3_7.add(jp3_l7);
		
		//添加卡片
		jp3.add(ip_jp3,"0");
		jp3.add(jp3_1,"1");
		jp3.add(jp3_2,"2");
		jp3.add(jp3_3,"3");
		jp3.add(jp3_4,"4");
		jp3.add(jp3_5,"5");
		jp3.add(jp3_6,"6");
		jp3.add(jp3_7,"7");
		
		//把jp2,jp3加入jp4
		jp4.add(jp2,BorderLayout.WEST);
		jp4.add(jp3,BorderLayout.CENTER);
		
		//做一个拆分窗口，分别存放jp1,jp4
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
		//指定左边的面板占多大的像素
		jsp1.setDividerLocation(150);
		//把拆分边界线设为0，即不显示
		jsp1.setDividerSize(0);
		
		//将jsp1面板放入到窗体
		this.add(jsp1,BorderLayout.CENTER);
	}
	//初始化状态栏（jp5面板）的函数
	public void initJp5()
	{
		//创建jp5面板，即状态栏的处理
		jp5=new JPanel();
		//设置jp5面板的布局方式，便于在该面板上放置其他功能面板
		jp5.setLayout(new BorderLayout());
		//创建Timer
		t=new Timer(1000,this);//每隔一秒，去融发一个ActionEvent事件
		//启动定时器
		t.start();
		//创建显示时间标签
		//Calendar.getInstance().getTime().toLocaleString()是指得到当前的系统时间
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
		timeNow.setFont(MyFont.f3);
		try {
			timebg=ImageIO.read(new File("image/time_bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建一个图片面板，用于画状态栏的背景图
		ImagePanel ip1=new ImagePanel(timebg);
		//设置图片面板的布局方式
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow,BorderLayout.EAST);
		jp5.add(ip1);
		this.add(jp5,BorderLayout.SOUTH);
		
	}
	public Windows1()
	{
		//设置窗口标题图标
		try {
			//在PS中制作透明背景的图标时，必须保存为GIF格式的图片，方能显示透明背景
			titleIcon=ImageIO.read(new File("image/title.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIconImage(titleIcon);
		this.setTitle("满汉楼餐饮管理系统");
		this.setFont(MyFont.f0);
		
		//把每一个功能块的代码抽象成一个函数，这样可读性高，同时便于测试和分析
		
		//调用初始化菜单条的函数
		this.initMenu();
		//调用初始化工具条的函数
		this.initToolBar();
		//调用初始化窗口主体（中间部分,jp1,jp2,jp3,jp4）的函数
		this.initAllPanel();
		//调用初始化状态栏(jp5)的函数
		this.initJp5();
		
		//设置大小
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//设置窗体
		this.setSize(width,height-32);
		this.setVisible(true);
		//关闭窗口时退出系统
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.timeNow.setText("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+" ");
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jp1_lab2)//人事管理
		{
			this.cardjp3.show(jp3, "1");
		}
		else if(e.getSource()==this.jp1_lab3)//登陆管理
		{
			this.cardjp3.show(jp3, "2");
		}
		else if(e.getSource()==this.jp1_lab4)//菜谱价格
		{
			this.cardjp3.show(jp3, "3");
		}
		else if(e.getSource()==this.jp1_lab5)//报表统计
		{
			this.cardjp3.show(jp3, "4");
		}
		else if(e.getSource()==this.jp1_lab6)//成本及库房
		{
			this.cardjp3.show(jp3, "5");
		}
		else if(e.getSource()==this.jp1_lab7)//系统设置
		{
			this.cardjp3.show(jp3, "6");
		}
		else if(e.getSource()==this.jp1_lab8)//动画帮助
		{
			this.cardjp3.show(jp3, "7");
		}
		else if(e.getSource()==jp2_lab1)
		{
			//把显示各种操作的界面隐藏起来（jp1)，同时显示jp2卡片布局中的jp2_lab2(向右的箭头)
			//把拆分面板的左边隐藏起来，即隐藏jp1
			this.jsp1.setDividerLocation(0);//设置拆分面板的左边面板的大小为0像素，即不可见
			//同时显示向右的箭头
			this.cardjp2.show(jp2,"1");
		}
		else if(e.getSource()==jp2_lab2)
		{
			//把隐藏的jp1面板展开，即设置左边面板拆分大小
			this.jsp1.setDividerLocation(150);//由于前面定义拆分面板时，左边占150像素，此时应显示150像素
			//同时显示向左的箭头
			this.cardjp2.show(jp2,"0");
		}
	
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//如果用户选择了某个操作JLabel，则高亮
		if(e.getSource()==this.jp1_lab2)
		{
			this.jp1_lab2.setEnabled(true);
		}
		else if(e.getSource()==this.jp1_lab3)
		{
			this.jp1_lab3.setEnabled(true);
		}
		else if(e.getSource()==this.jp1_lab4)
		{
			this.jp1_lab4.setEnabled(true);
		}
		else if(e.getSource()==this.jp1_lab5)
		{
			this.jp1_lab5.setEnabled(true);
		}
		else if(e.getSource()==this.jp1_lab6)
		{
			this.jp1_lab6.setEnabled(true);
		}
		else if(e.getSource()==this.jp1_lab7)
		{
			this.jp1_lab7.setEnabled(true);
		}
		else if(e.getSource()==this.jp1_lab8)
		{
			this.jp1_lab8.setEnabled(true);
		}
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//如果用户离开了JLabel，则禁用
		if(e.getSource()==this.jp1_lab2)
		{
			this.jp1_lab2.setEnabled(false);
		}
		else if(e.getSource()==this.jp1_lab3)
		{
			this.jp1_lab3.setEnabled(false);
		}
		else if(e.getSource()==this.jp1_lab4)
		{
			this.jp1_lab4.setEnabled(false);
		}
		else if(e.getSource()==this.jp1_lab5)
		{
			this.jp1_lab5.setEnabled(false);
		}
		else if(e.getSource()==this.jp1_lab6)
		{
			this.jp1_lab6.setEnabled(false);
		}
		else if(e.getSource()==this.jp1_lab7)
		{
			this.jp1_lab7.setEnabled(false);
		}
		else if(e.getSource()==this.jp1_lab8)
		{
			this.jp1_lab8.setEnabled(false);
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

