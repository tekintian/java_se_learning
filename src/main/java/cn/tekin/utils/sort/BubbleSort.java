package cn.tekin.utils.sort;

/**
 * 冒泡排序法
 */
public class BubbleSort {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    /**
     * 冒泡排序法
     * @param arr 待排序的数组
     * @return 排序好的数组
     */
    public static int[] sort(int arr[])
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
        return arr;
    }
}
