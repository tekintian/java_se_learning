/**
 * 功能：接口的讲解
 * 注意 Computer 类
 * 1：接口不能有实例化对象
 * 2：接口中的方法不能有方法体
 * 3: 如果类实现了接口，则必须把接口中的方法全部实现
 * 4：接口中的变量不能用Public private 等修饰，变量本质上都是静态的
 *    不管加不加staitc 关键字 必须是 fanl 常量 可以用：
 *                      接口名.变量名
 *    的方式访问接口中的变量
 * 5: 接口不能继承普通类， 但可以继承接口，如果有有类实现
 *    这个接口必须实现接口继承他的父类的方法
 */
package com.test3;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer=new Computer();
		Camera camera1=new Camera();
		Phone phone1=new Phone();
		computer.useUsb(camera1);  // useUsb方法中的参数变量是多态
		computer.useUsb(phone1);
	}

}
// 定义一个接口
interface Usb{
	int a=1;
	public void start();
	public void stop();
}
//编写了照相机类，并且实现了usb接口一个
//实现该类的话应该吧这个接口全部实现不然就会报错
class Camera implements Usb
{
	public void start()
	{
		System.out.println("我是相机，开始工作！！");
	}
	public void stop()
	{
		System.out.println("我是相机，停止工作！！");
	}
	
}
//编写手机类
class Phone implements Usb
{
	public void start()
	{
		System.out.println("我是手机，开始工作！！");
	}
	public void stop()
	{
		System.out.println("我是手机，停止工作！！");
	}
	
}
class Computer
{
	public void useUsb(Usb usb)  // 多态的体现
	{
		usb.start();
		usb.stop();
	}
}
