package com.example.administrator.traveling;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private Connection conn=null; //打开数据库对象
    private PreparedStatement ps=null;//操作整合sql语句的对象
    private ResultSet rs=null;//查询结果的集合

    //DBService 对象
    public static DBService dbService=null;

    /**
     * 构造方法 私有化
     * */

    public DBService(){

    }

    /**
     * 获取MySQL数据库单例类对象
     * */

    public static DBService getDbService(){
        if(dbService==null){
            dbService=new DBService();
        }
        return dbService;
    }


    /**
     * 获取用户信息    查
     * */

    public List<User> getUserData(){
        //结果存放集合
        List<User> list=new ArrayList<User>();
        //MySQL 语句
        String sql="select * from user where username=\"hhh\"";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            try {
                if(conn!=null&&(!conn.isClosed())){
                    ps= (PreparedStatement) conn.prepareStatement(sql);
                    if(ps!=null){
                        rs= ps.executeQuery();
                        if(rs!=null){
                            while(rs.next()){
                                User u=new User();
                                String username=rs.getString(1);
                                String password=rs.getString(2);
                                User qu=new User(username,password);
                                u.toString();
                                list.add(qu);
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }


}

