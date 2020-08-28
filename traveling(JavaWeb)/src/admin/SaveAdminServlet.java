package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.comfirm;

/**
 * Servlet implementation class SaveAdminServlet
 */
public class SaveAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Adminjdbc uj=new Adminjdbc();
		comfirm c=new comfirm();
		try {
			if(c.com(username)){
				uj.saveAdmin(username, password);
				response.sendRedirect("Role/add.jsp");}
			else {
				RequestDispatcher dis=request.getRequestDispatcher("Role/addfail.jsp");
				dis.forward(request, response);
				} 
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
