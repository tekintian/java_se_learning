/*
 * 这是用户表数据模型，用它以完成对用户的各种操作，这是主要编写项目需要的业务操作
 * */
package com.mhl.model;
import java.sql.*;

import sun.java2d.pipe.SpanClipRenderer;

import com.mhl.db.*;
public class UserModel {
	/**
	 * 
	 * @param cleId 用户编号
	 * @param passwd 用户密码
	 * @return 用户的职位，如果该用户不存在，则返回空
	 */
	public String checkUser(String cleId,String passwd)
	{
		String zhiwei="";
		SqlHelper sh=null;
		try {
			
			//组织sql语句和参数列表，为防止注入漏洞，采取?赋值方式(paras[])
			//下面这两个sql语句由于太长，均使用连接符换行连接，但两个有区别，第二个是错的，原因是cleId" +中的引号
			//关缺少空格，正确是：cleId " +，这一个错误，让我调试了一个多小时，才检查出来的，稍微不注意很恐怖的
//			String sql="select cleZw from clerkInfo c,login l where c.cleId=l.cleId " +
//					"and l.cleId=? and l.passwd=?";
//			String sql="select cleZw from clerkInfo c,login l where c.cleId=l.cleId" +
//			"and l.cleId=? and l.passwd=?";
			
			String sql="select cleZw from clerkInfo c,login l where c.cleId=l.cleId " +
			"and l.cleId=? and l.passwd=?";
			String paras[]={cleId,passwd};
			sh=new SqlHelper();
			//从SqlHelper类中得到数据库的结果集
			ResultSet rs=sh.query(sql, paras);
			if(rs.next())
			{
				//如果进去，则取出职位
				zhiwei=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally 
		{
			sh.close();
		}
		return zhiwei;
	}

}
