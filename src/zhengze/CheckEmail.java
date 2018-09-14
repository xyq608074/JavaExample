package zhengze;

import java.util.Scanner;

public class CheckEmail {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个邮箱 :");
        String email=sc.nextLine();

        if (email.matches("\\w{3,10}\\@\\w{2,10}\\.com")){
            System.out.println("输入邮箱正确!");
        }else{
            System.out.println("输入邮箱错误!");
        }
    }
}
