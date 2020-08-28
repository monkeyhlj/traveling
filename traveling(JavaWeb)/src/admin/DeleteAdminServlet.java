package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAdminServlet
 */
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		Adminjdbc qu=new Adminjdbc();
		try{
			qu.deleteAdmin(username);
			response.sendRedirect("QueryAdmin");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
