package pooldata.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String userpwd;

    static {
        try {
            //通过当前类获取加载器
            ClassLoader classLoader = DBUtils.class.getClassLoader();
            //通过加载器获取一个输入流
            InputStream is = classLoader.getResourceAsStream("basedata/properties/db.properties");
            //创建Properties对象
            Properties ppt=new Properties();
            //加载输入流
            ppt.load(is);
            //获取相关参数的值
            driver=ppt.getProperty("driver");
            url=ppt.getProperty("url");
            username=ppt.getProperty("username");
            userpwd=ppt.getProperty("userpwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取连接方法
    public static Connection getConnection(){
        Connection conn=null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, userpwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放关闭方法
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
