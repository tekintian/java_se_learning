package cn.tekin.utils.sort;

/**
 * 快速排序思想： 找一个数组中的数，从中间开始分割
 */
public class QuickSort {
    /**
     * 入口测试函数
     * @param args
     */
    public static void main(String[] args) {

        //数组
        int []arr1={88,99,555,8,1,-99,-8,-5,-1,1,2,3,4,99,12,822,25,1035,36,48,99,999};

        //使用快速排序法对数组进行排序
        arr1 = QuickSort.sort(arr1,0,arr1.length-1);

        //输出排序后的数组
        System.out.print("\n\r 排序后的数组：{");
        for (int i = 0; i < arr1.length; i++) {

            if (i>=0&&i<arr1.length-1){
                System.out.print(arr1[i] +", ");
            }else{
                System.out.print(arr1[i] +"}");
            }
        }

    }

    /**
     * 快速排序法实现
     * @param srcArr 需要排序的数组
     * @param low  索引最小值, 最左边的索引
     * @param high  索引最大值 ， 最右边的索引
     * @return  排序后的数组
     */
    public static int[] sort(int []srcArr, int low,int high){

        //定义中间索引变量
        int pos;

        //如果右边索引大于左边索引，开始排序
        if (low<high){
            //查找中间索引
           pos = findPos(srcArr,low,high);
           //左边排序
           sort(srcArr, low, pos-1);
           //右边排序
           sort(srcArr, pos+1, high);
        }

        return srcArr;
    }

    /**
     * 查找中间索引 key
     *
     * @param srcArr 需要排序的数组
     * @param low  索引最小值, 最左边的索引
     * @param high  索引最大值 ， 最右边的索引
     * @return int 中间索引key
     */
    public  static int findPos(int []srcArr, int low, int high){
        //定义值为最小值
        int val = srcArr[low];

        while (low<high){
            //右边排序
            while (low<high && srcArr[high]>=val)
                --high;
            srcArr[low]=srcArr[high];

            //左边排序
            while (low<high && srcArr[low] <= val)
                ++low;
             srcArr[high]=srcArr[low];
        }

        srcArr[low]=val;

        return low;
    }

}
