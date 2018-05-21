package com.test3;
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
	
	
	//添加学生
	public boolean updStu(String sql, String []paras)
	{
		//创建一个 SqlHelper(如果程序的并发性不考虑可以把对象做出静态的)
		SqlHelper sqlHelper=new SqlHelper();
		return sqlHelper.updExecute(sql, paras);
}
	
	//查询的本质就是初始化
	public void queryStu(String sql, String []paras)
	{
		SqlHelper sqlHelper=null;
		//中间
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		//从数据库中取出数据
		rowData=new Vector();
		try {
			sqlHelper=new SqlHelper ();
			ResultSet rs=sqlHelper.queryExectue(sql, paras);
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
			sqlHelper.close();
		}
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
