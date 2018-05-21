package cn.tekin.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 数组 demo
 * 数组可以存放多个同一类型的数据
 * 对象数组，使用的时候必须要 实例化后才能使用
 */
public class ArrayDemo {
    public static void main(String[] args) {

        //定义一个可以存放6个float的数组
        float []arr_f=new float[6];

        Random random=new Random(100);
        float rr=random.nextFloat()%10+100;
        System.out.println(rr);
        //赋值
        for (int i = 0; i <arr_f.length ; i++) {
            arr_f[i]=i*rr/2f;
        }

        float all=0;
        //遍历数组获取总体重
        for (int i = 0; i < arr_f.length; i++) {
            all+=arr_f[i];
        }

        System.out.println("总体重："+all);


        //=========================================

        float []arr=new float[]{1,-9,99,-2,88,99,102,5,50,62};

        System.out.println("arr数组的最大值为："+getMax(arr) + " 最小值：" + getMin(arr) + " 平均值："+getAvg(arr));


        //============================对象数组
        //定义一个 4只狗的对象数组
        Dog []dogs=new Dog[4];

        //总体重
        float allWeight=0;
        float avgWeight=0;

        //从控制台输入数据
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        for (int i = 0; i <dogs.length ; i++) {
            //对象数组，使用的时候必须要 实例化后才能使用
            dogs[i]=new Dog();
            System.out.println("请输入狗名：");
            try {
                String name=br.readLine();
                dogs[i].setName(name);
                System.out.println("请输入狗的体重");
               float s_weight=Float.parseFloat(br.readLine());
               dogs[i].setWeight(s_weight);

            } catch (IOException e) {
                e.printStackTrace();
            }


           //累加，总体重
            allWeight+=dogs[i].getWeight();

        }
        avgWeight=allWeight/dogs.length;

        System.out.println("共有："+ dogs.length +" 狗, 总体重："+ allWeight +" 平均体重："+ avgWeight);

        //预设最大体重
        float maxWeight=dogs[0].getWeight();

        //预设最小体重
        float minWeight=dogs[0].getWeight();

        int maxIndex=0;

        for (int i = 0; i < dogs.length; i++) {
            //获取最大体重
            if (maxWeight<dogs[i].getWeight()) maxWeight=dogs[i].getWeight();
            //获取最小体重
            if (minWeight>dogs[i].getWeight()) minWeight=dogs[i].getWeight();
        }

        System.out.println("体重最大："+ maxWeight +" 最小体重："+ minWeight);

    }

    /**
     * 获取int数组的最大值
     * @param arr int数组
     * @return int 最大值
     */
    public static float getMax(float []arr){
        float max=arr[0];
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //如果max 小于arr[i] 则表明 max不是最大值，他应该等于 arr[i]
            if (max<arr[i]) max = arr[i];
        }
        return max;
    }

    /**
     * 获取int数组的最小值
     * @param arr int数组
     * @return int 最大值
     */
    public static float getMin(float []arr){
        float min=0;
        for (int i = 0; i <  arr.length; i++) {
            //如果min 大于arr[i] 则表明 min 不是最小值，他应该等于 arr[i]
            if (min>arr[i]) min=arr[i];
        }
        return min;
    }
    public static float getAvg(float []arr){
        float sum=0;
        //遍历获取数组的和 sum
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        //数组的总和 / 数组长度 等于平均数
        float avg = (float) sum/arr.length;
        //返回平均数
        return avg;
    }
}

//定义一个狗类
class Dog{
    private String name;
    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}