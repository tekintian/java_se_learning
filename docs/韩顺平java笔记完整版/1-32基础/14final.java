/**
 * final 方法的使用
 * 1: 如果final 在变量前面这个变量必须赋初值，继承这个变量的话这个变量的值不能变，但是可以重新定义一个同名的变量且这个变量的
 *    可以不是final类型，详细看 Aaa类中的 rate 变量被 Bbb继承之后rate变量的变化
 * 2：如果final 在类方法中表示这个方法被继承之后不能被改写， 不能重新定义这个方法
 * 3：把类定义成final 表示这个类不能被继承，断子绝孙了，，呵呵 
 */

package com.test4;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbb  bb=new Bbb();
		bb.show();	
	}

}
class Aaa  // 如果这个时候加一个final 表示这个类就不能被继承了
{
	int a;   // 这个时候 a的默认情况是 0
	final float rate=3.1415f;  // 继承他的类还可以重新定义 rate 并且可以不是final 但是如果不重新定义rate则rate的值不能变
     public void sendMes()   // 如果用final表示这个方法说明不能被他的子类继承
	{
		System.out.println("发送消息");
	}
    public void show()
    {
    	System.out.println("a");
    }
}
class Bbb extends Aaa
{
	//int rate=3;   可以重新第一一个rate
	public Bbb()
	{
		a++;
	//	rate=rate+2;
	}
  	public void sendMes()
	{
		System.out.println();
	}  // 错误因为父类已经把这个方法定义为final 方法
  	public void show()
  	{
  		System.out.println(rate);
  	}
}
interface Fish
{
	//该方法实现.....
	public void swimming();
}
interface Bird
{
	public void fly();
}
class Monkey
{
	int name;
	public void jump()
	{
		System.out.println("猴子会跳");
	}
}
class LittleMokey  extends Monkey implements Fish, Bird
{

	public void swimming() {
		// TODO Auto-generated method stub
		
	}

	public void fly() {
		// TODO Auto-generated method stub
		
	}
	
}
