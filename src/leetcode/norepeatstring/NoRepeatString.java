package leetcode.norepeatstring;

import java.util.*;

public class NoRepeatString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个字符串 :");
        String str=sc.nextLine();
        char[] chars=str.toCharArray();


        Map<Character,Integer> hm=new HashMap<>();
        for (int i=0;i<chars.length;i++){
            hm.put(chars[i],i);
        }


        for (Map.Entry<Character,Integer> entry: hm.entrySet()) {
            int[] tmp=new int[]{entry.getValue()};
        }


//        char[] charArr=str.toCharArray();
//        Set<Character> set=new HashSet<>();
//        for (int i=0; i<charArr.length;i++){
//            set.add(charArr[i]);
//        }
//        for (Character c:set) {
//            System.out.println(c);
//        }
    }
}
