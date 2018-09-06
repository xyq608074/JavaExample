package maxnum;

public class MaxNum {
    //返回数组最大的数字
    public static int getMax(int[] arr){
        //定义一个参照值
        int max=0;

        for (int i=0; i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    //返回数组最大值数字下标
    public static int getMaxIndex(int[] arr){
        //定义一个参照值
        int max=0;
        int maxindex=0;

        for (int i=0; i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
                maxindex=i;
            }
        }
        return maxindex;
    }
}
