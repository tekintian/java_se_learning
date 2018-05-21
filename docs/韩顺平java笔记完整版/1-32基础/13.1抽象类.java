/**
 * 抽象类的必要性
 * 1：抽象类可以没有抽象方法，抽象方法不能有方法体
 *:2：抽象方法不能实例化对象
 */
package com.test2;

public class Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//这就是一个抽象类
abstract class Animal   // 必须要有 abstract 关键字 可以没有 abstract
{
	String name;
	int age;
	//动物会叫
	abstract public void cry();  //这个方法不能有方法体
}
class Cat extends Animal
{
	//实现父类的cry()
	public void cry()
	{
		// do nothing..... 也可以
		System.out.println("猫猫叫");
	}
}