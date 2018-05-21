/**
 * 服务器端
 * 
 */
package com.test1;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.awt.event.*;
public class MyServer3 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp1=null;
	//把信息发给客户端的对象
	PrintWriter pw=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer3 ms=new MyServer3();
	}
	
	public MyServer3()
	{
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jtf=new JTextField(10);
		jb=new JButton("发送");
		jb.addActionListener(this);
		
		jp1=new JPanel();
		jp1.add(jtf);
		jp1.add(jb);
		this.add(jsp,"Center");
		this.add(jp1, "South");
		this.setTitle("qq简易聊天,服务器端");
		this.setSize(300,200);
		this.setVisible(true);
		
		//服务器监听
		try {
			ServerSocket ss=new ServerSocket(9999);
			//等待客户的连接
			Socket s=ss.accept();
			
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			pw=new PrintWriter(s.getOutputStream(), true);
			//从客户端来读取信息
			while(true)
			{
				//读取从客户端发来的信息
				String info=br.readLine();
				jta.append("客户对服务器说   "+info+"\r\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	;
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//如果按下了发送按钮
		if(arg0.getSource()==jb)
			
		{
			//把服务器jtf写的内容发送给客户端
			String info=jtf.getText();
			
			jta.append("服务器对客户端说： "+info+"\r\n");
			pw.println(info);
			
			//清空发送框的内容
			jtf.setText("");
		}
	}

}
