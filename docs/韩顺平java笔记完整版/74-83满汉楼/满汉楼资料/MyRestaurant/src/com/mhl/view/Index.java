/*
 * 功能：实现闪屏界面
 * 日期：2010.10.11
 * */
package com.mhl.view;
import java.awt.*;
import javax.swing.*;
public class Index extends JWindow implements Runnable{
	//定义与进度条相关的组件
	JProgressBar jpb;//定义进度条
	JLabel jl1;//用于在窗体的北部放一张图片，南部是进度条
	int width,height;//用于获取显示屏分辨率大小
	public static void main(String []args){
		Index index=new Index();
		//创建index线程
		Thread t=new Thread(index);
		//启动线程
		t.start();
	}
	//构造函数
	public Index()
	{	
		//创建标签,并在标签上放置一张图片
		jl1=new JLabel(new ImageIcon("image/index/index.gif"));
		
		//创建进度条
		jpb=new JProgressBar();
		//设置进度条属性
		jpb.setStringPainted(true);//显示当前进度值信息
		jpb.setIndeterminate(false);//确定进度条执行完成后不来回滚动
		jpb.setBorderPainted(false);//设置进度条边框不显示
		jpb.setBackground(Color.darkGray);//设置进度条的背景色
		
		//添加组件
		this.add(jl1,BorderLayout.NORTH);
		this.add(jpb,BorderLayout.SOUTH);
		
		//设置窗体属性
		this.setSize(400,263);
		//设置窗体显示的位置
		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		//设置窗口显示
		this.setVisible(true);
	}
	//进度条线程的run方法，用于设置线程的属性
	public void run() {

		//定义一个数组，存放进度条显示时需要的数据
		int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++)
		{
			try {
				//休眠1秒，再执行
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);//取得数组中的进度值
		}
		//当进度完成后，执行相应的操作，如切换到其他的窗口，同时关闭进度条窗口等
		new Login();
		//关闭进度条窗口
		this.dispose();
	}
}