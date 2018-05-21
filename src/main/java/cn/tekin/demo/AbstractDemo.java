package cn.tekin.demo;

/**
 * 抽象类
 * 1. 抽象类不能被实例化
 * 2. 抽象类可以没有抽象方法，
 * 3. 有抽象方法的类必须声明为抽象类
 * 4. 抽象 方法不能有主体 {}
 */
abstract class Animal {
    String name;
    int age;

    /**
     * 抽象方法
     */
    abstract public void cry();

    /**
     * 抽象类里面是可以有实现了的方法
     */
    public void aaa(){
        System.out.println("aaaa");
    }
}

class Cat extends Animal
{
    public void cry(){
        System.out.println("猫猫叫.....");
    }
}

