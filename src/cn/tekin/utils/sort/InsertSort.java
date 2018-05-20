package cn.tekin.utils.sort;

public class InsertSort {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    //插入排序法
    public static int[] sort(int arr[])
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
        return arr;
    }
}
