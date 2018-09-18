package fibonacci;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(num(7));
    }

    /**
     *
     * 1
     * 1
     * 2
     * 3
     * 5
     * 8
     * 13
     *
     */
    public static int num(int n){
        if (n==1){
            return 1;
        }else if(n==2){
            return 1;
        }else{
            return num(n-1)+num(n-2);
        }
    }
}
