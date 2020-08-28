package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("username"); 
		String psw=request.getParameter("password"); 
		
		try {
			String sql="select * from user where username=? and password=?";
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
			Connection con=DriverManager.getConnection(url,"root","123456");
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, psw);
			pre.execute();
			ResultSet res=pre.executeQuery();
			boolean t =res.next();
			request.setAttribute("t", t);
			request.setAttribute("name", name);
			RequestDispatcher dis=request.getRequestDispatcher("login1.jsp");
			dis.forward(request, response);
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}

}
