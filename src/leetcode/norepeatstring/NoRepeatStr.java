package leetcode.norepeatstring;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NoRepeatStr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个字符串 :");
        String str=sc.nextLine();

        int n = str.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(str.charAt(j))){
                set.add(str.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(str.charAt(i++));
            }
        }
        System.out.println(ans);
    }
}
