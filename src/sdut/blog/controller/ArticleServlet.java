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
		System.out.println("页数"+pagenum);
		ArticleDaoImpl  op = new ArticleDaoImpl();
		int rank =  (int) request.getSession().getAttribute("rank");
		ArrayList<Article> article_list = new ArrayList<Article>();
		int total;
		Page page;
		//普通用户(rank为0)显示当前所有个人文章，超级用户(rank为1)显示当前所用未审核通过的文章
		if(rank==1) {
			total = op.SearchUnjudgeArticleCount();
			 page = new Page(Integer.parseInt(pagenum),total);
			 article_list = op.SearchUnjudgeArticleByStartIndex(page.getStartindex(), page.getPagesize());
			
		}else {
			 total = op.SearchArticleCount(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
			 page = new Page(Integer.parseInt(pagenum),total);
			 int id = (int) request.getSession().getAttribute("user_id");
		     article_list = (ArrayList<Article>) op.SearchArticleByStartIndex( id , page.getStartindex(), page.getPagesize());
				
		}
		request.setAttribute("page", page);
		request.setAttribute("article_list", article_list);
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
