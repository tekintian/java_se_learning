/**
 * 功能：是一个服务器端， 在9999端口上监听
 * 可以通过控制台，输送个客户端的信息
 */
package com.test1;
import java.net.*;
import java.io.*;
public class MyServer2 {

	public static void main(String[] args)
	{
		MyServer2 ms2=new MyServer2();
	}
	public MyServer2()
	{
		try {
			//在9999端口上监听
			System.out.println("服务器在9999监听。。。。");
			ServerSocket ss=new ServerSocket(9999);
			//等待连接
			Socket s=ss.accept();
			//先接受客户端发来的信息
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			//向连接中写东西
			PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
			
			//接收从控制台输入的信息
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				String infoFromClient=br.readLine();
				System.out.println("客户发来"+infoFromClient);
				
				if(infoFromClient.equals("bye"))
				{
					System.out.println("退出");
					s.close();
					break;
				}
				
				//接手从控制多台输送的信息
				System.out.println("请输入你希望对客户端说的话");
				String response=br2.readLine();
				//把从控制台接受的信息会送到客户端
				pw.println(response);
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
