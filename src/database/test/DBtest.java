package database.test;

import database.utils.DBUtils;
import org.junit.Test;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBtest {
    /**
     * 查询所有
     */
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

    /**
     * 查询一条
     */
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

    /**
     * 添加
     */
    @Test
    public void insert(){
        Connection conn=null;
        PreparedStatement pstmt=null;

        try {
            conn = DBUtils.getConnection();
            String sql="insert into admin values(null,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"张三");
            pstmt.setString(2,"zhangsan");
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(conn,pstmt,null);
        }
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        Connection conn=null;
        PreparedStatement pstmt=null;

        try {
            conn=DBUtils.getConnection();
            String sql="update admin set adminname=?,adminpwd=? where admin_id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"李四");
            pstmt.setString(2,"lisi");
            pstmt.setInt(3,3);
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(conn,pstmt,null);
        }
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        Connection conn=null;
        PreparedStatement pstmt=null;

        try {
            conn=DBUtils.getConnection();
            String sql="delete from admin where admin_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,3);
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(conn,pstmt,null);
        }
    }
}