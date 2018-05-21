/**
 * 这个是系统管理员，经理，主管可以进入的操作界面
 * 完成界面的顺序，从上到下，从左到右，
 */
package com.myl.view;
import com.mhl.tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
public class Windows1 extends JFrame{

	//定义需要的组件
	Image titleIcon;    //定义小图标  标题左边上的小图标
	JMenuBar jmb;     //定义菜单条
	//定义一级菜单
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;   //定义菜单选项
	//定义二级菜单
	JMenuItem jmm1, jmm2, jmm3, jmm4, jmm5;   
	
	//图标
	ImageIcon jmm1_icon1, jmm1_icon2, jmm1_icon3, jmm1_icon4, jmm1_icon5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Windows1 w1=new Windows1();
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
		
		//把JMenuBar添加到JFrame中
		this.setJMenuBar(jmb);
		
		
		//设置大小
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		//关闭窗口是侯退出系统
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的图片
		this.setIconImage(titleIcon);
		this.setTitle("满汉楼餐饮系统");
		this.setSize(w, h-25);
		this.setVisible(true);
	}

}