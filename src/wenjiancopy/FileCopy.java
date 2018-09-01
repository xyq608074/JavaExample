package wenjiancopy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //读取文件对象
        FileReader fr=new FileReader("src/wenjiancopy/copy.txt");
        //写入文件对象
        FileWriter fw=new FileWriter("src/wenjiancopy/paste.txt");

        int ch;
        /**
         * fr.read()读取文件中每一个字符
         * 当读取的时为-1时说明文件读取完毕
         * 所以读取不等于-1就要一直读取下去
         */
        while ((ch=fr.read())!=-1){
            System.out.print((char)ch);
            fw.write(ch);
        }

        fw.flush();

        fw.close();
        fr.close();
    }
}
