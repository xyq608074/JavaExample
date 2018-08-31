package wenjiancopy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("src/wenjiancopy/copy.txt");

        FileWriter fw=new FileWriter("src/wenjiancopy/paste.txt");

        int ch;
        while ((ch=fr.read())!=-1){
            System.out.print((char)ch);
            fw.write((char)ch);
        }

        fw.flush();

        fw.close();
        fr.close();
    }
}
