/**
 * 功能: QQ登录界面
 */
package com.qq.client.view;
import java.awt.*;
import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.*;
import java.awt.event.*;
public class QqClientLogin extends JFrame implements ActionListener {

	//定义北边所需要的组件
	JLabel jbl1;
	//定义中部需要的组件
	//中部有三个JPanel，有一个选项卡窗口
	JTabbedPane jtp;
	JPanel jp2, jp3, jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4; 
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1, jp2_jcb2;
	//定义南部所需要的组件
	JPanel jp1;
	JButton jp1_jb1, jp1_jb2, jp1_jb3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub.e
		QqClientLogin qqClientLogin=new QqClientLogin();
	}
	
	public QqClientLogin()
	{
		//处理北部
		jbl1=new JLabel(new ImageIcon("image/tou.gif"));
		
		//处理中部
		jp2=new JPanel(new GridLayout(3,3));
		
		jp2_jbl1=new JLabel("QQ号码",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ密码",JLabel.CENTER);
		jp2_jbl3=new JLabel("忘记密码",JLabel.CENTER);
		jp2_jbl3.setForeground(Color.blue);
		jp2_jbl4=new JLabel("申请密码保护",JLabel.CENTER);
		jp2_jb1=new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		jp2_jcb1=new JCheckBox("隐身登录");
		jp2_jcb2=new JCheckBox("记住密码");
		
		//把空间按照顺序加入到jp2中
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		
		//创建选项卡窗口
		jtp=new JTabbedPane();
		jtp.add("QQ号码",jp2);
		jp3=new JPanel();
		jtp.add("手机号码",jp3);
		jp4=new JPanel();
		jtp.add("电子邮件",jp4);
		
		
		//处理南部
		jp1=new JPanel();
		jp1_jb1=new JButton(new ImageIcon("image/denglu.gif"));
		//响应用户点击登录
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		jp1_jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		
		//把三个按钮放到jp1中
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		this.add(jbl1, "North");
		this.add(jtp, "Center");
		//把jp1放到南部
		this.add(jp1,"South");
		this.setIconImage((new ImageIcon("image/qqdfsdf.gif").getImage()));
		this.setSize(350,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//如果用户点击登录
		if(arg0.getSource()==jp1_jb1)
		{
			QqClientUser qqClientUser=new QqClientUser();
			User u=new User();
			u.setUserId(jp2_jtf.getText().trim());  //trim是出去开始或结尾的空格
			u.setPasswd(new String(jp2_jpf.getPassword()));
			
			if(qqClientUser.checkUser(u))
			{
				new QqFriendList(u.getUserId());
				//关闭掉登录界面
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "用户名密码错误");
			}
		}
	}

}
