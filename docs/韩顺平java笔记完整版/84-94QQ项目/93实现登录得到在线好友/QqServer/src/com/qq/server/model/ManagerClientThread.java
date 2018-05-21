
package com.qq.server.model;
import java.util.*;
public class ManagerClientThread  {

	public static HashMap hm=new HashMap<String, SerConClientThread>();
	
	public static void addClientThread(String uid, SerConClientThread ct)
	//向hm中添加一个客户端通讯线程
	{
		hm.put(uid, ct);
	}
	public static SerConClientThread getClientThread(String uid)
	{
		return (SerConClientThread)hm.get(uid);
	}
	
	//返回当前在线人的情况
	public static String getAllOnLineUserid()
	{
		//使用迭代器完成
		Iterator it=hm.keySet().iterator();
		String res="";
		while(it.hasNext())
		{
			res+=it.next().toString()+" ";
		}
		return res;
	}
}
