package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteoneUserServlet
 */
public class DeleteoneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("id");
		Userjdbc t=new Userjdbc();  
		try {
			List<User> list=t.UserByName(username);
			User st=list.get(0);
			//System.out.println(st.getUsername());
			request.setAttribute("q", st);
			RequestDispatcher dis=request.getRequestDispatcher("User/deleteuser.jsp");
			dis.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
