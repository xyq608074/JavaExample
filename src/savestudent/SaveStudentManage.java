package savestudent;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveStudentManage {
    public static void main(String[] args) throws IOException {
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
                    addStudent();
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
    private static void deleteStudent() throws IOException {
        ArrayList<Student> al=new ArrayList<Student>();

        //将文件读入到集合
        FileToArrayList(al);

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的学生学号: ");
        String id=sc.nextLine();

        int index=-1;

        //判断一下输入的信息和集合中的信息是否有重复  有重复的id才能修改  把下标给了index
        for (int i=0;i<al.size();i++){
            Student s=al.get(i);
            if (s.getStuid().equals(id)){
                index=i;
                break;
            }
        }

        //判断 如果上面index值是-1 证明没有找到和输入的相同id  证明不存在
        if (index==-1){
            System.out.println("不好意思,您输入的信息学号不存在,请回去重新选择");
        }else{//如果存在删除
            al.remove(index);
            ArrayListToFile(al);
            System.out.println("删除学员成功!");
        }

    }

    //修改学生
    private static void updateStudent() throws IOException {
        //创建一个新的集合
        ArrayList<Student> al=new ArrayList<Student>();
        //从文件读取数据到集合中 保存在新的集合
        FileToArrayList(al);

        //接收一个要修改的符号
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改的学生学号: ");
        String id=sc.nextLine();

        int index=-1;

        //判断输入的信息是否和集合中有重复的内容  如果有下标给了index
        for (int i=0;i<al.size();i++){
            Student s=al.get(i);
            if (s.getStuid().equals(id)){
                index=i;
                break;
            }
        }
        //判断下标是否是-1  如果是-1 就证明上面没有找到相同内容  证明不存在id
        if (index==-1){
            System.out.println("您输入的学号不存在,请重新输入");
        }else{
            System.out.println("请输入学生姓名: ");
            String stuname=sc.nextLine();
            System.out.println("请输入学生年龄: ");
            String stuage=sc.nextLine();
            System.out.println("请输入学生地址: ");
            String stuaddr=sc.nextLine();

            Student s=new Student();
            s.setStuid(id);
            s.setStuname(stuname);
            s.setStuage(stuage);
            s.setStuaddr(stuaddr);

            al.set(index,s);
            ArrayListToFile(al);
            System.out.println("修改学生成功");
        }
    }

    //添加学生
    private static void addStudent() throws IOException {
        ArrayList<Student> al=new ArrayList<Student>();
        FileToArrayList(al);
        Scanner sc=new Scanner(System.in);

        String id;
        while (true) {
            System.out.println("请输入学生学号: ");
            id = sc.nextLine();
            //判断学号是否存在 如果存在提示已存在
            //建立一个标记
            boolean flag=false;
            //遍历集合进行判断id是否有重复的  如果有重复 标记变成true
            for (int i = 0; i < al.size(); i++) {
                Student s = al.get(i);
                if (s.getStuid().equals(id)){
                    flag=true;
                    break;
                }
            }
            //如果是flag是true 存在重新输入   如果是false跳出执行下面添加操作
            if (flag) {
                System.out.println("输入的学号已经存在,请重新输入");
            }else{
                break;
            }
        }

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
        ArrayList<Student> al=new ArrayList<Student>();
        FileToArrayList(al);

        if (al.size()==0){
            System.out.println("暂无信息");
            return;
        }

        for (int i=0;i<al.size();i++){
            Student s=al.get(i);
            System.out.println(s.getStuid()+","+s.getStuname()+","+s.getStuage()+","+s.getStuaddr());
        }
    }


    //把集合读取到文件中
    private static void ArrayListToFile(ArrayList<Student> al) throws IOException {
        //写入文件对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/savestudent/studentmanage.txt"));

        for (int i=0;i<al.size();i++){
            Student s=al.get(i);
            bw.write(s.getStuid()+","+s.getStuname()+","+s.getStuage()+","+s.getStuaddr());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    //把文件读入到集合中
    private static void FileToArrayList(ArrayList<Student> al) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/saveStudent/Studentmanage.txt"));

        String line;
        while ((line=br.readLine())!=null){
            String [] dates=line.split(",");
            Student s=new Student();
            s.setStuid(dates[0]);
            s.setStuname(dates[1]);
            s.setStuage(dates[2]);
            s.setStuaddr(dates[3]);
            al.add(s);
        }
        br.close();
    }
}
