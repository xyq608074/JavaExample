package leetcode.norepeatstring;


import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        String str="pwwkew";
        char[] chars=str.toCharArray();
        Map<Character,Integer> hm=new HashMap<>();

        for (int i=0;i<chars.length;i++){
            hm.put(chars[i],i);
        }
        
        for (Map.Entry<Character,Integer>  entry: hm.entrySet()) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }
}
