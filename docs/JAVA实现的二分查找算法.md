# JAVA 实现的二分查找算法
二分查找又称折半查找，它是一种效率较高的查找方法。

折半查找的算法思想是将数列按有序化(递增或递减)排列，查找过程中采用跳跃式方式查找，即先以有序数列的中点位置为比较对象，如果要找的元素值小 于该中点元素，则将待查序列缩小为左半部分，否则为右半部分。通过一次比较，将查找区间缩小一半。 折半查找是一种高效的查找方法。它可以明显减少比较次数，提高查找效率。但是，折半查找的先决条件是查找表中的数据元素必须有序。

折半查找法的优点是比较次数少，查找速度快，平均性能好;其缺点是要求待查表为有序表，且插入删除困难。因此，折半查找方法适用于不经常变动而查找频繁的有序列表。

二分算法步骤描述

① 首先确定整个查找区间的中间位置 mid = （ left + right ）/ 2

② 用待查关键字值与中间位置的关键字值进行比较；

若相等，则查找成功

若大于，则在后（右）半个区域继续进行折半查找

若小于，则在前（左）半个区域继续进行折半查找

③ 对确定的缩小区域再按折半公式，重复上述步骤。

最后，得到结果：要么查找成功， 要么查找失败。折半查找的存储结构采用一维数组存放。 折半查找算法举例

对给定数列（有序）{ 3,5,11,17,21,23,28,30,32,50,64,78,81,95,101}，按折半查找算法，查找关键字值为81的数据元素。

二分查找算法讨论：

优点：ASL≤log2n，即每经过一次比较,查找范围就缩小一半。经log2n 次计较就可以完成查找过程。

缺点：因要求有序，所以要求查找数列必须有序，而对所有数据元素按大小排序是非常费时的操作。另外，顺序存储结构的插入、删除操作不便利。

考虑：能否通过一次比较抛弃更多的部分（即经过一次比较，使查找范围缩得更小），以达到提高效率的目的。……？

可以考虑把两种方法（顺序查找和折半查找）结合起来，即取顺序查找简单和折半查找高效之所长，来达到提高效率的目的？实际上这就是分块查找的算法思想。

Java二分查找源码

```java

public class BinarySearch { 
        /** 
        * 二分查找算法 
        * 
        * @param srcArray 有序数组 
        * @param key 查找元素 
        * @return key的数组下标，没找到返回-1 
        */  
        public static void main(String[] args) { 
            int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};   
            System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));  
        } 

        // 二分查找递归实现   
        public static int binSearch(int srcArray[], int start, int end, int key) {   
            int mid = (end - start) / 2 + start;   
            if (srcArray[mid] == key) {   
                return mid;   
            }   
            if (start >= end) {   
                return -1;   
            } else if (key > srcArray[mid]) {   
                return binSearch(srcArray, mid + 1, end, key);   
            } else if (key < srcArray[mid]) {   
                return binSearch(srcArray, start, mid - 1, key);   
            }   
            return -1;   
        } 

        // 二分查找普通循环实现   
        public static int binSearch(int srcArray[], int key) {   
            int mid = srcArray.length / 2;   
            if (key == srcArray[mid]) {   
                return mid;   
            }   

            int start = 0;   
            int end = srcArray.length - 1;   
            while (start <= end) {   
                mid = (end - start) / 2 + start;   
                if (key < srcArray[mid]) {   
                   end = mid - 1;   
                } else if (key > srcArray[mid]) {   
                    start = mid + 1;   
                } else {   
                    return mid;   
                }   
            }   
            return -1;   
        } 
    } 
```