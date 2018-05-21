/**
 * 这是qq服务器，它在监听等待某个qq客户端来连接
 */
package com.qq.server.model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import com.qq.common.*;
public class MyQqServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public MyQqServer()
	{
		try {
			//在999号端口监听
			System.out.println("我是服务器在999监听、、");
			ServerSocket ss=new ServerSocket (9999);
			//阻塞,等待客户端的连接
			while(true)
			{
				Socket s=ss.accept();
				
				//接收客户端发来的信息
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("服务器接收到id: "+u.getUserId()+"和密码："+u.getPasswd());
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123"))
				{
					//返回一个成功的登录信息	
					m.setMesType("1");
					oos.writeObject(m);
				
					//这里单开一个线程让该线程，与客户端保持通讯
					SerConClientThread scct=new SerConClientThread(s);
					ManagerClientThread.addClientThread(u.getUserId(), scct);
					//启东与该客户端通讯的线程
					scct.start();
				}else{
					m.setMesType("2");
					oos.writeObject(m);
					//关闭连接
					s.close();
				}
			
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{		
			
		}
	}
}
