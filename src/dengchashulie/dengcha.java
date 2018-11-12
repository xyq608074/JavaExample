package dengchashulie;


// 在等差数列中  a4=6  a9=26  a20=?
public class dengcha {
    public static void main(String[] args){
        int a=6;
        int d=4;
        int n=20;
        int a1 = a;
        for (int i = 0; i <= n-d+1; i++) {
            a = a1+(i-1)*d;
            System.out.print(a+" ");
        }
    }
}
