/**
 * 对数据库操作的类
 * 对数据库的操作 crud
 * 调用存储过程
 */
package com.mhl.db;
import java.util.*;
import java.sql.*;
public class SqlHelper {
	//定义需要的对象
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection ct=null;
	String dirverName="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	String url="jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=RestaurantDB";
	String user="sa";
	String passwd="sangliyang";
	//构造函数，初始化ct
	public SqlHelper()
	{
		try {
			//加载驱动
			Class.forName(dirverName);
			ct=DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//把数据库的曾，删，改 写一个函数
	
	public boolean exeUpdate(String sql, String []paras)
	{
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			//给sql语句中的?号赋值
			for(int i=0; i<paras.length; i++)
			{
				ps.setString(i+1,paras[i]);
			}
			ps.executeUpdate();   //更新数据
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
	//登录界面的密码
	public ResultSet query(String sql, String []paras)
	{
		try {
			ps=ct.prepareStatement(sql);
			//给sql语句中的?号赋值
			for(int i=0; i<paras.length; i++)
			{
				ps.setString(i+1,paras[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	//关闭资源的 方法
	public void close()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
