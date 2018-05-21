/**
 * 功能：多维数组
 * 注意：整形的多维数组不填的话默认为0
 */
package com.test1;

public class Demo5_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[4][6];
		a[1][1]=1;
		a[2][1]=2;
		a[2][3]=3;
		//把图形输出
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<6; j++)
			{
				System.out.print(a[i][j]+" ");
			}
			//换行
			System.out.println();	
		}
  }

}
