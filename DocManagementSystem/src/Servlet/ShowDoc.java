package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Db;
import Bean.Dividepage;
import Bean.DocInf;

/**
 * 分页返回
 * 信息
 * get page
 * 通过在session中存储return ArrayList<DocInf> pageListsArrayList
 */
@WebServlet("/ShowDoc")
public class ShowDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page =-1 ;
		String pageString  = request.getParameter("page");
		if(pageString==null)
		{
			page = 1;
		}
		else {
			page = Integer.parseInt(pageString);
		}		
		HttpSession session = request.getSession();
		Dividepage dividepage;
		int rows = 0;
		Db db = new Db();
			rows  = db.getdocnums();
			//System.out.println("rows是"+rows);
			dividepage = new Dividepage(rows);
			session.setAttribute("rows", rows);
			session.setAttribute("dividepage",dividepage);
			
		
		//System.out.print(dividepage.totalpage);
		int min =1,max=dividepage.getpages();
		if(page<min)
			page=min;
		if(page>max)
			page = max;
		int st[] = dividepage.getStartend(page);
		//System.out.println("起始是"+st[0]+"终止是"+st[1]);
		ArrayList<DocInf> pageListsArrayList = db.getDividePages(st[0], st[1]);
//		for(DocInf tempDocInf:pageListsArrayList)
//		{
//			System.out.println(tempDocInf.getTitle());
//		}
		session.setAttribute("page", dividepage.getpages());
		session.setAttribute("nowpage", page);
		System.out.println(dividepage.getpages());
		session.setAttribute("pagelist", pageListsArrayList);
		response.sendRedirect("Show/showdoc.jsp");
		
		
	
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
