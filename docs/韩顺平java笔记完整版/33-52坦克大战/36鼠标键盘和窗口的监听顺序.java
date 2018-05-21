/**
 * 时间监听处理顺序
 * 1：鼠标时间处理顺序    //接口名字MouseListener
 * 、	鼠标按下了 mousePressed
		鼠标松开了 mouseReleased
		鼠标点击了 mouseClicked x=193y=154
:  2：键盘事件处理顺序       //接口名字KeyListener
		键盘按下了键keyPressed
		键盘输入了值keyTyped
		键盘按下的键已经松开keyReleased
	3：鼠标的移动和拖拽   //接口名字MouseMotionListener	
	4：窗口的最大化最小化和关闭	  //接口名字WindowListener
	
		
 */
package com.test5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo9_5 extends JFrame{

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_5 demo=new Demo9_5();
	}
    //构造函数
	public Demo9_5()
	{
		mp=new MyPanel();
		this.add(mp);
		//注册监听
//		this.addMouseListener(mp);
//		this.addKeyListener(mp);
//		this.addMouseMotionListener(mp);
		this.addWindowListener(mp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
//1：让鼠标能知道鼠标按下的消息。并且只奥点击的位置
//2：让鼠标知道那个键按下了
//3：让鼠标知道拖拽
class MyPanel extends JPanel implements WindowListener   //, MouseListener, KeyListener, MouseMotionListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
//	 //鼠标
//     //鼠标被点击
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标点击了 x="+e.getX()+"y="+e.getY());
//	}
//	//鼠标移动到MyPanel
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标来了");
//	} 
//	//鼠标离开MyPanel
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标走了");
//	}
//	//鼠标按下
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标按下了");
//	}
//	//鼠标松开
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标松开了");
//	}
//	
//	
//	//键盘
//	//键按下
//	public void keyPressed(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		System.out.println("键盘按下了键");
//	}
//	//键松开
//	public void keyReleased(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		System.out.println("键盘按下的键已经松开");
//	}
//	//键输入可输入键  这个值必须是可见的否则无法调用
//	public void keyTyped(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		System.out.println("键盘输入了值");
//	}
//	
//	
//	
//	
//	//鼠标拖动
//	public void mouseDragged(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标拖拽的当前坐标"+arg0.getX());
//	}
//	//鼠标移动
//	public void mouseMoved(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		System.out.println("鼠标当前坐标"+arg0.getX());
//	}

	
	
	
	
	
	
	//窗口激活了
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");  // 窗口被激活
	}
   //窗口关闭
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed");
	}
   //窗口正在关闭
	public void windowClosing(WindowEvent e) {   
		// TODO Auto-generated method stub
		System.out.println("windowClosing");
	}
	//窗口失去激活
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
	}
	//窗口还原
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
	}
	//窗口最小化
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");
	}
   //窗口打开
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}
}