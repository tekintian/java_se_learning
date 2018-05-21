/**
 * 这个是客户端连服务器的后台
 */
package com.qq.client.model;
import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.client.tools.*;
import com.qq.common.Message;
import com.qq.client.model.*;
import com.qq.common.*;
public class QqClientConServer {

	public  Socket s;
	//发送第一次请求
	public boolean sendLoginInfoToServer(Object o)
	{
		boolean b=false;
		try {
			System.out.println("kkk");
			s=new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//这里就是验证用户登录的地方
			if(ms.getMesType().equals("1"))
			{
				//创建一个该qq号和服务器端保持通讯连接的线程
				ClientConServerThread ccst=new ClientConServerThread(s);
				//启东该线程
				ManageClientConServerThread.addClientConServerThread(((User)o).getUserId(), ccst);
				ccst.start();
				b=true;
			}else{
				//关闭
				s.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
				
		}
		return b;
	}
	
	
	public void SendInfoToServer(Object o)
	{
		try {
			Socket s=new Socket("127.0.0.1", 9999);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
				
		}
	}
}
