package leetcode.norepeatstring;

import java.util.*;

public class NoRepeatString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个字符串 :");
        String str=sc.nextLine();

        int strlen = str.length();//字符串个数
        Set<Character> set=new HashSet<>();
        int result=0;//结果
        int count=0;//计数
        int rep=0;//重复

        while (rep<strlen && count<strlen){
            if (!set.contains(str.charAt(count))){ //p
                set.add(str.charAt(count++));
                result = Math.max(result,count-rep);
            }else{
                set.remove(str.charAt(rep++));
            }
        }
        System.out.println(result);
    }
}
