package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.Article;
import sdut.blog.domain.User;

/**
 * Servlet implementation class ArticleDeletServlet
 */
public class ArticleDeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDeletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		PrintWriter out = response.getWriter();
		String s = request.getParameter("id");
		int id = Integer.parseInt(s);
		ArticleDaoImpl  op = new ArticleDaoImpl();
		Article p = new Article();
		p.setId(id);
		op.DelArticle(p);
		System.out.println("删除成功");
		response.sendRedirect(request.getContextPath()+"/ArticleServlet?");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
