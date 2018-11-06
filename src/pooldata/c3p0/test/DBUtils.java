package pooldata.c3p0.test;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import pooldata.c3p0.domain.User;
import pooldata.c3p0.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用DBUtils
 */
public class DBUtils {

    /**
     * 增加
     */
    @Test
    public void userInsert(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            //编写sql语句
            String sql="insert into users value(null,?,?,?,?)";
            //为占位符赋值
            Object[] params={"张飞","zhangfei","123@qq.com","2017-01-01"};
            //执行添加操作
            int rows=qr.update(sql,params);
            if (rows>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改
     */
    @Test
    public void userUpdate(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="update users set username=? where id=?";
            Object[] params={"刘备",23};
            int rows = qr.update(sql, params);
            if (rows>0){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     */
    @Test
    public void userDelete(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="delete from users where id=?";
            Object[] params={22};
            int rows = qr.update(sql, params);
            if (rows>0){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     */
    @Test
    public void userQueryAll(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            //编写sql语句
            String sql="select * from users";
            //执行查询操作
            //BeanListHandler  用于接收一个结果集封装到javaBean里面  在封装到 List 集合中
            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));

            for (User user: users) {
                System.out.println(user.getId()+"---"+user.getUsername()+"---"+user.getUserpwd()+"---"+user.getUseremail()+"---"+user.getUserbirthday());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询
     */
    @Test
    public void userQueryById(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            //编写sql语句
            String sql="select * from users where id=?";
            //为占位符赋值
            Object[] params={19};
            //执行查询操作
            //BeanHandler 将结果中第一条封装到javaBean中
            User user = qr.query(sql, new BeanHandler<User>(User.class), params);
            //显示数据
            System.out.println(user.getId()+"---"+user.getUsername()+"---"+user.getUserpwd()+"---"+user.getUseremail()+"---"+user.getUserbirthday());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据库中有多少条记录
     */
    @Test
    public void userQueryCount(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            //编写sql语句
            String sql="select count(*) from users";
            //执行查询操作
            //BeanHandler 将结果中第一条封装到javaBean中
            Object count = qr.query(sql, new ScalarHandler());
            //显示数据
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
