package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.domain.Article;

/**
 * Servlet implementation class ArticleAddServlet
 */
public class ArticleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String s  = request.getParameter("category_id");
		int category_id = Integer.parseInt(s);
		String keyword = request.getParameter("keyword");
		String content = request.getParameter("editorValue");
		
		int member_id =  (int) request.getSession().getValue("user_id");
		
		if(title=="" || s=="" || keyword=="" || content=="") {
			out.write("<script>alert('请保证输入的数据完全')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/ArticleServlet' "+ " </script>");
		}else {
			Article p = new Article(member_id, category_id, title, content, keyword);
			ArticleDaoImpl op = new ArticleDaoImpl();
			op.AddArticle(p);
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
