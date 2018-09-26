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
        int n1 = nums1.length;
        int n2 = nums2.length;
        double n=0;
        int[] res= Arrays.copyOf(nums1,n1+n2);
        System.arraycopy(nums2,0,res,n1,n2);

        Arrays.sort(res);

        if (res.length%2==0){
            n=((double)(res[(res.length/2)]+res[(res.length/2)-1])/2);
        }else{
            n=((double)res[res.length/2]);
        }
        return n;
    }


}


