/**
 * 功能演示各种排序法
 * 1：冒泡排序 Bubble
 * 2:快速排序 Select
 * 3:插入排序 InsertSort
 * 4:快速排序 QuickSotrt
 * 引用: 类中形参变量当做应用的时候形参不能是普通类型，形参必须是复合类型，比如说数组就可以
 */
package com.test1;
import java.util.*;
public class Demo5_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len=10000000;
		int []arr=new int[len];
		for (int i=0; i<len; i++)
		{
			//让程序随机产生1到10000的数字
			//Math.random()会随机产生一个 0到1的数字不会等于0 也不会等于1
			int t=(int)(Math.random()*10000);
			arr[i]=t;
		}
	//	int arr1[]={1,6,0,-1,9,3,2,44,33,77};
	/*	int a=12;
		int arr[]={1,6,0,-1,9};
		Bubble bubble=new Bubble();
		bubble.test(a);
		System.out.println("a="+a);     //这个时候a的值是12 应为引用类型不能是平常的类型，不过数组就可以
		bubble.sort(arr);  */
		
		//用选择排序法定义一个对象
	//	Select select=new Select();
		//用插入法定义一个对象
	//	InsertSort is=new InsertSort();
		//在排序前打印一个时间
		QuickSort qs=new QuickSort();
		Calendar cal1=Calendar.getInstance();  //定义一个时间类  单开模式
		System.out.println("排序前"+cal1.getTime());
	//	select.sort(arr);
	//	is.sort(arr1);
		//排序后打印一个时间，必须重现定义一个对像
		qs.sort(arr,0 ,arr.length-1);
		Calendar cal2=Calendar.getInstance();  // 必须重新定义，
		System.out.println("排序后"+cal2.getTime());
	/*	for(int i=0; i<arr1.length; i++)
		{
			System.out.printf("%d ",arr1[i]);
		} */
    }
}


//1:插入排序
class InsertSort
{
	//插入排序法
	public void sort(int arr[])
	{
		for(int i=1; i<arr.length; i++)
		{
			int insertVal=arr[i];
			//insertVal准备和前一个数比较
			int index=i-1;
			while(index>=0&&insertVal<arr[index])
			{
				//将把arr[index]向后移动
				arr[index+1]=arr[index];
				//让index 向前移动
				index--;
			}
			//将insertVal 插入到适当的位置
			arr[index+1]=insertVal;
		}
	}
}


//2:选择排序法
class Select
{
	//选择快排序
	int temp=0;
	public void sort(int arr[])
	{
		//认为第一个数字是最小的
		int temp=0;
		for(int j=0; j<arr.length-1; j++)
		{
			int min=arr[j];
			//记录最小数的下标
			int minIndex=j;
			for(int k=j+1; k<arr.length; k++)
				if(min>arr[k])
				{
					min=arr[k];
					minIndex=k;
				}
			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
}



//3:冒泡排序法
class Bubble
{
	public void test(int a)
	{
		a++;
	}
	public void sort(int arr[])
	{
		int temp=0;
		//i是决定走几趟, 冒泡排序
		for(int i=0; i<arr.length-1; i++)
		{
			//内层循环，开始逐个比较，如果发现前一个数比后一个数大就交换
			for(int j=0;j<arr.length-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					//换位
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;		
				}
			}
		}
	}
}


//4:快速排序
class QuickSort
{
	public void sort(int [] a, int low, int high )
	{

		int pos;
		if (low<high)
		{
			pos = FindPos(a, low, high);
			sort(a, low, pos-1);
			sort(a, pos+1, high);
		}
	}
	public int FindPos(int [] a, int low, int high)
	{
		int val = a[low];
		while (low<high)
		{
			while (low<high && a[high]>=val)
				--high;
			a[low] = a[high];
			while (low<high && a[low]<=val)
				++low;
			a[high] = a[low];
		}
		a[low] = val;
		return low;
	}
}
