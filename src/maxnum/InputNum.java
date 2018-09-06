package maxnum;

import java.util.Scanner;

public class InputNum {
    public static void main(String[] args) {
        int[]  num=new int[5];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<num.length;i++){
            System.out.println("请输入第"+(i+1)+"个数: ");
            num[i] =sc.nextInt();
        }
        //静态方法不用new
        //调用静态方法使用对象名称.静态方法名就行

        //调用静态方法判断数组最大数
        System.out.println("最大的数字是: "+MaxNum.getMax(num));
        //调用静态方法判断数组最大数下标
        System.out.println("最大的数组下标是: "+MaxNum.getMaxIndex(num));
    }
}
