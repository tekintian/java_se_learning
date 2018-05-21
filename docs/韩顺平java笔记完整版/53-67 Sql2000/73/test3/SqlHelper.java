package com.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {

	//定义连接数据库操作
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	String url="jdbc:microsoft:sqlserver://127.0.0.1:1433; databaseName=spdb1";
	String user="sa";
	String passwd="sangliyang";
	String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	
	
	//关闭数据库资源
	public void close()
	{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ResultSet quereyExecute(String sql)
	{
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			ct=DriverManager.getConnection(url, user, passwd);
			//创建ps
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			
		}
		return rs;
	}
	
	//查询数据库
	public ResultSet queryExectue(String sql, String []paras)
	{
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
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			
		}
		return rs;
	}
	
	//把增删改和在一起  操作数据库
	public boolean updExecute(String sql, String []paras)
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
			this.close();
		}
		return b;
		
	}
}
