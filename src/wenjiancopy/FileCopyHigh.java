package wenjiancopy;

import java.io.*;

public class FileCopyHigh {
    public static void main(String[] args) throws IOException {
        //读取文件对象
        BufferedReader br=new BufferedReader(new FileReader("src/wenjiancopy/copy.txt"));
        //写入文件对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/wenjiancopy/paste.txt"));

        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
            bw.write(line);// 注意: BufferedWriter是不读取换行符
            bw.newLine();//注意: BufferedWriter不读取换行符需要使用newLine()来加换行的
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
