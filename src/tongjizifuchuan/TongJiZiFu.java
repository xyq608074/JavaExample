package tongjizifuchuan;

import java.util.Scanner;

public class TongJiZiFu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串: ");
        String str = sc.nextLine();
        TongJi(str);
    }
    private static void TongJi(String str){
        int bigcount=0;
        int smallcount=0;
        int numbercount=0;

        for (int i=0; i<str.length();i++){
            char ch=str.charAt(i);
            if (ch>='A' && ch<='Z'){
                bigcount++;
            }else if(ch>='a' && ch<='z'){
                smallcount++;
            }else if(ch>='0' && ch<='9'){
                numbercount++;
            }
        }

        System.out.println("大写字母有 :"+bigcount+"次");
        System.out.println("小写字母有 :"+smallcount+"次");
        System.out.println("数字有 :"+numbercount+"次");
    }

}
