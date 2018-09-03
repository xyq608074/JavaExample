package savestudent;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveStudentManage {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> al=new ArrayList<Student>();

        while (true) {
            System.out.println();
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1.查看所有学生");
            System.out.println("2.添加学生");
            System.out.println("3.修改学生");
            System.out.println("4.删除学生");
            System.out.println("5.退出学生管理系统");
            System.out.println();
            System.out.println("请输入你的选择: ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    findAllStudent();
                    break;
                case "2":
                    addStudent(al);
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    deleteStudent();
                    break;
                case "5":
                    System.out.println("正在退出学生管理系统,谢谢您的使用");
                    System.exit(0);
                    break;
            }
        }
    }

    //删除学生
    private static void deleteStudent() {
    }

    //修改学生
    private static void updateStudent() {
    }

    //添加学生
    private static void addStudent(ArrayList<Student> al) throws IOException {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入学生学号 :");
        String id = sc.nextLine();
        System.out.println("请输入学生姓名 :");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄 :");
        String age = sc.nextLine();
        System.out.println("请输入学生地址 :");
        String addr = sc.nextLine();

        Student s=new Student();
        s.setStuid(id);
        s.setStuname(name);
        s.setStuage(age);
        s.setStuaddr(addr);

        al.add(s);
        ArrayListToFile(al);

        System.out.println("添加学生成功");

    }

    //查看所有学生
    private static void findAllStudent() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/savestudent/studentmanage.txt"));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }


    //把集合读取到文件中
    private static void ArrayListToFile(ArrayList<Student> al) throws IOException {
        //写入文件对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/savestudent/studentmanage.txt",true));

        for (int i=0;i<al.size();i++){
            Student s=al.get(i);
            bw.write(s.getStuid()+"\t\t"+s.getStuname()+"\t\t"+s.getStuage()+"\t\t"+s.getStuaddr());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
