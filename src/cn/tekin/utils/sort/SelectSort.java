package cn.tekin.utils.sort;

public class SelectSort {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

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
