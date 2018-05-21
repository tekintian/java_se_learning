/**
 *用于显示认识管理的界面 
 */
package com.myl.view;
import java.awt.*;
import javax.swing.*;
import com.mhl.model.*;
import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;

import java.awt.Event;
public class EmpInfo extends JPanel {
	
	//定义需要的各个组件
	JPanel p1, p2, p3, p4, p5;
	JLabel p1_lab1, p3_lab1;
	JTextField p1_jtf1;
	JButton p1_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;
	//用于显示人事信息的table
	JTable jtable;  
	JScrollPane jsp;   //滚动的面板
	//构造函数
	public EmpInfo()
	{
		//创建需要的组件
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1=new JLabel("请输入姓名(员工号或职位)"); p1_lab1.setFont(MyTools.f2);
		p1_jtf1=new JTextField(20);
		p1_jb1=new JButton("查询"); p1_jb1.setFont(MyTools.f3);
		//把他们加入到p1
		p1.add(p1_lab1);
		p1.add(p1_jtf1);
		p1.add(p1_jb1);
		
		
		//处理中间
		EmpModel em=new EmpModel();
		String []paras={"1"};
		em.query("use RestaurantDB; select cleId  , cleSex, cleZw from clerkInfo where 1=?", paras);
		jtable=new JTable(em);
		p2=new JPanel(new BorderLayout());
		jsp=new JScrollPane(jtable);
		p2.add(jsp);
		
		
		//处理南边的
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_lab1=new JLabel("总记录数是**条");
		p3_lab1.setFont(MyTools.f3);
		p3.add(p3_lab1);
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1=new JButton("详细信息");
		p4_jb1.setFont(MyTools.f3);
		p4_jb2=new JButton("添加");
		p4_jb2.setFont(MyTools.f3);
		p4_jb3=new JButton("修改");
		p4_jb3.setFont(MyTools.f3);
		p4_jb4=new JButton("删除");
		p4_jb4.setFont(MyTools.f3);
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		p5=new JPanel(new BorderLayout());
		
		p5.add(p3,"West");
		
		p5.add(p4,"South");
		
		//把总的JPanel设置为BorderLayout
		this.setLayout(new BorderLayout());
		
		//把p1加入到JPanel
		this.add(p1,"North");
		this.add(p2,"Center");
		this.add(p5, "South");
		// 设置背景颜色
	//	this.setBackground(Color.pink);
		this.setVisible(true);
	}
}
