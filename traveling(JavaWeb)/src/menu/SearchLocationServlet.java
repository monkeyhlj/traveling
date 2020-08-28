package menu;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import menu.Connect;
/**
 * Servlet implementation class SearchLocationServlet
 */
public class SearchLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String key=request.getParameter("key");
		String lid=null;
		Infojdbc in=new Infojdbc();
		try {
			String sql="select lid from location where lname=?";
			PreparedStatement pre=Connect.getCon(sql);
			pre.setString(1, key);
			ResultSet res=pre.executeQuery();
			while(res.next()){
				lid=res.getString(1);
			}
			ArrayList<Information> list=in.InformationById(lid);
			request.setAttribute("list", list);
			request.setAttribute("key", key);
			RequestDispatcher dis=request.getRequestDispatcher("Menu/usersee.jsp");
			dis.forward(request,response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
