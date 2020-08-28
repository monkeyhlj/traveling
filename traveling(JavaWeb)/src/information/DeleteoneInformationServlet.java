package information;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteoneInformationServlet
 */
public class DeleteoneInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname=request.getParameter("cname");
		Informationjdbc t=new Informationjdbc();  
		try {
			List<Information> list=t.InformationByCname(cname);
			Information st=list.get(0);
			request.setAttribute("q", st);
			RequestDispatcher dis=request.getRequestDispatcher("Menu/deleteinformation.jsp");
			dis.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
