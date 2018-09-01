# 文本复制粘贴(低效率版和高效版)
##使用IO流对文件复制粘贴

###低效的是FileCopy 使用的是 FileReader FileWriter
FileReader  读取的是一个字符  还可以读取一个字符数组

FileReader fr=new FileReader("xxx.xxx");
fr.read();  

返回的是-1的时候


###常用:BufferedReader 和  BufferedWriter
高效的是FileCopyHigh 使用的是BufferedReader 和  BufferedWriter
BufferedReader 读取的可以是一个字符  可以是一个字符数组   还可以是一行数据
