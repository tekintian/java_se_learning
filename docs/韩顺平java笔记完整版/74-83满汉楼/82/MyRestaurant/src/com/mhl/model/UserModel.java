/**
 * 这是用户表数据模型，用它完成对用户的各种操作[这里主要用于业务操作]
 */
package com.mhl.model;
import com.mhl.db.*;
import java.sql.*;
public class UserModel  {
	
	/**
	 * 
	 * @param uid  用户编号
	 * @param p   用户密码	
	 * @return	该用户的职位  如果该用户不存在则返回空
	 */
	
	public String  checkUser(String uid, String p)
	{
		String zhiwei="";
		SqlHelper sp=null;
		try {
			//组织sql语句和参数列表
			String sql="use RestaurantDB; select clerkInfo.cleZw  from  login, clerkInfo  where login.cleId=clerkInfo.cleId and login.cleId=?  and  login.passwd=?";
			String paras[]={uid, p};
			sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			if(rs.next())
			{
				//取出职位
				zhiwei=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			sp.close();
		}
		return zhiwei;
	}
	
}
