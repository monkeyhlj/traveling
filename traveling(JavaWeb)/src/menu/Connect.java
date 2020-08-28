package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connect {

	public static PreparedStatement getCon(String sql) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
		Connection con = DriverManager.getConnection(url, "root", "123456");
		PreparedStatement pre = con.prepareStatement(sql);
		//con.close();
		return pre;
	}

}
