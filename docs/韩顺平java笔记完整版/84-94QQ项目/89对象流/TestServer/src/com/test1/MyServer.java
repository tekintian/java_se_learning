/**
 * 
 */
package com.test1;
import java.net.*;
import java.io.*;
import com.common.*;
public class MyServer  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer ms=new MyServer();
	}
	
	public MyServer()
	{
		try {
			System.out.println("在3456端口监听，，");
			ServerSocket ss=new ServerSocket(3456);
			Socket s=ss.accept();
			//以对象流的形式读取
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			User u=(User)ois.readObject();
			
			//输出
			System.out.println(u.getName()+u.getPass());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
