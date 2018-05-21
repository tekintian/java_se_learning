package cn.tekin.base;

import cn.tekin.utils.sort.QuickSort;

/**
 * 二分法查找 演示
 */
public class TwoSplitFindDemo {
    public static void main(String[] args) {

//        int arr[]={88,4,2,5,7,0,6,88,99,25,95,-6,-99,-23,560,1234};
//        BinaryFind bf=new BinaryFind();
//        bf.find(0,arr.length-1,-6, arr);

        //二分查找的前提，数据必须是从小到大排列的有序数据
        int []arr1={88,99,555,8,1,-99,-8,-5,-1,1,2,3,4,99,12,822,25,1035,36,48,99,999};


        //使用快速排序法对数组进行排序
        arr1 = QuickSort.sort(arr1,0,arr1.length-1);

        //定义一个数组接收排序后的数组
        System.out.print("\n\r 排序后的数组：{");
        for (int i = 0; i < arr1.length; i++) {

            if (i>=0&&i<arr1.length-1){
                System.out.print(arr1[i] +", ");
            }else{
                System.out.print(arr1[i] +"}");
            }
        }

        System.out.println("\r\n");


        TwoSpiltFind tsf=new TwoSpiltFind();
        //默认左边的索引为 0， 一位数组的索引是从0开始的， 左边的index是数组个数（长度）-1
        int rightIndex =arr1.length-1;

        tsf.find(arr1, 1,0,arr1.length-1);

//        System.out.println("普通方式实现："+TwoSpiltFind.binSearch(arr1, -1));


    }
}

/**
 * 二分查找法 实现类
 */
class TwoSpiltFind{
    public void find(int []arr, int val, int leftIndex, int rightIndex){

        //首先找到中间的index
        int midIndex = (rightIndex-leftIndex)/2 +leftIndex;
        //获取中间值
        int midVal=arr[midIndex];

        //右边的index 大于左边的index 说明数据正确，开始查找
        if (rightIndex>=leftIndex){
            //如果中间值 大于要查找的值，则在左边找
            if (midVal>val){
                find(arr, val, leftIndex, midIndex-1);
            }else if (midVal<val){
                //在arr的右边找数
                find(arr, val, midIndex+1,rightIndex);
            }else if (midVal==val){
                System.out.println("找到了， 下标为："+midIndex);
            }
        }

    }

    // 二分查找递归实现
    public static int binSearch(int srcArray[], int start, int end, int val) {
        //中间索引
        int mid = (end - start) / 2 + start;

        if (srcArray[mid] == val) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (val > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, val);
        } else if (val < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, val);
        }
        return -1;
    }

    // 二分查找普通循环实现
    public static int binSearch(int srcArray[], int val) {
        int mid = srcArray.length / 2;
        if (val == srcArray[mid]) {
            return mid;
        }

        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (val < srcArray[mid]) {
                end = mid - 1;
            } else if (val > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
