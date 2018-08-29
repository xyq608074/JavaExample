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
                    System.out.println("修改");
                    break;
                case "4":
                    System.out.println("删除");
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

    //添加学生
    private static void addStudent(ArrayList<Student> array) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号 :");
        String stuid = sc.nextLine();
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
