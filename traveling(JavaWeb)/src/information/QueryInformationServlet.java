package information;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryInformationServlet
 */
public class QueryInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Informationjdbc sd=new Informationjdbc();
		try{
			ArrayList<Information> list = sd.queryInformation();	
			request.setAttribute("list", list);
			RequestDispatcher dis=request.getRequestDispatcher("Menu/index.jsp");
			dis.forward(request,response);
	       }catch(Exception e){
				e.printStackTrace();
				
			}
	}

}
