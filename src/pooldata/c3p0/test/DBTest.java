package pooldata.c3p0.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import pooldata.c3p0.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
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


}
