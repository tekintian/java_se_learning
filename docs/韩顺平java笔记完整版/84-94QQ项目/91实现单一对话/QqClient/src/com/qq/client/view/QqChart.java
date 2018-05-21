/**
 * 这是与好友聊天的界面
 * 因为客户端要处于读取的状态，因此我们把它做成一个线程
 */
package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;
import com.qq.common.*;
import javax.swing.*;
import com.qq.client.model.*;
import java.io.*;
public class QqChart extends JFrame implements ActionListener, Runnable {

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String ownerId;
	String friendId;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	QqChart QQ=new QqChart("1");
	}

	public 	QqChart(String ownerId,String friend)
	{
		this.ownerId=ownerId;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		//设置窗口的图标
		this.setTitle(ownerId+"你正在和"+friend+"聊天");
		this.setIconImage((new ImageIcon("image/qq.gif").getImage()));
		this.setSize(300,200);
		this.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb)
		{
			//如果用户点击了发送
			Message m=new Message();
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			//发送给服务器
			try {
				ObjectOutputStream oos=new ObjectOutputStream(QqClientConServer.s.getOutputStream());
				oos.writeObject(m);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				//如果没有信息读取就等待
				ObjectInputStream ois=new ObjectInputStream(QqClientConServer.s.getInputStream());
				Message m=(Message)ois.readObject();
				//显示在文本域
				
				String info=m.getSender()+"对"+m.getGetter()+m.getCon()+"\r\n";
				this.jta.append(info); // 追加到文本框中
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//读取
			
		}
	}
}
