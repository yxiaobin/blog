package sdut.blog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserCheck
 */
public class UserCheck implements Filter {

    /**
     * Default constructor. 
     */
    public UserCheck() {
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
		// TODO Auto-generated method stub
		// place your code here
		  HttpServletRequest req = (HttpServletRequest) request;
	      HttpServletResponse rsp = (HttpServletResponse) response;
	      System.out.println("222");
	      HttpSession session = req.getSession();
	      
	 
	      if(session==null || session.getAttribute("user_id")==null) {
	    	  rsp.sendRedirect(req.getContextPath()+"/view/login/login.jsp");
	    	  
	      }else {
	    	  chain.doFilter(request, response);
	      }
		//System.out.println("登录后台前请先检测这个");
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
