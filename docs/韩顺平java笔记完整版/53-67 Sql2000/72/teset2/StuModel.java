package com.teset2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;
public class StuModel extends AbstractTableModel{

	//rowData用来存放行数据
	//columnNames存放列名
	Vector rowData, columnNames;
	
	//定义连接数据库操作
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	String url="jdbc:microsoft:sqlserver://127.0.0.1:1433; databaseName=spdb1";
	String user="sa";
	String passwd="sangliyang";
	String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	
	//添加学生
	public boolean updStu(String sql, String []paras)
	{
		boolean b=true;
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			ct=DriverManager.getConnection(url, user, passwd);
			//创建ps
			ps=ct.prepareStatement(sql);
			//给sql语句中的?号赋值
			for(int i=0; i<paras.length; i++)
			{
				ps.setString(i+1, paras[i]);
			}
			//4执行操作
			// 不能在出现ps.executeUpdate()否则会报违反主键约束
			if(ps.executeUpdate()!=1)  // 执行sql语句
			{
				b=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(ct!=null)
				{
					ct.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
		}
			
	}
		return b;
}
	
	
	
	
	public void init(String sql)
	{
		if(sql.equals(""))
		{
			sql="use spdb1; select *from stu";
		}
		//中间
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData=new Vector();
		//从数据库中取出数据
		rowData=new Vector();
		try {
			//加载驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433; databaseName=spdb1","sa","sangliyang");
			//准备陈说语句 .注意要用  use spdb1; 否则会报 表不存
			ps=ct.prepareStatement(sql);	
			//执行查询
  			 rs=ps.executeQuery();      
  			 // 返回查询结果
			while(rs.next())
			{
				//rowData
				Vector hang=new Vector();
				
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				//加入到rowData
				rowData.add(hang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(ct!=null)
				{
					ct.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	//通过传递的sql语句来获得数据模型
	public StuModel(String sql)
	{
		this.init(sql);
	}
	//做一个构造函数初始化数据模型
	public StuModel()
	{
		this.init("");
	}
	
	//得到共有多少列
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	//	return 0;
	}
	//得到共有多少行
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
		//return 0;
	}
	//得到某行某列的数据
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector) this.rowData.get(arg0)).get(arg1);    // arg0表示行 arg1 表示列
	//	return null;
	}

	//重写方法 getColumnName
	@Override  
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

}
