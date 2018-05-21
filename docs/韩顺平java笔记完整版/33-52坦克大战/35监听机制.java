/**
 * 功能：监听处理机制
 * 1：注册监听  即：给要被监听对象指定一个监听者 例如：jb1.addActionListener(myCat1);  //  myCat1监听 jb1
 * 2:被监听者发特定的字符消息   jb1.setActionCommand("aa"); 
 * 3：监听对象 接收 被监听的对象所发出消息   
 * 4：监听者可以监听对个对象，，被监听对象也可以被多个对象监听
 * 
 * 注意：监听者属于的类必须实现 ActionListener 类  并且实现 actionPerformed 方法在 actionPerformed 方法中用if else语句对所监听对象发出的不同消息做不同的处理
 */
package com.test3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo9_3 extends JFrame implements ActionListener{

	//定义一个panel
	JPanel mp=null;
	JButton jb1=null;
	JButton jb2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_3 demo=new Demo9_3();
		Demo9_3 demo1=new Demo9_3();
		Demo9_3 demo3=new Demo9_3();
	}
	public Demo9_3()
	{
		mp=new JPanel();
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		
		this.add(jb1, BorderLayout.NORTH);
		mp.setBackground(Color.black);
		this.add(mp);
		this.add(jb2, BorderLayout.SOUTH);
		
		Cat myCat1=new Cat();
		
		jb1.addActionListener(myCat1);
		jb2.addActionListener(myCat1);
		
		//注册监听
		jb1.addActionListener(this);
		//指定action命令
		jb1.setActionCommand("aa");   // 被监听者发出的字符信息
		
		jb2.addActionListener(this);   //  表示Demo9_3  所创建的所有对象都监听此对象
		jb2.setActionCommand("bb");
		
		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	//对事件处理的方法
	public void actionPerformed(ActionEvent e) {
		
		//判断是那个按钮被点击
		if(e.getActionCommand().equals("aa"))  // 如果监听到的对象发出的字符信息是 aa
		{
			System.out.println("你点下黑色按钮了");
			mp.setBackground(Color.black);
		}
		else if(e.getActionCommand().equals("bb"))
		{
			System.out.println("你点击红色了");
			mp.setBackground(Color.red);
		}
	}

}
class Cat implements ActionListener
{
	public void actionPerformed(ActionEvent arg0)   //这个方法必须实现  ActionEvent 是监听鼠标单击事件
	{
		if(arg0.getActionCommand().equals("aa"))
		{
			System.out.println("猫也知道你按下黑色按钮了");
		}
		   else
			if(arg0.getActionCommand().equals("bb"))
		{
			System.out.println("猫也知道你按下红色按钮了");
		}
	}
}
/*class MyPanel extends JPanel
{
	public void paint(Graphics g)
	{
		super.print(g);
		g.fillRect(0, 0, 200, arg3)
	}
} */
