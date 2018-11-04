package pooldata.c3p0.test;

import org.junit.Test;
import pooldata.c3p0.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {

    //查询全部
    @Test
    public void select(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            conn=C3P0Utils.getConnection();
            String sql="select * from admin";
            pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.release(conn,pstmt,rs);
        }
    }

    //添加一条
    @Test
    public void insert(){

        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn = C3P0Utils.getConnection();
            String sql="insert into admin values (null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"nodine");
            pstmt.setString(2,"nodine");

            int row=pstmt.executeUpdate();
            if (row>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            C3P0Utils.release(conn,pstmt,null);
        }
    }

    //修改一条
    @Test
    public void update(){
        Connection conn=null;
        PreparedStatement pstmt=null;

        try {
            conn=C3P0Utils.getConnection();
            String sql="update admin set adminname=?,adminpwd=? where admin_id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"arthas");
            pstmt.setString(2,"arthas");
            pstmt.setInt(3,34);
            int rows = pstmt.executeUpdate();
            if (rows>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            C3P0Utils.release(conn,pstmt,null);
        }
    }

    //删除一条
    @Test
    public void delete(){
        Connection conn=null;
        PreparedStatement pstmt=null;

        try {
            conn = C3P0Utils.getConnection();
            String sql="delete from admin where admin_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,34);
            int rows = pstmt.executeUpdate();
            if (rows>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.release(conn,pstmt,null);
        }

    }
}
