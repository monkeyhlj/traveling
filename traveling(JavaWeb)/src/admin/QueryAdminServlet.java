package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryAdminServlet
 */
public class QueryAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Adminjdbc sd=new Adminjdbc();
		try{
			ArrayList<Admin> list = sd.queryAdmin();	
			request.setAttribute("list", list);
			RequestDispatcher dis=request.getRequestDispatcher("Role/index.jsp");
			dis.forward(request,response);
	       }catch(Exception e){
				e.printStackTrace();
				
			}
	}

}
