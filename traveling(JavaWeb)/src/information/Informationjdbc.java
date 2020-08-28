package information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Informationjdbc {
	public ArrayList<Information> queryInformation() throws Exception {
		String sql="select * from information";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		ResultSet res=pre.executeQuery();
		ArrayList<Information> list=new ArrayList<Information>();
		while(res.next()){
			String lid1=res.getString(1);
			String cname1=res.getString(2);
			String place1=res.getString(3);
			String special=res.getString(4);
			Information qu=new Information(lid1,cname1,place1,special);
			list.add(qu);
		}
		return list;
	}
	
	public void deleteInformation(String cname) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from information where cname=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1,cname);
		pre.execute();
		con.close();
	}
	
	
	public ArrayList<Information> InformationByLid(String lid) throws Exception {
		String sql="select * from information where lid=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, lid);
		ResultSet res=pre.executeQuery();
		ArrayList<Information> list=new ArrayList<Information>();
		while(res.next()){
			String lid1=res.getString(1);
			String cname1=res.getString(2);
			String place1=res.getString(3);
			String special1=res.getString(4);
			Information qu=new Information(lid1,cname1,place1,special1);
			list.add(qu);
		}
		con.close();
		return list;
	}
	
	public ArrayList<Information> InformationByCname(String cname) throws Exception {
		String sql="select * from information where cname=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, cname);
		ResultSet res=pre.executeQuery();
		ArrayList<Information> list=new ArrayList<Information>();
		while(res.next()){
			String lid1=res.getString(1);
			String cname1=res.getString(2);
			String place1=res.getString(3);
			String special1=res.getString(4);
			Information qu=new Information(lid1,cname1,place1,special1);
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
	
	public void updateInformation(String lid,String cname,String place,String special) throws Exception{
		String sql="update information set lid=?,cname=?,place=?,special=? where cname=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
		java.sql.PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1,lid);
		pre.setString(2,cname);
		pre.setString(3,place);
		pre.setString(4,special);
		pre.setString(5,cname);
		pre.execute();
	}
	
	public void saveInformation(String lid,String cname,String place,String special) throws Exception{
		String sql="insert into information values(?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con=DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, lid);
		pre.setString(2, cname);
		pre.setString(3, place);
		pre.setString(4, special);
		pre.execute();
		con.close();
	}
}
