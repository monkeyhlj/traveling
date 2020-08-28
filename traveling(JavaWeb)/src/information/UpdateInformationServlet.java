package information;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInformationServlet
 */
public class UpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String lid=request.getParameter("lid");
		String cname=request.getParameter("cname");
		String place=request.getParameter("place");
		String special=request.getParameter("special");
		
		Informationjdbc qu=new Informationjdbc();
		try{
			qu.updateInformation(lid, cname, place, special);
			RequestDispatcher dis=request.getRequestDispatcher("QueryInformation");
			dis.forward(request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
