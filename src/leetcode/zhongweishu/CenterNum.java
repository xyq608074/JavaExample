package leetcode.zhongweishu;

import java.util.Arrays;

public class CenterNum {
    public static void main(String[] args) {
        int[] num11={1,3};
        int[] num12={2};

        int[] num21={1,2,3,4,5,6};
        int[] num22={2,3,4,5};

        System.out.println(center(num21,num22));
//        center(num21,num22);

    }

    private static double center(int[] nums1,int[] nums2) {
        //声明一个数组 接收放入nums1的值并且规定数组大小为 两个数组length之和
        int[] res= Arrays.copyOf(nums1,nums1.length+nums2.length);
        //res数组再加上nums2的数组(这样就合并成一个数组了)
        System.arraycopy(nums2,0,res,nums1.length,nums2.length);
        //排序一下数组
        Arrays.sort(res);
        //如果res的长度是双数 执行两个数相加除以2  如果res长度是单数  执行单数中间的那个数字就行
        return res.length%2==0 ? (double)(res[(res.length/2)]+res[(res.length/2)-1])/2 : (double)res[res.length/2];
    }
}


