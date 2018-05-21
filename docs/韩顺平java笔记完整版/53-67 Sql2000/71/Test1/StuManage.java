/**
 * 完成一个迷你版本的学生管理系统
 * 可以把Stu表的操作封装在该模型中
 * 1:查询任务
 * 2：添加一个学生
 */
package Test1;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class StuManage extends JFrame implements ActionListener{
	//定义控件
	JPanel jp1, jp2;
	JLabel jl1;
	JButton jb1, jb2, jb3, jb4;
	//JScrollPane jsp;
	JTextField jtf;
	StuModel sm;
	
	//定义连接数据库操作
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuManage test=new StuManage();
	}
	//构造函数
	public StuManage()
	{
		jp1=new JPanel();
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
	    
		jl1=new JLabel("请输入名字");
		
		//把各个控件加入到jp1
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		
		
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		
		//把各个按钮加入到jp2
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		//创建一个数据模型对象
		sm=new StuModel();
		
	
		//	初始化JTable
		jt=new JTable(sm);
		
		//初始化jsp JScrollPane
		jsp=new JScrollPane(jt);
		
		//把jsp放入到 jfame
		
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断是那个按钮被按下 .jb1 和 actonperformed必须在同一个类里面
		if(arg0.getSource()==jb1)
		{
			System.out.println("用户想查询");
			//因为把表的数据封装在StuModel中了。我们就很容易完成查询
			String name=this.jtf.getText().trim();
			//写一个sql语句
		//	String sql="use spdb1; select *from stu where stuName='"+name+"'";
			//模糊查询
			String sql="use spdb1; select *from stu where stuName like '%"+name+"%'";
			//构建新的数据模型类，并更新
			sm=new StuModel(sql);
			//更新Jtable
			jt.setModel(sm);
			
			}
		//当用户点击查询
		else if(arg0.getSource()==jb2)
		{
			StuAddDialog sa=new StuAddDialog(this,"添加学生",true);
			
			//重新获得数据类型
			//构建新的数据模型类，并更新
			sm=new StuModel();
			//更新Jtable
			jt.setModel(sm);
		}
		
		//点击的是修改
		else if(arg0.getSource()==jb3)
		{
			//用户希望修改
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1)
			{
				//提示
				JOptionPane.showMessageDialog(this, "选择一行");
				return;
			}
			//显示修改对话框
			new StuUpdDialog(this,"修改学生",true, sm, rowNum);
			
			//构建新的数据模型类，并更新
			sm=new StuModel();
			//更新Jtable
			jt.setModel(sm);
		}
		
		
		//点击的是删除
		else if(arg0.getSource()==jb4)
		{
			//说明用户希望删除记录
			//得到该学生的id
			//如果该用户一行都没有选择就返回-1
			int rowNum=this.jt.getSelectedRow();
		
		if(rowNum==-1)
		{
			//提示
				JOptionPane.showMessageDialog(this, "选择一行");
				return;
		}
		//得到学生的编号
		String stuId=(String)sm.getValueAt(rowNum, 0);    //返回编号
		
	//	System.out.println("id="+stuId);
		
		//连接数据库完成删除任务
		try {
			//加载驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433; databaseName=spdb1","sa","sangliyang");
			//准备陈说语句 .注意要用  use spdb1; 否则会报 表不存
			ps=ct.prepareStatement("use spdb1;delete from stu where stuid=?");
			ps.setString(1, stuId);
			//执行查询
  			ps.executeUpdate();   
  			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			//关闭
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			//构建新的数据模型类，并更新
			sm=new StuModel();
			//更新Jtable
			jt.setModel(sm);
		}
		}
	}

}
