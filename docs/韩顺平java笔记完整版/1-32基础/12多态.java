/**
 * 功能演示：多态的演示
 * 如果子类重写了父类的方法， 
 * 如果   父类  变量=new 子类 
 *     变量.方法    // 如果这个方法子类重写了则调用子类的方法，
 *     如果没有重写则调用父类的方法
 */

package com.sangliyang;

public class Demo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Cat cat=new Cat();
		cat.cry();
		Dog dog=new Dog();
		dog.cry();   
		Animal an=new Cat();   //多态即定义一个父类的变量指向子类
		an.cry();
		an.eat();
		an=new Dog();
		an.cry();
		an.eat(); */
		Master master=new Master();
		master.feed(new Dog(), new Bone());  //多态
		master.feed(new Cat(), new Fish());
		
	}

}
class Food
{
	String name;
	public void showName()
	{
		
	}
}
class Fish extends Food
{
	public void showName()
	{
		System.out.println("鱼");
	}
}
class Bone extends Food
{
	public void showName()
	{
		System.out.println("骨头");
	}
}
//主人来
class Master
{
	//给动物喂食物
	public void feed(Animal an, Food f)
	{
		an.eat();
		f.showName();
	}
}
//动物类Animal
class Animal
{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//动物会叫
	public void cry()
	{
		System.out.println("不知道怎么叫");
	}
	public void eat()
	{
		System.out.println("我不到吃什么");
	}

}
class Dog extends Animal
{
	public void cry()
	{
		System.out.println("汪汪叫");
	}
	public void eat()
	{
		System.out.println("狗喜欢吃骨头");
	}
	
}
class Cat extends Animal
{
	public void cry()
	{
		System.out.println("喵喵叫");
	}
	public void eat()
	{
		System.out.println("猫喜欢吃鱼");
	}
}
