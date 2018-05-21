/**
 * 这是客户端和服务器端保持通讯的线程
 */
package com.qq.client.tools;
import java.io.*;
import java.net.*;
import com.qq.common.*;
import com.qq.client.tools.*;
import com.qq.client.view.*;
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
			//	System.out.println("读取到从服务器发来的消息"+m.getSender()+"给"+m.getGetter()+"内容"+m.getCon());  
				
				if(m.getMesType().equals(MessageType.message_comm_mes))   
				{
					//把从服务器得到的消息显示到该显示的界面
					QqChat qqChat=ManageQqChat.getQqChat(m.getGetter()+""+m.getSender());
					//显示
					qqChat.showMessage(m);
				}else if(m.getMesType().equals(MessageType.message_ret_onLineFriend))
				{
					System.out.println("客户端接受到"+m.getCon());
					String con=m.getCon();
					String friends[]=con.split(" ");
					String getter=m.getGetter();
					//修改相应的好友列表
					QqFriendList qqFriendList=ManageQqFriendList.getQqFriend(getter);
					
					//更新好友列表
					if(qqFriendList!=null)
					{
						qqFriendList.updateFriend(m);
					}
				}
				
				
				
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
