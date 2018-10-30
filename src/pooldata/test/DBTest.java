package pooldata.test;

import org.junit.Test;
import pooldata.pool.PoolData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    @Test
    public void select(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        PoolData pd=new PoolData();

        try {
            conn = pd.getConnection();
            String sql="select * from admin";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println();
            pd.backConnection(conn);
        }
    }
}
