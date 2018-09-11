package digui;

public class Digui {

    public static void main(String[] args) {
        diGuiHanShu(10);
    }

    public static void diGuiHanShu(int num){
        System.out.println(num);

        if (num>0){
            diGuiHanShu(num-1);
        }
    }
}
