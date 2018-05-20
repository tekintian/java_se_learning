package cn.tekin.demo;

/**
 * 接口使用注意事项：
 * 1. 接口不能被实例化；
 * 2. 接口中的所有方法都不能有主体 {}  【接口是更加抽象的抽象类】;
 * 3. 一个类可以实现多个接口;
 * 4. 接口中可以有变量【默认是静态的变量，不能用 private, protected 修饰, 且必须有初始值、
 *    a. 接口中的变量本质上都是 static的，而且是 Final不管你加不加 static修饰符；
 *    b. 在JAVA开发中，我们经常把经常用的变量，定义在接口中，作为全局变量使用。 访问形式： 接口名.变量名 】；
 * 5. 接口中不能继承其他类，当是可以继承其他接口;
 *
 * 接口就是没有内容的方法，
 */
interface Usb{
    //接口中可以有变量，默认是静态的变量，不能用 private, protected 修饰
    int a=1;
    //开始工作
    public void start();
    //停止工作
    public void stop();

}
//接口
interface Aaa{
   public void eee();
}
//一个接口,可以继承其他接口
interface Kkk extends Aaa{

}

//编写照相机，并实现USB接口
class Camera implements Usb,Kkk {
    @Override
    public void start() {
        System.out.println("我是相机，我开始工作了");
    }

    @Override
    public void stop() {
        System.out.println("我是相机，我停止工作了");
    }

    @Override
    public void eee() {

    }
}

class Phone implements Usb
{

    @Override
    public void start() {
        System.out.println("我是手机，我开始工作了");
    }

    @Override
    public void stop() {
        System.out.println("我是手机，我停止工作了");
    }
}

class Computer {
    public void useUsb(Usb usb){
        usb.start();
        usb.stop();
    }
}


public class ImplementsDemo {
    //入口测试
    public static void main(String[] args) {
        Computer computer=new Computer();

        Phone phone=new Phone();
        Camera camera=new Camera();

        computer.useUsb(phone);
        computer.useUsb(camera);

        //访问接口中的变量
        System.out.println(Usb.a);


//        System.out.println("Hello World!");
    }
}
