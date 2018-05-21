/**
 * 定义包的总类
 */
package com.qq.common;

public interface MessageType {

	String message_succeed="1";  //表明登录成功
	String message_login_fail="2"; //表明登录失败
	String message_comm_mes="3"; //普通包信息
	String message_get_onLineFriend="4";//表示在线好友
	String message_ret_onLineFriend="5";//返回在先好友
}
