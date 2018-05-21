# JAVA泛型

- 使用泛型的好处： 安全简单；  在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的 ，提高代码的重用率；

放射机制得到类的底层信息 

- 使用泛型的有点：
1. 类型安全；
2. 向后兼容；
3. 层次清晰；
4. 性能较高，用GJ编写的代码可以为JAVA编译器和细腻及带来更多的类型信息，这些信息对java程序做进一步的优化提供条件。


## 泛型的基本概念

泛型是java se1.5引入的新特性，泛型的本质是参数化类型，也就是说，所操作的数据类型被指定为一个参数，这种参数类型可以用在类， 接口和方法的创建中，分别称为泛型类，泛型接口，泛型方法。




```text
<T extends Comparable<? super T>> 表示什么意思

首先这是运用了java的泛型
①extends后面跟的类型如<任意字符 extends 类/接口>表示泛型的上限

```

```java
import java.util.*;
class Demo<T extends AbstractList>{}
public class Test
{
    public static void main(String[] args) {
	Demo<ArrayList> p = null; // 编译正确
//这里因为ArrayList是AbstractList的子类所以通过
//如果改为Demo<AbstractCollection> p = null;就会报错这样就限制了上限
    }
}

```
②同样的super表示泛型的下限③<T extends Comparable<? super T>>这里来分析T表示任意字符名，extends对泛型上限进行了限制即T必须是Comparable<? super T>的子类，然后<? super T>表示Comparable<>中的类型下限为T！这样来看一段代码辅助理解

```java

import java.util.GregorianCalendar;

class Demo<T extends Comparable<? super T>>{}

public class Test1
{
	public static void main(String[] args) {
	   Demo<GregorianCalendar> p = null; // 编译正确
    }
}

```
这个可以理解为<GregorianCalendar extends Comparable<Calendar>>是可以运行成功的！因为Calendar为GregorianCalendar 的父类并且GregorianCalendar 实现了Comparable<Calendar>,可查看api！.
如果是如下代码则运行不成功
```java
import java.util.GregorianCalendar;
class Demo<T extends Comparable<T>>{}
//这里把? super去掉了
public class Test
{
	public static void main(String[] args) {
	   Demo<GregorianCalendar> p = null; 
        }
}
```
编译会报错！因为<T extends Comparable<T>>相当于<GregorianCalendar extends Comparable<GregorianCalendar>>但是GregorianCalendar并没有实现Comparable<GregorianCalendar>而是实现的Comparable<Calendar>，这里不在限制范围之内所以会报错！



