package com.mhl.view;
//引入字体包
import com.mhl.model.*;
import com.mhl.mytools.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Login extends JDialog implements ActionListener {
	
	//创建登陆组件
	JLabel jl1,jl2,jl3;
	JTextField jname;
	JPasswordField jpasswd;
	JButton jlog,jcancle;
	//设置一个字体
	Font f1;
	
	public static void main(String []args)
	{
		Login login=new Login();
	}
	public Login()
	{	
//		this.add(jl1)等价于如下语句，这是两种写法，下面一种是老程序员较多
//		Container ct=new Container();//创建一个容器
//		ct.add(jl1);//把组件添加到容器中
		
		//创建一个字体
		//f1=new Font("宋体",Font.PLAIN,16);
		
		//添加组件
		//提示输入用户名
		jl1=new JLabel("请输入用户名：");
		jl1.setBounds(60, 190, 150, 30);
		jl1.setFont(MyFont.f1);
		this.add(jl1);
		
		//或提示输入员工号
		jl2=new JLabel("(或员工号)");
		jl2.setForeground(Color.red);
		jl2.setFont(MyFont.f2);
		jl2.setBounds(100,210,100,30);
		this.add(jl2);
		
		//提示输入密码
		jl3=new JLabel ("请输入密码：");
		jl3.setBounds(60,240,150,30);
		jl3.setFont(MyFont.f2);
		this.add(jl3);
		
		//用户名的输入文本框
		jname=new JTextField(20);
		jname.setFocusable(true);
		jname.setBounds(180,190,120,30);
		jname.setFont(f1);
		this.add(jname);
		//设置边界下凹
		jname.setBorder(BorderFactory.createLoweredBevelBorder());
		
		//设置密码输入框
		jpasswd=new JPasswordField();
		jpasswd.setFocusable(true);
		jpasswd.setBounds(180,240,120,30);
		this.add(jpasswd);
		jpasswd.setBorder(BorderFactory.createLoweredBevelBorder());
		
		//设置登陆按钮
		jlog=new JButton("确 定");
		//添加监听
		jlog.addActionListener(this);
		jlog.setBounds(105,300,75,30);
		jlog.setFont(f1);
		//设置前景色
		jlog.setForeground(Color.blue);
		this.add(jlog);
		
		//设置取消按钮
		jcancle=new JButton("取 消");
		jcancle.addActionListener(this);
		jcancle.setBounds(215,300,75,30);
		jcancle.setFont(f1);
		//设置前景色为蓝色
		jcancle.setForeground(Color.blue);
		this.add(jcancle);
		
		//设置空布局
		this.setLayout(null);
		//创建一个BackImage对象
		BackImage bi=new BackImage();
		//设定图片的位置
		bi.setBounds(0,0,360,360);
		//把图片添加到JDialog
		this.add(bi);
		//不显示窗口的上下边框
		this.setUndecorated(true);
		//设置窗口居中
		this.setSize(360, 360);
		int width=getToolkit().getDefaultToolkit().getScreenSize().width;
		int height=getToolkit().getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-200);
		this.setVisible(true);
	}
	
	//创建一个内部类，并继承JPanle，用于画背景图片
	class BackImage extends JPanel
	{
		Image im;
		public BackImage(){
			try
			{
				im=ImageIO.read(new File("Image/login.gif"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//要把图片画到JPanle，需要重写一个Paint方法
		public void paint(Graphics g) //此处的paint中的p是小写，
		//如果是大写，则就是重写paint方法了，而是一个新的方法了，那么后面的图片是不会输出的
		{
			g.drawImage(im,0,0,360,360,this);
		}
//		public void Paint(Graphics g)
//		{
//			g.drawImage(im,0,0,348,330,this);
//		}
		
	}
//响应用户登陆的请求
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断是否点击确定按钮
		if(arg0.getSource()==jlog)
		{
			//取出员工号及其密码
			String userName=this.jname.getText().trim();//trim()用于防止用户名中有空格
			//此处密码的获取不能通过getText()方法，为了安全一般用getPassword()数组，
			//并可用一个字符串来接收该数组
			String passwd=new String(this.jpasswd.getPassword());
			//取得用户名及密码后，调用模式处理
			UserModel um=new UserModel();
			String zhiwei=um.checkUser(userName, passwd);//返回员工的职位
			if(zhiwei.equals("经理")||zhiwei.equals("管理员")||zhiwei.equals("主管"))
			{
				//通过new Windows1()切换到相应的页面(窗口)
				new Windows1();
				//切换到Windows1页面后，关闭登陆界面
				this.dispose();
			}
		}
		else if(arg0.getSource()==jcancle)
		{
			//当点击取消按钮时，关闭登陆框，退出系统
			this.dispose();
		}
	}
	
}
 