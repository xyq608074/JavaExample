package pooldata.userdefined.pool;

import pooldata.userdefined.utils.DBUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class PoolData implements DataSource {
    //1.创建一个容器 池子
    private static LinkedList<Connection> pool=new LinkedList<Connection>();

    //2.创建五个连接
    static {
        for (int i=0;i<=5;i++){
            Connection conn = DBUtils.getConnection();
            pool.add(conn);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn =null;
        //3.判断池子里面是否还有连接  如果没有连接了  在池子里面再创建5个连接
        if (pool.size()==0){
            for (int i=0;i<=5;i++){
                conn = DBUtils.getConnection();
                pool.add(conn);
            }
        }
        //4.获取后从池子里面获取一个连接对象 在池子里面移除到池子外面
        conn = pool.removeFirst();
        return conn;
    }
    //归还连接
    public void backConnection(Connection conn){
        pool.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
