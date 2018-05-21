/**
 * 功能：二分查找
 * 
 */
package com.test1;

public class Demo5_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={2,5,7,12,25};
		BinaryFind bf=new BinaryFind();
		bf.find(0,arr.length-1,2,arr);
	}

}
//1：二分法查找
class BinaryFind
{
	public void find(int leftIndex, int rightIndex, int val, int arr[])
	{
		//首先找到中间的数
		//原笔记中这个是错误的，
		//int midIndex=(rightIndex+leftIndex)/2; 
		
		//正确的中间数获取方式为
		int midIndex= (rightIndex-leftIndex)/2 + leftIndex;
		
		
		int midVal=arr[midIndex];
		if(rightIndex>leftIndex)
		{
		//如果要找的数比midVal大
		    if(midVal>val)
			{
				//在数中的左边找
				find(leftIndex,  midIndex-1, val, arr);	
			}
			else if(midVal<val)
			{
				//在arr的右边找数
				find(midIndex+1, rightIndex, val,arr);
			}
			else if(midVal==val)
			{
				System.out.println("找到下标"+midIndex);
			}
		}
	}
  }
