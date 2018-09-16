package doudizhu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DouDiZhu {
    public static void main(String[] args) {
        //声明一个数组显示花色
        String[] hua={"黑桃","红桃","梅花","方片"};
        //声明一个数组显示数字
        String[] num={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        //创建一个list集合  当做盒子来放扑克牌
        List<String> box=new ArrayList<String>();
        for (int i=0;i<hua.length;i++){
            for (int j=0;j<num.length;j++){
                box.add(hua[i]+num[j]);
            }
        }

        //加上大小王
        box.add("大王");
        box.add("小王");

        //洗牌
        Collections.shuffle(box);

        //声明玩牌的人
        List<String> zhangsan=new ArrayList<String>();
        List<String> lisi=new ArrayList<String>();
        List<String> wangwu=new ArrayList<String>();

        //发牌 斗地主需要留取三张牌做底牌
        for (int i=0;i<box.size()-3;i++){
            if (i%3==0){
                zhangsan.add(box.get(i));
            } else if (i%3==1){
                lisi.add(box.get(i));
            } else if (i%3==2){
                wangwu.add(box.get(i));
            }
        }

        System.out.println("张三的牌是: "+zhangsan);
        System.out.println("李四的牌是: "+lisi);
        System.out.println("王五的牌是: "+wangwu);

        //底牌
        System.out.print("底牌是 :");
        List<String> dipai=new ArrayList<String>();
        for (int i=box.size()-3;i<box.size();i++){
            dipai.add(box.get(i));
        }
        System.out.println(dipai);
    }
}
