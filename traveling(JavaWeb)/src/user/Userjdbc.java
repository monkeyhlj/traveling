package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Userjdbc {
	public ArrayList<User> queryUser() throws Exception {
		String sql="select * from user";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		ResultSet res=pre.executeQuery();
		ArrayList<User> list=new ArrayList<User>();
		while(res.next()){
			String username2=res.getString(1);
			String password2=res.getString(2);
			User qu=new User(username2,password2);
			list.add(qu);
		}
		return list;
	}
	
	public void deleteUser(String username) throws Exception {
		
		String sql="delete from user where username=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1,username);
		pre.execute();
		con.close();
	}
	
	
	public ArrayList<User> UserByName(String username) throws Exception {
		String sql="select * from user where username=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, username);
		ResultSet res=pre.executeQuery();
		ArrayList<User> list=new ArrayList<User>();
		while(res.next()){
			String username1=res.getString(1);
			String password1=res.getString(2);
			User qu=new User(username1,password1);
			list.add(qu);
		}
		con.close();
		return list;
	}
	
	public static PreparedStatement getCon(String sql) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre = con.prepareStatement(sql);
		//con.close();
		return pre;
	}
	
	public void updateUser(String username,String password) throws Exception{
		String sql="update user set username=?,password=? where username=?";
		PreparedStatement pre=Userjdbc.getCon(sql);
		pre.setString(1,username);
		pre.setString(2,password);
		pre.setString(3,username);
		pre.execute();
	}
	
	public void saveUser(String username,String password) throws Exception{
		String sql="insert into user values(?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con=DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, password);
		pre.execute();
		con.close();
	}
	
}

