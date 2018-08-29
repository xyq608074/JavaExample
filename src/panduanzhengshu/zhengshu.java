package panduanzhengshu;

public class zhengshu {
    public static void main(String[] args) {
        String str="123abz";
        System.out.println(isNaN(str));
    }

    private static boolean isNaN(String str){
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
