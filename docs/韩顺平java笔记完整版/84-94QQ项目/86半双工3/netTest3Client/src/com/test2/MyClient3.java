/**
 * 服务器端
 * 
 */
package com.test2;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class MyClient3 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp1=null;
	PrintWriter pw=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient3 ms=new MyClient3();
	}
	
	public MyClient3()
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
		this.setTitle("qq简易聊天，客户端");
		this.setSize(300,200);
		this.setVisible(true);
		
		try {
			Socket s=new Socket("127.0.0.1", 9999);
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			pw=new PrintWriter(s.getOutputStream(), true);
			while(true)
			{
				//不停的读从服务器发来的信息
				String info=br.readLine();
				jta.append("服务器对客户端说"+info+"\r\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	if(arg0.getSource()==jb)
			
		{
			//把服务器jtf写的内容发送给客户端
			String info=jtf.getText();
			//把客户发送的信息显示到jta
			jta.append("客户端对服务器端说"+info+"\r\n");
			
			pw.println(info);
			
			//清空发送框的内容
			jtf.setText("");
		}
	}

}
