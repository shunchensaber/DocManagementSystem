package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="log",urlPatterns={"/*"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession();
		String pathString  = httpServletRequest.getRequestURL().toString();
		if(pathString.indexOf("login")>=0||pathString.indexOf("zc")>=0||pathString.indexOf("Logindeal")>=0)
		{	
			chain.doFilter(request, response);
			return;
		}
		if(session.getAttribute("id")!=null)
		{
			chain.doFilter(request, response);
			return;
		}
		
		httpServletResponse.sendRedirect("../can/login.jsp");
//		String pathString =  request.getLocalAddr();
//		System.out.println(pathString);
//		pathString = request.getLocalName();

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
