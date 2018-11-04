package pooldata.c3p0.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void num(ComboPooledDataSource dataSource){
        System.out.println(dataSource.getMaxPoolSize());// 最大连接数
        System.out.println(dataSource.getMinPoolSize());// 最小连接数
        try {
            System.out.println("正在使用连接数"+dataSource.getNumBusyConnections());// 正在使用连接数
            System.out.println("空闲连接数"+dataSource.getNumIdleConnections());// 空闲连接数
            System.out.println("总连接数"+dataSource.getNumConnections());// 总连接数
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
