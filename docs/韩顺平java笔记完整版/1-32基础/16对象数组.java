/**
 * 功能：对象数据的使用
 * 定义一个对象数组，用于存放狗的名字和体重
 */
package com.test1;
import java.io.*;
public class Demo5_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//定义一个可以存放三只狗的对象数组
		Dog dogs[]=new Dog[3];
		//给各个狗赋初值
	/*	dogs[0]=new Dog();   必须得 new 出一个对象 使 dog[0]指向空
		dogs[0].setName("花花");
		dogs[0].setWeight(4.5f);   */
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		for(int i=0; i<3; i++)
		{
			dogs[i]=new Dog();
			System.out.println("请输第"+(i+1)+"的名字");
			String name=br.readLine();
			//将名字赋给对象
			dogs[i].setName(name);
			System.out.println("请输入第"+(i+1)+"体重");
			String s_weight=br.readLine();
			float weight=Float.parseFloat(s_weight);
			dogs[i].setWeight(weight);
			
		}
			// 计算平均体重
			float allWeight=0;
			for(int j=0; j<3; j++)
			{
				allWeight+=dogs[j].getWeight();
			}
			for(int j=0; j<3; j++)
			{
				System.out.printf("狗的名字"+dogs[j].name+"狗的体重"+dogs[j].weight);
			}
			//float avgWeight=1f;    //  这个地方不能赋初值
			float avgWeight=allWeight/dogs.length;
			System.out.println();
			System.out.println("总体重是="+allWeight+"平均体重"+avgWeight);
		}
	}

// 定义一个狗类
class Dog
{
	public String name;
	public float weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}