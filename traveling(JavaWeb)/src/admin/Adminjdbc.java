package admin;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Adminjdbc {
	public ArrayList<Admin> queryAdmin() throws Exception {
		String sql="select * from manager";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		ResultSet res=pre.executeQuery();
		ArrayList<Admin> list=new ArrayList<Admin>();
		while(res.next()){
			String username2=res.getString(1);
			String password2=res.getString(2);
			Admin qu=new Admin(username2,password2);
			list.add(qu);
		}
		return list;
	}
	
	public void deleteAdmin(String mgname) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from manager where mgname=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1,mgname);
		pre.execute();
		con.close();
	}
	
	
	public ArrayList<Admin> AdminByName(String mgname) throws Exception {
		String sql="select * from manager where mgname=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, mgname);
		ResultSet res=pre.executeQuery();
		ArrayList<Admin> list=new ArrayList<Admin>();
		while(res.next()){
			String username1=res.getString(1);
			String password1=res.getString(2);
			Admin qu=new Admin(username1,password1);
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
		
		return pre;
	}
	
	public void updateAdmin(String mgname,String password) throws Exception{
		String sql="update manager set mgname=?,mgpsw=? where mgname=?";
		PreparedStatement pre=Adminjdbc.getCon(sql);
		pre.setString(1,mgname);
		pre.setString(2,password);
		pre.setString(3,mgname);
		pre.execute();
	}
	
	public void saveAdmin(String mgname,String password) throws Exception{
		String sql="insert into manager values(?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con=DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, mgname);
		pre.setString(2, password);
		pre.execute();
		con.close();
	}

}
