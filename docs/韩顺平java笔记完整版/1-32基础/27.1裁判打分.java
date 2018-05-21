/**
 * 裁判打分
 * 3个人的成绩 去掉最高分 在去掉最低分然后求最低分
 * 可以判断最低分‘、
 * 和最垃圾的裁判
 */
package com.test1;
import java.io.*;
public class Text1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Judge judge=new Judge();
		System.out.println(judge.lastFen());
		System.out.println("最菜的裁判是"+(judge.getWorst()));
	}
}
class Judge
{
	//第一一个可以存放3个小数的数组
	float fens[]=null;
	int size=3;
	//构造函数用于初始化
	public Judge()
	{
		fens=new float[size];
		//初始化.
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);	
			try {
				for(int i=0; i<fens.length; i++)
				{
				System.out.println("请输入第"+(i+1)+"裁判的成绩");
				fens[i]=Float.parseFloat(br.readLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//得到最垃圾的评委
	public int getWorst()
	{
		float lastFen=this.lastFen();
		//认为第一个评委是最差的
		int worstIndex=1;
		float cai=Math.abs(fens[0]-lastFen);
		float tempCai=0f;
		for(int i=1; i<fens.length; i++)
		{	
			if(cai<Math.abs(fens[i]-lastFen))
			{
				worstIndex=i+1;
				cai=Math.abs(fens[i]-lastFen);
			}
		}
		return worstIndex;
	}
	//得到运动员的最后得分
   public float lastFen()
	{
		
		
		
		//3: 得到平均分
		float allFen=0;
		int minIndex=this.getLowFenIndex();
		int maxIndex=this.getHighnFenIndex();
		for(int i=0; i<fens.length; i++)
		{
			if(i!=minIndex && i!=maxIndex)
			{
				allFen+=fens[i];
			}
		}
		return allFen/(fens.length-2);
	}
	//1: 去掉最低分（就是找到最低分的下标）
	public int getLowFenIndex()
	{
		//选择法，假设第一个是最低分
		float minFen=fens[0];
		int minIndex=0;
		for (int i=1; i<fens.length; i++)
		{
			if(minFen>fens[i])
			{
				//修改最低分
				minFen=fens[i];
				minIndex=i;
			}
		}
		return minIndex;
		              
	}
	//2: 去掉最高分
	public int getHighnFenIndex()
	{
		//选择法，假设第一个是最低分
		float maxFen=fens[0];
		int maxIndex=0;
		for (int i=1; i<fens.length; i++)
		{
			if(maxFen<fens[i])
			{
				//修改最低分
				maxFen=fens[i];
				maxIndex=i;
			}
		}
		return maxIndex;
		              
	}
}

