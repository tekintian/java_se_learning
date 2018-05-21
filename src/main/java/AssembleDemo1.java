import java.util.ArrayList;

public class AssembleDemo1 {
    public static void main(String[] args) {

//        Clerk []clerk=new Clerk[?];
        ArrayList al=new ArrayList();

        //显示大小
        System.out.println(al.size());
        //向al中加入数据， 类型是 Object
        //创建职员
        Clerk clerk1=new Clerk("宋江",50, 2000);
        Clerk clerk2 = new Clerk("吴用",45,3000);
        Clerk clerk3 = new Clerk("林冲",35,1800);

        //将clerk1 加入到al中
        al.add(clerk1);
        al.add(clerk2);
        al.add(clerk3);
        al.add(clerk1);

        //显示大小
        System.out.println(al.size());

        //如何方位al中的对象
//        Clerk temp= (Clerk) al.get(1);
//        System.out.println("第二个人的名字是："+temp.getName());
//遍历al中所有对象
        for (int i = 0; i < al.size() ; i++) {
            Clerk temp=(Clerk) al.get(i);
            System.out.println("姓名："+temp.getName()+" 薪水："+ temp.getSal());
        }

        //如何删除一个对象
        al.remove(1);

        System.out.println("========删除后========");
        for (int i = 0; i < al.size() ; i++) {
            Clerk temp=(Clerk) al.get(i);
            System.out.println("姓名："+temp.getName()+" 薪水："+ temp.getSal());
        }
    }
}

//定义一个员工类
 class Clerk
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    private String name;
    private int age;
    private  float sal;
    //构造方法
    public  Clerk(String name, int age, float sal){
        this.name=name;
        this.age=age;
        this.sal=sal;
    }


}
