/**
 * 这是一个客户端程序，可以连接服务器端
 */
package com.test;
import java.net.*;
import java.io.*;
public class MyClient1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient1 mcl=new MyClient1();
	}
	public MyClient1()
	{
		try {
			//Socket,就是连接某个服务器端，127.0.0.1表示服务器的Ip  9999表示端口号
			Socket s=new Socket("127.0.0.1", 9999);
			
			//如果s连接成功， 就可以发数据给服务器
			//我们通过pw 向s写数据  true表示刷新流
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			pw.println("你好吗？我是客户端");
			
			
			
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader (isr);
			//行读取
			String response=br.readLine();
			
			System.out.println("客户端已经收到，"+response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
