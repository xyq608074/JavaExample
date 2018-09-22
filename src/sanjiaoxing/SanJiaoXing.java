package sanjiaoxing;

public class SanJiaoXing {
    public static void main(String[] args) {
        int num=10;
        for(int i=1;i<num;i++){
            for (int j=0;j<i;j++){
                if (i==j+1 || j==0 || i==num-1){
                    System.out.print("+");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
