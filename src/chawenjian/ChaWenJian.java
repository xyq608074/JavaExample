package chawenjian;

import java.io.File;

public class ChaWenJian {
    public static void main(String[] args) {
        File f=new File("src");
        selectFile(f);
    }

    //查找文件
    public static void selectFile(File file){
        //判断file传递过来的是一个文件夹还是一个文件 如果是一个文件夹通过
        if (file.isDirectory()){
            //把file转成一个数组
            File[] files = file.listFiles();
            //遍历数组
            for (File f : files) {
                //判断是否是文件 如果是文件 通过
                if (f.isFile()){
                    //判断文件名  文件后缀名是.java的后缀名
                    if(f.getName().endsWith(".java")){
                        System.out.println(f.getName());
                    }
                }else{//判断如果不是文件 而是文件夹 在递归回去 查这个文件夹里面是不是还有文件
                    selectFile(f);
                }
            }
        }
    }
}
