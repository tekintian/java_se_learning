/*
		类定义中的引用对象， 定义类的时候可以定义的两个对象可以引用同一个引用对象，改变一个对象的引用变量中的变量可以也就改变了另外一个
		变量中引用的变量看10到16行代码
*/
import java.io.*;
public class A
{
	public static void main (String [] args)
	{
		Dog dog1= new Dog(2, "大黄");
		Person p1=new Person(dog1,23, "桑立阳");
		Person p2=new Person(dog1, 25,"胡锦涛");
		p1.showInfo();
		p1.dog.showInfo();
		p1.dog.changeName("老唐");  // 把桑立阳的狗的名字改为老唐
	    p1.dog.showInfo();
	}
}
class Person 
{
	int age;
	String name;
	Dog dog;
	public Person (Dog dog, int age, String name)
	{
		this.age=age;
		this.name=name;
		this.dog=dog;
	}
	public void showInfo()
	{
		System.out.println("人名是；"+this.name);
	}
}
class Dog
{
	private int age;
	public String name;
	public Dog(int age, String name)
	{
		this.age=age;
		this.name=name;
	}
	public void changeName(String name)
	{
		this.name=name;
	}
	public void showInfo()
	{
		 System.out.println("狗名叫"+this.name);
	}

}