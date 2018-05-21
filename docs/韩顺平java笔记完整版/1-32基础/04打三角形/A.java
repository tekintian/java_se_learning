import java.io.*;
public class A
{
	public static void main (String [] args)
	{
		int lay=7;
		for(int i=1; i<=lay; i++)
		{
			for(int k=1; k<=lay-i; k++)
			{
				System.out.printf(" "); // 输出空格不换行
			}
		    for(int j=1; j<=(i-1)*2+1; j++) 
			{
			    System.out.printf("*"); //输出*不换行
		    }
		System.out.println();   // 输出换行
		}
	}
}