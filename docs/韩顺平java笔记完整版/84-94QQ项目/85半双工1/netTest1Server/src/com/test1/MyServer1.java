/**
 * 这是第一个服务器端程序，让它9999端口监听
 * 可以接收从客户端发来的信息
 */
package com.test1;
import java.net.*;
import java.io.*;
public class MyServer1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer1 msl=new MyServer1();
	}
	public MyServer1()
	{
		try {
			//在9999号端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器，我正在监听");
			//等待摸个客户来连接，该函数会返回一个Scokey连接
			Socket s=ss.accept();
			
			//要读取s中传递的数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader (isr);
			//行读取
			String info=br.readLine();
			
			System.out.println("服务器已经收到，"+info);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
			
			pw.println("你好吗，我是服务器");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
