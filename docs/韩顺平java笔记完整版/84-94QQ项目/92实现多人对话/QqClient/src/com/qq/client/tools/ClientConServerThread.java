/**
 * 这是客户端和服务器端保持通讯的线程
 */
package com.qq.client.tools;
import java.io.*;
import java.net.*;
import com.qq.common.*;
import com.qq.client.tools.*;
public class ClientConServerThread extends Thread{

	private Socket s;
	
	public ClientConServerThread(Socket s)
	{
		this.s=s;
		
	}
	public void run()
	{
		while(true)
		{
			//不停的读取从服务器端发来的信息
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				System.out.println("读取到从服务器发来的消息"+m.getSender()+"给"+m.getGetter()+"内容"+m.getCon());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
}
