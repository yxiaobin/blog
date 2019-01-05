package sdut.blog.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.dao.impl.CategoryDaoImpl;
import sdut.blog.domain.Article;
import sdut.blog.domain.Category;
import sdut.blog.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ShowArticleListServlet
 */
public class ShowArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticleListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		String h = request.getParameter("id");
		int id = Integer.parseInt(h);
		ArticleServiceImpl op = new ArticleServiceImpl();
		ArrayList<Article> list = new ArrayList<Article>();
		list = op.SearchArticleByCategoryId(id);
		System.out.println(list.size()+"####");
		request.setAttribute("showarticlelist", list);
		request.getRequestDispatcher("/view/show/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
