package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.IO;

/**
 * Servlet implementation class get
 */
@WebServlet("/GetTxt")
public class GetTxt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTxt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titlString=null,mainString=null,pathString=null,doString=null;
		
		doString = request.getParameter("do");
		if(doString!=null)
		{
			titlString = request.getParameter("title");
			mainString = request.getParameter("main");
			
		}
		pathString = request.getParameter("filepath");
		IO io  = new IO(pathString);
		System.out.println(io.getfilenameString());
		String reString  = io.read();
		System.out.println(reString);
		HttpSession session =  request.getSession();
		session.setAttribute("a", reString);
		if(doString==null)
			response.sendRedirect("Show/showDocText.jsp");
		else {
			session.setAttribute("title", titlString);
			session.setAttribute("main", mainString);
			session.setAttribute("path", pathString);
			response.sendRedirect("update/update.jsp");

			
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
