/**
 * JComboBox/Jlist/JScorllPane
 * 下拉框组件/列表框组件/滚动条组件
 */
package com.test;
import java.awt.*;
import javax.swing.*;

public class Demo8_8 extends JFrame {

	//定义
	JPanel jp1, jp2;
	JLabel jl1, jl2;
	JComboBox jcb1;
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_8 demo=new Demo8_8();
	}
	//构造函数
	public Demo8_8()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("你的籍贯");
		jl2=new JLabel("旅游地点");
		
		String []jp={"北京","上海","天津","火星"};
		
		jcb1=new JComboBox(jp);
		
		String []dd={"九寨沟","故宫","天安门","河南","扶沟","练寺"};
		
		jlist=new JList(dd);
		jlist.setVisibleRowCount(2);   // 设置滚动条显示几条信息
		jsp=new JScrollPane(jlist);   //  把列表计入到滚动条里面
		//设置布局
		 this.setLayout(new GridLayout(3,1));   // 滚动条的布局是是网格布局
		 
		 jp1.add(jl1);
		 jp1.add(jcb1);
		 
		 
		 jp2.add(jl2);   //吧标签加入到 面板2中
		 jp2.add(jsp);   // 把滚动条加入到 面板2中
		 
		 this.add(jp1);
		 this.add(jp2);   // 把面板2 计入到  JFrame面板中
		 this.setSize(500,500);
			this.setLocation(200, 200);
			
			this.setTitle("注册新用户");
			this.setResizable(false);    // 不支持最大化
			//退出窗口退出jvm
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 退出时候关闭JVM
			
			//显示
			this.setVisible(true);
	}
}
