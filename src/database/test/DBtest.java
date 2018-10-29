package database.test;

import database.utils.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBtest {
    @Test
    public void select(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            conn = DBUtils.getConnection();
            String sql="select * from admin";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(conn,pstmt,rs);
        }
    }
    @Test
    public void selectOne(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtils.getConnection();
            String sql="select * from admin where admin_id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            rs=pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(conn,pstmt,rs);
        }
    }
}
