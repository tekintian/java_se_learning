/*
 * 这是一个可以动态加载一个图片做背景的JPanel
 * 
 * */
package com.mhl.mytools;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
public class ImagePanel extends JPanel{
	//定义组件
	Image im;
	//构造函数去指定该JPanel的大小
	public ImagePanel(Image im)
	{
		this.im=im;//此处的this不能少，否则不能画出图片
		//希望它大小是自我调整的
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
	}
	//画出背景
	public void paintComponent(Graphics g)
	{
		//清屏
		super.paintComponent(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}
