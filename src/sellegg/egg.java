package sellegg;

public class egg {
    public static void main(String[] args) {
        for (double sum=1 ;sum<=100;sum++){
            double a= (sum/2)+0.5;
            double b= ((sum-a)/2)+0.5;
            double c= sum-a-b;

            if (a%2==0 && b%2==0 && c!=0 && a+b+c==sum){
                if (a!=0 && b!=0){
                    System.out.println((int)sum);
                }
            }
        }
    }

}
