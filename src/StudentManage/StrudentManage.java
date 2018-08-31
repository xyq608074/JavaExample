package StudentManage;

import java.util.ArrayList;
import java.util.Scanner;

public class StrudentManage {
    public static void main(String[] args) {

        //声明一个集合来存储学生信息
        ArrayList<Student> array=new ArrayList<Student>();

        while (true){
            System.out.println();
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1.查看所有学生");
            System.out.println("2.添加学生");
            System.out.println("3.修改学生");
            System.out.println("4.删除学生");
            System.out.println("5.退出学生管理系统");
            System.out.println();
            System.out.println("请输入你的选择: ");

            Scanner sc=new Scanner(System.in);
            String choice=sc.nextLine();

            switch (choice){
                case "1":
                    findAllStudent(array);
                    break;
                case "2":
                    addStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    delStudent(array);
                    break;
                case "5":
                    System.out.println("程序正在退出,谢谢您的使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入序号错误请重新输入");
            }
        }
    }

    //修改学生
    private static void updateStudent(ArrayList<Student> array) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要修改的学生学号 :");
        String stuid = sc.nextLine();

        int index=-1;

        for (int i=0;i<array.size();i++){
            Student s=array.get(i);
            if (s.getStu_id().equals(stuid)){
                index=i;
                break;
            }
        }

        if (index == -1){
            System.out.println("对不起,您输入的学号有误,请重新输入");
        }else{
            System.out.println("请输入学生的新姓名 :");
            String stuname=sc.nextLine();
            System.out.println("请输入学生的新年龄 :");
            String stuage = sc.nextLine();
            System.out.println("请输入学生的新地址 :");
            String stuaddr = sc.nextLine();

            Student s=new Student();
            s.setStu_id(stuid);
            s.setStu_name(stuname);
            s.setStu_age(stuage);
            s.setStu_addr(stuaddr);

            array.set(index,s);
            System.out.println("学员 "+stuid+" 修改成功!");
        }
    }

    //删除学生
    private static void delStudent(ArrayList<Student> array) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要删除的学生学号 :");
        String stuid=sc.nextLine();

        int index=-1;
        for (int i=0;i<array.size();i++){
            //获取到每个学生对象
            Student s=array.get(i);

            if (s.getStu_id().equals(stuid)){
                index=i;
                break;
            }
        }

        if (index==-1){
            System.out.println("对不起,您输入的学生学号信息有误");
        }else{
            array.remove(index);
            System.out.println("删除学生 "+stuid+" 成功");
        }
    }

    //添加学生
    private static void addStudent(ArrayList<Student> array) {
        Scanner sc=new Scanner(System.in);

        String stuid;

        while (true) {
            System.out.println("请输入学号 :");
            stuid = sc.nextLine();
            //定义一个标记,如果这个标记为false学号没有占用  如果是true学号被占用
            boolean flag = false;
            //遍历集合
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                //判断集合中的和输入的是否一致 如果一致返回
                if (s.getStu_id().equals(stuid)) {
                    flag = true;
                    break;//跳出for循环
                }
            }

            if (flag){
                System.out.println("您输入的学好已存在,请重新输入");
            }else{
                break;//跳出while循环
            }
        }

        System.out.println("请输入学生姓名 :");
        String stuname = sc.nextLine();
        System.out.println("请输入学生年龄 :");
        String stuage = sc.nextLine();
        System.out.println("请输入学生地址 :");
        String stuaddr = sc.nextLine();

        Student s=new Student();
        s.setStu_id(stuid);
        s.setStu_name(stuname);
        s.setStu_age(stuage);
        s.setStu_addr(stuaddr);

        array.add(s);
    }

    //查看所有学生
    private static void findAllStudent(ArrayList<Student> array) {
        if (array.size()==0){
            System.out.println("学生管理暂无学生,请先添加学生信息");
        }else{
            System.out.println("编号\t\t姓名\t\t年龄\t\t地址");
            for (int i=0; i<array.size();i++){
                Student s=array.get(i);
                System.out.println(s.getStu_id()+"\t\t"+s.getStu_name()+"\t\t"+s.getStu_age()+"\t\t"+s.getStu_addr());
            }
        }
    }
}
