package com.test2;
import java.util.*;
import java.io.*;
public class Demo7_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//创建一个EmpManage对象
		EmpManage em=new EmpManage();
		//做出一个简单的菜单
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("请选择一个操作:");
			System.out.println("1:表示添加一个雇员");
			System.out.println("2：雇员查找一个:");
			System.out.println("3:修改一个雇员");
			System.out.println("4：删除一个雇员");
			System.out.println("5：退出");
			String operType=br.readLine();
			if(operType.equals("1"))
			{
				System.out.println("请输入编号");
				String empNo=br.readLine();
				System.out.println("请输入名字");
				String name=br.readLine();
				System.out.println("请输入工资");
				float sal=Float.parseFloat(br.readLine());
				Emp emp=new Emp(empNo,name,sal);
				em.addEmp(emp);
			}
			else if(operType.equals("2"))
			{
				System.out.println("请输入编号");
				String empNo=br.readLine();
				em.showInfo(empNo);
			}
			else if(operType.equals("3"))
			{
				
			}
			else if(operType.equals("5"))
			{
				//退出
				System.exit(0);
			}
				
		}
		
	}
	}


//雇员管理类
class EmpManage
{
	private ArrayList al=null;
	public EmpManage()
	{
		al=new ArrayList();
	}
	//加入员工
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	//显示员工的相关信息
	public void showInfo(String empNo)
	{
		//遍历整个ArrayList()
		for (int i=0; i<al.size(); i++)
		{
			//去除Emp对象
			Emp emp=(Emp)al.get(i);
			//比较编号
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.println("找到员工，他的信息是：");
				System.out.println("编号是"+empNo);
				System.out.println("名字是"+emp.getName());
				System.out.println("工资是"+emp.getSal());
				
			}
		}
	}
	
	//修改工资
	public void updateSal(String empNo,float newSal)
	{
		for(int i=0; i<al.size(); i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				emp.setSal(newSal);
			}
		}
	}
	public void delEmp(String empNo)
	{
		for(int i=0; i<al.size(); i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				al.remove(i);
			}
		}
	}
}
//雇员类
class Emp
{
	//学号
	private String empNo;
	private String name;
	private float sal;
	//构造函数
	public Emp(String empNo, String name,float sal)
	{
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	
}