package cn.tekin.base;

/**
 * 继承和实现的区别 演示
 * 实现接口可以看做是对JAVA单继承的补充，
 */

public class EITest {
    public static void main(String[] args) {
        LittleMonkey littleMonkey=new LittleMonkey();
        //调用继承父类的方法
        littleMonkey.jump();

    }
}

interface Bird{
    public void fly();
}

interface Fish{
    //该方法要实现游泳！
    public void swimming();
}

class Monkey{
    int name;

    public void jump() {
        System.out.println("猴子会跳");
    }
}

class LittleMonkey extends Monkey implements Bird,Fish{

    @Override
    public void fly() {

    }

    @Override
    public void swimming() {

    }
}