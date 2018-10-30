package deletefile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFile {
    public static void main(String[] args) {
        createFiles();

        File f=new File("src\\deletefile\\a");
        deleteFiles(f);
    }

    //删除前要先创建一个文件目录和文件
    public static void createFiles() {
        File cfile=new File("src\\deletefile\\a\\b\\c\\");
        cfile.mkdirs();

        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("src\\deletefile\\a\\b\\c\\PoolData.txt"));
            bw.write("Hello World !");
            bw.newLine();
            bw.write("Java");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除文件
    public static void deleteFiles(File files){
        if (files.isDirectory()){
            File[] file=files.listFiles();
            for (File f : file) {
                if (f.isFile())
                        f.delete();
                else
                    deleteFiles(f);
            }
            files.delete();
        }
    }
}
