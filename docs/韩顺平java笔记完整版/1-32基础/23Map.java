/**
 * LinkdeList 的功能：
 * addFirst 将指定元素插入此列表的开头
 * addLast将指定元素添加到此列表的结尾
 * HashMap的功能
 * put 方法：在此映射中关联指定值与指定键。注意键值不能重复 ，重复的话就会被覆盖掉，在用键显示的是覆盖的信息
 * containsKey方法：如果此映射包含对于指定键的映射关系，则返回 true。
 * 
 * HashMap和Hashtable的区别
 * Hashtable是同步，保证线程的安全，键值不允许为空
 * HashMap单线程比较安全效率高，允许为空值
 */
package com.test2;
import java.util.*;
public class Demo7_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	// TODO Auto-generated method stub
	 * 
	 * 
	 *   //LinkList 
		LinkedList ll=new LinkedList();
		Emp emp1=new Emp("sa01","aa", 1.2f);
		Emp emp2=new Emp("sa01","bb", 1.2f);
		//表示把emp1加在链表的最前面
		ll.addLast(emp1);
		ll.addFirst(emp2);
		for(int i=0; i<ll.size(); i++)
		{a
			System.out.println(((Emp)ll.get(i)).getName());
		}    */
		// Vector的用法
	/*	Vector vv=new Vector();
		Emp emp1=new Emp("sa01","aa", 1.2f);
		vv.add(emp1);
		for(int i=0; i<vv.size(); i++)
		{
			Emp emp=(Emp)vv.get(i);
		}  */
	//	Stack stack=new Stack();
	//	stack.
		
		
		
		
		
/*		//创建一个HashMap 对象
		HashMap hm=new HashMap();
		
		Emp emp1=new Emp("s001","aaa", 3.5f);
		Emp emp2=new Emp("s002","老桑", 3.5f);
		Emp emp3=new Emp("s003","老王", 3.5f);
		
		//将emp放到hm中
		hm.put("s001", emp1);
		hm.put("s002", emp2);
		hm.put("s003", emp3);   // 注意键值不能重复 这时候s002表示老王了
   		if(hm.containsKey("s002"))
		{
			System.out.println("有该员工");
			//如何去除键值
			Emp emp=(Emp)hm.get("s002");
			System.out.println("名字："+emp.getName());
		}
		else
		{
			System.out.println("没有该员工");
		}  
		//遍历HashMap中所有的key和value   去除的值没有顺序
		Iterator it=hm.keySet().iterator();
		// hasNext返回一个boolean
		while(it.hasNext())
		{
			String key=it.next().toString();
			//通过key去除vale
			Emp emp=(Emp)hm.get(key);
			System.out.println("名字"+emp.getName());
			System.out.println("薪水："+emp.getSal());
		}   */
		
		//演示HashTable
		Hashtable ht=new Hashtable();
		
	}
	

}
