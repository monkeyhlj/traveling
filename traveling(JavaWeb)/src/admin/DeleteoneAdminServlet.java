package admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteoneAdminServlet
 */
public class DeleteoneAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("id");
		Adminjdbc t=new Adminjdbc();  
		try {
			ArrayList<Admin> list=t.AdminByName(username);
			
			Admin st=list.get(0);
			
			request.setAttribute("q", st);
			RequestDispatcher dis=request.getRequestDispatcher("Role/deleteadmin.jsp");
			dis.forward(request,response);
		} catch (Exception e) {
			
		}
	}

}
