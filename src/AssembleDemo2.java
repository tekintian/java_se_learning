import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AssembleDemo2 {
    public static void main(String[] args) {

        EmpManage em=new EmpManage();


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        //做一个简易菜单
        while (true){
            System.out.println("请选择您要进行的操作");
            System.out.println("1 : 添加一个雇员");
            System.out.println("2 : 查找雇员");
            System.out.println("3 : 修改薪水");
            System.out.println("4 : 删除雇员");
            System.out.println("5 : 退出系统");

            try {
                Integer operType=Integer.parseInt(br.readLine());
                String empNo="";
                String name="";
                float sal=0f;
                //采用switch case模式，效率必if else更高
                switch (operType){
                    case 1:
                        System.out.println("请输入工号");
                        empNo=br.readLine();
                        System.out.println("请输入名字");
                        name=br.readLine();
                        System.out.println("请输入薪水");
                        sal=Float.parseFloat(br.readLine());
                        //创建雇员
                        Emp emp =new Emp(empNo,name,sal);
                        em.addEmp(emp);
                        break;
                    case 2:
                        System.out.println("请输入工号");
                        empNo=br.readLine();
                        em.showEmpInfo(empNo);
                        break;
                    case 3:
                        System.out.println("请输入工号");
                        empNo=br.readLine();
                        System.out.println("请输入薪水");
                        sal=Float.parseFloat(br.readLine());
                        em.updateSal(empNo,sal);
                        break;
                    case 4:
                        System.out.println("请输入工号");
                        empNo=br.readLine();
                        em.delEmp(empNo);
                        break;
                    case 5:
                       System.exit(0);
                        break;
                    default:
                        System.out.println("操作错误，请选择你要进行的操作");
                        break;

                }

             /* //采用if else if模式
                if (operType.equals(1)) {
                    System.out.println("请输入工号");
                    empNo=br.readLine();
                    System.out.println("请输入名字");
                    name=br.readLine();
                    System.out.println("请输入薪水");
                    sal=Float.parseFloat(br.readLine());
                    //创建雇员
                    Emp emp =new Emp(empNo,name,sal);
                    em.addEmp(emp);

                }else if (operType.equals(2)){
                    System.out.println("请输入工号");
                    empNo=br.readLine();
                    em.showEmpInfo(empNo);
                }else if (operType.equals(3)){
                    System.out.println("请输入工号");
                    empNo=br.readLine();
                    System.out.println("请输入薪水");
                    sal=Float.parseFloat(br.readLine());
                    em.updateSal(empNo,sal);
                }else if (operType.equals(4)){
                    System.out.println("请输入工号");
                    empNo=br.readLine();
                    em.delEmp(empNo);
                }else if (operType.equals(5)){
                  System.exit(0);
                }
            */


            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
                return;
            }
        }


    }
}

//雇员管理类
class EmpManage
{
    private ArrayList al=null;
    //构造
    public EmpManage(){
        al=new ArrayList();
    }
    //加入员工
    public void addEmp(Emp emp){
        al.add(emp);
        System.out.println("增加成功！");
    }

    /**
     * 显示信息
     * @param empNo
     */
    public void showEmpInfo(String empNo){

        if (al.size()==0) System.out.println("请先增加用户");
        for (int i = 0; i < al.size(); i++) {
            Emp emp=(Emp) al.get(i);
            if(emp.getEmpNo().equals(empNo)){
                System.out.println("编号："+empNo +" 姓名："+emp.getName()+ "薪水："+emp.getSal());
                return;//退出for循环
            }else{
                System.out.println("Sorry, 没有找到改员工");
            }
        }
    }

    /**
     * 修改薪水
     * @param empNo
     * @param sal
     */
    public void updateSal(String empNo,float sal){
        if (al.size()==0) System.out.println("请先增加用户");
        for (int i = 0; i < al.size(); i++) {
            Emp emp=(Emp) al.get(i);
            if(emp.getEmpNo().equals(empNo)){
                emp.setSal(sal);
                System.out.println("修改成功！");
                return;//退出for循环
            }else{
                System.out.println("Sorry, 没有找到改员工");
            }
        }
    }

    /**
     * 删除员工
     * @param empNo
     */
    public void delEmp(String empNo){
        if (al.size()==0) System.out.println("请先增加用户");
        for (int i = 0; i < al.size(); i++) {
            Emp emp=(Emp) al.get(i);
            if(emp.getEmpNo().equals(empNo)){
                al.remove(i);
//                al.remove(emp);
                System.out.println("删除成功！");
                return;//退出for循环
            }else{
                System.out.println("Sorry, 没有找到改员工");
            }
        }
    }
}

//雇员类
class Emp{
    private String empNo;
    private String name;
    private float sal;

    //构造函数
    public Emp(String empNo, String name, float sal){
        this.empNo=empNo;
        this.name=name;
        this.sal=sal;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

}