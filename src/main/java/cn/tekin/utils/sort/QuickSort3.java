package cn.tekin.utils.sort;

/**
 * 当大量数据，且重复数多时，用三路快排
 *
 * 把数组分为三路，第一路都比base小，第二路都等于base，第三路都大于base。
 *
 * 用指针从前到后扫描，如果：
 *
 * 1.cur指向的数小于base，那么：交换arr[cur]和arr[i]的值，然后i++,cur++。
 *
 * 2.cur指向的数等于base,  那么：cur++
 *
 * 3.cur指向的数大于base，那么：交换arr[cur]和arr[j]的值，然后j--。
 *
 *
 *
 * 当cur > j的时候说明三路都已经完成。
 */
public class QuickSort3 {

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1, 16);
    }

    /**
     * @param arr   待排序的数组
     * @param left  左闭
     * @param right 右闭
     * @param k     当快排递归到子问题的规模 <= k 时，采用插入排序优化
     * @param <T>   泛型，待排序可比较类型
     */
    public static <T extends Comparable<? super T>> void sort(T[] arr, int left, int right, int k) {
        // 规模小时采用插入排序
        //        if (right - left <= k) {
        //            insertionSort(arr, left, right);
        //            return;
        //        }

        if (left >= right) return;
        int[] ret = partition(arr, left, right);
        sort(arr, left, ret[0], k);
        sort(arr, ret[1], right, k);
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            T cur = arr[i];
            int j = i - 1;
            for (; j >= 0 && cur.compareTo(arr[j]) < 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = cur;
        }
    }

    /**
     * @param arr   待排序的数组
     * @param left  待排序数组的左边界
     * @param right 待排序数组的右边界
     * @param <T>   泛型
     * @return
     */
    private static <T extends Comparable<? super T>> int[] partition(T[] arr, int left, int right) {
        //排序前，先让基准值和随机的一个数进行交换。这样，基准值就有随机性。
        //就不至于在数组相对有序时，导致左右两边的递归规模不一致，产生最坏时间复杂度
        swap(arr, left, (int) (Math.random() * (right - left + 1) + left));

        T base = arr[left];//基准值，每次都把这个基准值抛出去，看成[left+1.....right]左闭右闭区间的排序

        //三路快排分为下面这三个路(区间)
        int i = left; // left表示，[lleft...left) 左闭右开区间里的数都比base小
        int j = right;// left表示，(rright...right] 左开右闭区间里的数都比base大
        int cur = i;//用cur来遍历数组。[left...cur)左闭右开区间里的数都等于base

        while (cur <= j) {
            if (arr[cur].compareTo(base) == 0) {
                cur++;
            } else if (arr[cur].compareTo(base) < 0) {
                swap(arr, cur++, i++);
            } else {
                swap(arr, cur, j--);
            }
        }
        return new int[]{i - 1, j + 1};//[i...j]都等于base,子问题就只需要解决i左边和j右边就行了
    }


    public static void swap(Object[] arr, int i, int j) {
        if (i != j) {
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void printArr(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Integer[] arr = {3, 5, 1, 7, 2, 9, 8, 0, 4, 6};
        printArr(arr);//3   5   1   7   2   9   8   0   4   6
        sort(arr);

        printArr(arr);//0   1   2   3   4   5   6   7   8   9
    }
}
