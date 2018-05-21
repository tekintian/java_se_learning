/**
 * 演示如何通过继承Thread来开发线程
 * 1：需要线程的类继承 Thread 类 必须实现 Thread　　类中的run()方法
 * 2：调用Thread类中的 start() 方法来启动一个线程  这个线程自动调用 run方法
 */
package com.test1;

public class Demmo10_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		//启东线程
		cat.start();    //会导致run函数的运行
	}

}
class Cat extends Thread
{
	int times=0;
	//重写run 函数
	public void run()
	{
		while(true)
		{	//休眠一秒   以毫秒为单位
			try {
				// sleep就会让线程进入到阻塞状态，并释放资源
				Thread.sleep(1000);    //这个线程会自动休息一秒休息过后 线程会自动运行
			} catch (Exception e) {
				// TODO: handle exception
			}
			times++;
			System.out.println("hello,word"+times);
			if(times==10)
			{
				break;
			}
		}
	}
}