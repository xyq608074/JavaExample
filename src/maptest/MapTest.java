package maptest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//import java.util.Map.Entry;

public class MapTest {
    public static void main(String[] args) {
        Student s1=new Student("张三","18","中国");
        Student s2=new Student("李四","19","北京");
        Student s3=new Student("王五","19","河北");

        Map<Student,String> hm=new HashMap<Student,String>();

        hm.put(s1,"stu001");
        hm.put(s2,"stu002");
        hm.put(s3,"stu003");

        //1.第一种遍历Map集合的方法
        Set<Student> setstu = hm.keySet();
        for (Student skey: setstu) {
            String value = hm.get(skey);
            System.out.println(skey+"---"+value);
        }
        System.out.println("=======================================================");
        //2.第二种遍历Map集合的方法
        Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
        for (Map.Entry<Student,String> entryKey:entrySet) {
            Student key=entryKey.getKey();
            String value=entryKey.getValue();
            System.out.println(key+"---"+value);
        }
    }
}
