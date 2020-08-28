package information;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteInformationServlet
 */
public class DeleteInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cname=request.getParameter("cname");
		Informationjdbc qu=new Informationjdbc();
		try{
			qu.deleteInformation(cname);
			response.sendRedirect("QueryInformation");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
