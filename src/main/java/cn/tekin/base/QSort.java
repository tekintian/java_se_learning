package cn.tekin.base;

public class QSort {
    public static void main(String[] args) {
        int []arr1=new int[100000000];

        //产生随机数
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=(int)(Math.random()*1000000);
        }

        System.out.println(Math.random());

        long sTime=System.currentTimeMillis();
        System.out.println("开始时间："+sTime);

        sort(arr1,0,arr1.length-1);

        long eTime=System.currentTimeMillis();
        System.out.println("结束时间："+eTime);

        System.out.println("用时："+( (eTime - sTime)/1000) +" 秒");


//
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.print(arr1[i]+ "  ");
//        }

    }

    public static void sort(int []arr, int left, int right){
        int pos;
        if (left<right){
            pos=findPos(arr,left,right);
            sort(arr,left, pos-1);
            sort(arr, pos+1,right);
        }
    }

    public static int findPos(int []arr, int left, int right){

        //设定中间变量为 arr[left]

        int val=arr[left];

        while (left<right){
            //在右边找
            while (left<right&&arr[right]>=val) --right;
            arr[left]=arr[right];

            //在左边找
            while (left<right&&arr[left]<=val) ++left;
            arr[right] = arr[left];
        }
        arr[left]=val;
        return left;
    }
}

