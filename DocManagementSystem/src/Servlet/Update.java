package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import Bean.IO;

/**
 * Servlet implementation class update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String textString = request.getParameter("text");
		System.out.println(textString);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String father = "D:\\jsp\\DocManagementSystem\\";
		String filepathString  = "doc/1.txt";
		response.setContentType("text/html;charset=UTF-8");
		String titleString = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		String mainString = new String(request.getParameter("main").getBytes("ISO-8859-1"),"UTF-8");
		String textString = URLDecoder.decode((String)request.getParameter("text1"),"UTF-8");
		String pathString= (String)request.getSession().getAttribute("path");
		
		System.out.print(mainString);
		//String textString = new String(request.getParameter("text1").getBytes("ISO-8859-1"),"UTF-8");
		
		IO io = new IO(pathString);
		System.out.println(textString);
		io.write(textString);
		PrintWriter writer = response.getWriter();
		writer.print("修改数据成功");
		writer.flush();
		
		
		
	}

}
