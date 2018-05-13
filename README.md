# java se 练习 Demo


[JAVA实现的雇员管理小程序](blob/master/src/AssembleDemo2.java)


# 常用集合框架
ArrayList
HashMap
HashTable
LinkedList
Vector
Stack
Iterator

List结构集合类
ArrayList， LinkedList, Vector, Stack

Map结构集合类
HashMap
HashTable

Set结构集合类
HashSet
TreeSet


Queue队列结构的集合类
Queue接口

 
## JAVA中 == 比较的是引用地址是否相等，  equals() 比较的是值是否相等

如
```java

    String a=new String("abc");
    String b=new String("abc");
    if(a==b) {
        System.out.println("ok!");
    }else{
        System.out.println(" fail ");
    }
    
//结果  fail

if(a.equals(b)) System.out.println("ok!");
    //结果OK
    
```