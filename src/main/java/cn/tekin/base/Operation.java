package cn.tekin.base;

/**
 *  在计算机系统中，数值一律用补码来表示（存储）的原因
 *
 * 主要原因：使用补码，可以将符号位和其它位统一处理；同时，减法也可按加法来处理。另外，两个用补码表示的数相加时，如果最高位（符号位）有进位，则进位被舍弃。
 *
 * 原码：原码表示法在数值前面增加了一位符号位（即最高位为符号位），该位为0表示正数；该位为1表示负数，其余位表示数值的大小。
 *
 * 算术运算
 * 规则：
 * 1. 二进制的最高位是符号位： 0 表示正数， 1表示负数
 * 2. 正数的 原码， 反码， 补码 全部都一样
 * 3. 负数的反码 = 他的原码符号位不变，其他为取反【 0->1; 1 -> 0 】
 * 4. 负数的补码 = 他的反码+1
 * 5. 0 的反码， 补码都是0 【0是正数】
 * 6. JAVA中没有无符号数，即 JAVA中的数都是有符号的
 * 7. 在计算机运算的时候，都是以补码的方式来运算的。
 *
 * 示例：
 * 1-2= -1
 * 二  进  制 的 1 = 0000 0000 0000 .... 0001
 * 二进制-2的补码   = 1111 1111 1111 .... 1110
 * 运算后的数值等于  = 1111 1111 1111 .... 1111   运算结果符号位为1 ，是负数 【补码】，需要把运算结果【补码】转为原码，即
 * 补码->反码->原码： 补码-1 变为反码，反码在变为原码，结果等于 -1
 *      【补码】   1111 1111 1111 .... 1111
 *      【反码】   1111 1111 1111 .... 1110
 *      【原码】   1000 0000 0000 .... 0001  结果等于 -1
 *
 *
 * 原码 ->补码
 * -2的原码 = 1000 0000 0000 .... 0010
 * -2的反码 = 1111 1111 1111 .... 1101
 * -2的补码 = 1111 1111 1111 .... 1110
 *
 */
public class Operation {
    public static void main(String[] args) {
        //算术运算
        arithmetic();

        //因为运算
        shift();
    }

    /**
     * JAVA中有 4个算术运算， 参与运算的所有负数数需要换成补码后再进行运算
     * ------------
     * 按位与 &   两位全位1 结果为 1
     * 按位或 |   两位有一位为1 结果为 1
     * 按位异或 ^ 两位一个为 0 一个为1 结果为1
     * 按位取反 ~ 取反 0 -> 1 ; 1->0 【不管符号位，全部取反】
     */
    public static void arithmetic(){
        //按位与
        System.out.println("1&1="+(1&1));
        System.out.println("1&0="+(1&0));
        System.out.println("2&3="+(2&3));

        //按位或
        System.out.println("1|1="+(1|1));
        System.out.println("0|1="+(0|1));
        System.out.println("2|3="+(2|3));

        //按位异或
        System.out.println("-3^3="+(-3^3));
        /*
        -3原码   1000 0000 .... 0011
        -3反码   1111 1111 .... 1100
        -3补码   1111 1111 .... 1101

         3原码   0000 0000 .... 0011
         ^运算 = 1111 1111 .... 1110 【补码 结果为负数，需要换回原码】

       补码->反码 1111 1111 .... 1101 [ 补码换为反码 -1 ]
       反码->原码 1000 0000 .... 0010  [反码换为原码 符号位不变，其他其他全部取反]，最后的结果为  -2
         */

        //按位取反 ~
        System.out.println("~2="+(~2));

        System.out.println("~-5="+(~-5)); //=4

        /*
        ~-5 的运算过程
        -5原码   1000 0000 .... 0101
        -5反码   1111 1111 .... 1010
        -5补码   1111 1111 .... 1011
        ~运算 =  0000 0000 .... 0100 【符号位为0，即正数，直接取出结果】结果等于4

         */
    }

    /**
     * 3个移位运算
     * 算术右移  >>  低位溢出，符号位不变，并用符号位补溢出的高位
     * 算术左移  <<  符号位不变，低位补 0
     * 逻辑右移  >>>
     */
    public static void shift(){
        //算术右移  >>
        /*
        1>>2   1表示那个数被移动， 2 表示被移动几位

        1 的补码   0000 0000 .... 0001  【正数的原码，补码 反码都一样】
         移动2位   0【溢出2位】0 0000 .... 0000 01
          >>结果   0000        0000 .... 0000  【用符号位补溢出的高位， 结果 等于 0 】
         */
        System.out.println("1>>2="+(1>>2));


        /*
        -1>>2

        -1 的原码   1000 0000 .... 0001
        -1 的反码   1111 1111 .... 1110
        -1 的补码   1111 1111 .... 1111

         移动2位   1【溢出2位】1 1111 .... 11 11 【用符号位补溢出的高位， 结果 等于 负数，需要换为原码】
          反码   1111 1111 .... 1110
          原码   1000 0000 .... 0001 结果等于 -1
         */
        System.out.println("-1>>2="+(-1>>2));

        //算术左移
        /* 算术左移 移动一位相当于 * 2
        1<<2 = ?

        1的补码  0000 0000 .... 0001
        >> 2后 = 0000 0000 .... 0100  结果等于 4

         */
        System.out.println("1<<2="+(1<<2));


        /* 算术左移  移动一位相当于 * 2
        -1<<2 = ?

        -1的原码  1000 0000 .... 0001
        -1的反码  1111 1111 .... 1110
        -1的补码  1111 1111 .... 1111

        <<2后  = 1111 1111 .... 1100  结果为负数，需要换为原码
          反码 = 1111 1111 .... 1011
          原码 = 1000 0000 .... 0100 结果等于 -4
         */
        System.out.println("-1<<2="+(-1<<2));

        //逻辑右移
        /*
        3>>>2

        补码： 0000 0000 .... 0011
        >>>   0000 0000 .... 00  11 【低位溢出，高位补 0 ， 结果为 0 】
         */
        System.out.println("3>>>2="+(3>>>2));

    }
}
