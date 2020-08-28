package regist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regist.comfirm;

/**
 * Servlet implementation class UserRegistServlet
 */
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("username"); 
		String psw=request.getParameter("password1"); 
		comfirm c=new comfirm();
			try {
				if(c.com(name)){
						String sql="insert into user values(?,?)";		
						Class.forName("com.mysql.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/traveling?characterEncoding=utf-8";
						Connection con=(Connection) DriverManager.getConnection(url, "root", "123456");
						PreparedStatement pre=(PreparedStatement) con.prepareStatement(sql);
						pre.setString(1, name);
						pre.setString(2, psw);
						pre.execute();
						con.close();		
					RequestDispatcher dis=request.getRequestDispatcher("registsuccess.jsp");
					dis.forward(request, response);
				}else{
						RequestDispatcher dis=request.getRequestDispatcher("registfail.jsp");
						dis.forward(request, response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
