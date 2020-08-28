package menu;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Infojdbc {
	public ArrayList<Information> InformationById(String lid) throws Exception {
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
			String cname=res.getString(2);
			String place=res.getString(3);
			String special=res.getString(4);
			Information qu=new Information(lid1,cname,place,special);
			list.add(qu);
		}
		con.close();
		return list;
	}
	

}
