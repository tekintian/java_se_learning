package cn.tekin.base;

import java.util.ArrayList;
import java.util.List;

/**
 * JAVA泛型
 * Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
 * 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 */
public class GenericParadigmMethods {
    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        Float[] arrFloat = {999f, 1.2f, 3.4f, 55f, 66.8f, 99.02f};

        System.out.println("整型数组元素为:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\n双精度型数组元素为:");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为:");
        printArray(charArray); // 传递一个字符型数组

        System.out.println("\r\n float类型数组：");
        printArray(arrFloat);
    }

    //泛型方法
    public static <E> void printArray(E[] inputArray) {
        //采用 增强for循环【 foreach循环】
        /*
        for(E element:inputArray){
            System.out.printf(" %s ", element);
        }
        System.out.println();
        */

        //普通for循环
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + "  ");
        }
        System.out.println("\n");
    }
}

/**
 * 有界的类型参数:
 * 可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
 * 要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
 *
 * 本例子演示了"extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）。该例子中的泛型方法返回三个可比较对象的最大值。
 */
class MaxImumTest
{
    //比较三个值，并返回最大值
    public static <T extends Comparable<T>> T maxCompare(T x, T y, T z)
    {
        //加色x是最大值
        T max=x;
        if (y.compareTo(max) > 0)   max=y;

        if (z.compareTo(max) > 0 )  max=z;

        return max; //返回最大对象
    }

    public static void main(String[] args) {

        System.out.printf("%f, %f, 和 %f 中最大的数为 %f \n",
                992.8f, 99f, 102f, maxCompare(992.8f, 99f, 102f));

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maxCompare( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maxCompare( "pear", "apple", "orange" ) );
    }
}

/**
 * 泛型类
 * 泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
 * 和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
 *
 * 本 实例演示了我们如何定义一个泛型类:
 * @param <T>
 */
class Box<T>
{
    private T t;

    public void add (T t){
        this.t=t;
    }

    public T get(){
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox=new Box<Integer>();
        Box<String> stringBox=new Box<String>();

        integerBox.add(99);
        stringBox.add(new String("云南网"));

        System.out.printf("整型值为： %d \n\r",integerBox.get());
        System.out.printf("字符串为 ：%s \r\n", stringBox.get());

    }
}


/**
 * 类型通配符
 * 1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 */
class GenericTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }
}