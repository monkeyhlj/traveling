package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryUserServlet
 */
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Userjdbc sd=new Userjdbc();
		try{
			ArrayList<User> list = sd.queryUser();	
			request.setAttribute("list", list);
			RequestDispatcher dis=request.getRequestDispatcher("User/index.jsp");
			dis.forward(request,response);
	       }catch(Exception e){
				e.printStackTrace();
				
			}
	}

}
