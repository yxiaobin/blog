package sdut.blog.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.Article;
import sdut.blog.domain.Page;
import sdut.blog.domain.User;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pagenum = request.getParameter("pagenum");
		ArticleDaoImpl  op = new ArticleDaoImpl();
		//获取当前所有的文章数量
		int total = op.SearchArticleCount();
		System.out.println(total);
		Page page = new Page(Integer.parseInt(pagenum),total);
		request.setAttribute("page", page);
		int start =page.getStartindex();
		int id = (int) request.getSession().getAttribute("user_id");
		ArrayList<Article> article_list = (ArrayList<Article>) op.SearchArticleByStartIndex( id , page.getStartindex(), page.getPagesize());
		request.setAttribute("article_list", article_list);
		System.out.println(article_list.size()+"###");
		request.getRequestDispatcher("/view/article/index.jsp?pagenum="+page.getPagenum()).forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/view/article/index.jsp?pagenum="+page.getPagenum());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
