package com.example.administrator.traveling.login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

//yxq
    //保存管理员信息
    public void saveadmin(String name,String password)
    {
        String lid=null;
        //MySQL 语句
        String sql="insert into manager values(?,?)";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, password);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }


//删除管理员

    public void deleteadmin(String name){
        //结果存放集合
        ArrayList<Admin> list=new ArrayList<Admin>();
        //MySQL 语句
        String sql="delete from manager where mgname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                //PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,name);
                if(ps!=null){
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }


    /* 查询管理员信息byiname */
    public ArrayList<Admin> queryadmin(String name){
        //结果存放集合
        ArrayList<Admin> list=new ArrayList<Admin>();
        //MySQL 语句
        String sql="select * from manager where mgname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();

        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,name);
                if(ps!=null){
                    rs= ps.executeQuery();
                    if(rs!=null){
                        while(rs.next()){
                            String username=rs.getString(1);
                            String password=rs.getString(2);
                            Admin qu=new Admin(username,password);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }




//tjy
    //删除用户根据名字删除
    public void deleteuser(String name){
        //结果存放集合
        ArrayList<User> list=new ArrayList<User>();
        //MySQL 语句
        String sql="delete from user where username=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                //PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,name);
                if(ps!=null){
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }


    /* 查询用户信息byiname */
    public ArrayList<User> queryuser(String name){
        //结果存放集合
        ArrayList<User> list=new ArrayList<User>();
        //MySQL 语句
        String sql="select * from user where username=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();

        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,name);
                if(ps!=null){
                    rs= ps.executeQuery();
                    if(rs!=null){
                        while(rs.next()){
                            String username=rs.getString(1);
                            String password=rs.getString(2);
                            User qu=new User(username,password);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }






    /**
     * 修改管理员
     * */
    public void updateadmin(String s1,String s2)
    {
        String lid=null;
        //MySQL 语句
        String sql="update manager set mgname=?,mgpsw=? where mgname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s1);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }



    /**
     * 修改用户
     * */
    public void updateuser(String s1,String s2)
    {
        String lid=null;
        //MySQL 语句
        String sql="update user set username=?,password=? where username=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s1);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }





    /**
     * 修改菜单
     * */
    public void updateinfo(String s1,String s2,String s3,String s4)
    {
        String lid=null;
        //MySQL 语句
        String sql="update information set lid=?,cname=?,place=?,special=? where cname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s3);
                ps.setString(4,s4);
                ps.setString(5,s2);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }





    /**
     * 删除菜单
     * */
    public void deleteinfo(String key)
    {
        String lid=null;
        //MySQL 语句
        String sql="delete from information where cname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,key);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }



    /**
     * 新增菜单
     * */
    public void addinfo(String s1,String s2,String s3,String s4)
    {
        String lid=null;
        //MySQL 语句
        String sql="insert into information values(?,?,?,?)";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s3);
                ps.setString(4,s4);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }





    /* 查询菜单信息byiname */
    public ArrayList<Information> queryinfobyname(String key)
    {
        ArrayList<Information> list=new ArrayList<Information>();
        //MySQL 语句
        String sql="select * from information where cname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,key);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            String lid1=rs.getString(1);
                            String cname=rs.getString(2);
                            String place=rs.getString(3);
                            String special=rs.getString(4);
                            Information qu=new Information(lid1,cname,place,special);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }









    /* 查询菜单信息byid  */
    public ArrayList<Information> queryinfobyid(String key)
    {
        ArrayList<Information> list=new ArrayList<Information>();
        //MySQL 语句
        String sql="select * from information where lid=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,key);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            String lid1=rs.getString(1);
                            String cname=rs.getString(2);
                            String place=rs.getString(3);
                            String special=rs.getString(4);
                            Information qu=new Information(lid1,cname,place,special);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }






    /* 搜索管理员信息  */
    public ArrayList<Admin> selectadmin()
    {
        ArrayList<Admin> list=new ArrayList<Admin>();
        //MySQL 语句
        String sql="select * from manager";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            String name=rs.getString(1);
                            String psw=rs.getString(2);
                            Admin qu=new Admin(name,psw);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }






    /* 搜索用户信息  */
    public ArrayList<User> selectuser()
    {
        ArrayList<User> list=new ArrayList<User>();
        //MySQL 语句
        String sql="select * from user";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            String name=rs.getString(1);
                            String psw=rs.getString(2);
                            User qu=new User(name,psw);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }




    /* 搜索菜单信息  */
    public ArrayList<Information> selectinfo()
    {
        ArrayList<Information> list=new ArrayList<Information>();
        //MySQL 语句
        String sql="select * from information";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            String lid1=rs.getString(1);
                            String cname=rs.getString(2);
                            String place=rs.getString(3);
                            String special=rs.getString(4);
                            Information qu=new Information(lid1,cname,place,special);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }





/* 搜索菜单信息byid  */
    public ArrayList<Information> selectinfobyid(String key)
    {
        ArrayList<Information> list=new ArrayList<Information>();
        //MySQL 语句
        String sql="select * from information where lid=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,key);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            String lid1=rs.getString(1);
                            String cname=rs.getString(2);
                            String place=rs.getString(3);
                            String special=rs.getString(4);
                            Information qu=new Information(lid1,cname,place,special);
                            list.add(qu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }




    /**
     * 获取地点信息
     * */
    public String selectplace(String key)
    {
        String lid=null;
        //MySQL 语句
        String sql="select lid from location where lname=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,key);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            lid=rs.getString(1);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return lid;
    }




    /**
     * 获取用户信息    查
     * */

    public boolean selectUserData(String username,String psw)
    {
        boolean result=false;
        //MySQL 语句
        String sql="select * from user where username=? and password=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
            try {
                if(conn!=null&&(!conn.isClosed()))
                {
                    ps= (PreparedStatement) conn.prepareStatement(sql);
                    ps.setString(1,username);
                    ps.setString(2,psw);
                    if(ps!=null)
                    {
                        rs= ps.executeQuery();
                        if(rs!=null)
                        {
                            while(rs.next())
                            {
                               result=true;
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return result;
    }


    /**
     * 获取管理员信息    查
     * */

    public boolean selectManagerData(String username,String psw)
    {
        boolean result=false;
        //MySQL 语句
        String sql="select * from manager where mgname=? and mgpsw=?";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,psw);
                if(ps!=null)
                {
                    rs= ps.executeQuery();
                    if(rs!=null)
                    {
                        while(rs.next())
                        {
                            result=true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return result;
    }



    /**
     * 用户注册
     * */
    //新增用户
    public void saveuser(String s1,String s2)
    {
        String lid=null;
        //MySQL 语句
        String sql="insert into user values(?,?)";
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed()))
            {
                ps= (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1,s1);
                ps.setString(2,s2);
                if(ps!=null)
                {
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
    }



}

