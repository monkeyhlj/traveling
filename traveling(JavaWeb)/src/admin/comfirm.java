package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class comfirm {
	public boolean com(String mgname) throws Exception{
		String sql="select * from manager where mgname=?";
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con= DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, mgname);
		ResultSet res=pre.executeQuery();
		if(res.next()){
			return false;
		}else{
			return true;
		}
	}
}
