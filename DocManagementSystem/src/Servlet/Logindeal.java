package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Db;

/**
 * Servlet implementation class logindeal
 */
@WebServlet("/Logindeal")
public class Logindeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logindeal() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Db db = new Db();
		String userString = request.getParameter("id");
		String passString = request.getParameter("password");
		String realpassString = db.querryPass(userString);
		HttpSession session  = request.getSession();
		if(realpassString==null)
		{
			response.sendRedirect("can/login.jsp");
		}
		else {
			if(realpassString.equals(passString))
			{
				session.setAttribute("id", userString);
				response.sendRedirect("daohang/index.jsp");
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
