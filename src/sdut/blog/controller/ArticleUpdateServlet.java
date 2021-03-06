package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.domain.Article;

/**
 * Servlet implementation class ArticleUpdateSerevlet
 */
public class ArticleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleUpdateServlet() {
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
		String pagenum = request.getParameter("pagenum");
		String title = request.getParameter("title");
		String s  = request.getParameter("category_id");
		String keyword = request.getParameter("keyword");
		String content = request.getParameter("editorValue");
		String h= request.getParameter("judge");
		String i = request.getParameter("id");
		int judge  = Integer.parseInt(h); 
		if(judge==1) {
			ArticleDaoImpl op = new ArticleDaoImpl();
			Article article = op.SearchArticleByID(Integer.parseInt(i));
			System.out.println(judge+"panduan");
			article.setJudge(judge);
			op.UpdateArticle(article);
			response.sendRedirect(request.getContextPath()+"/ArticleServlet?pagenum="+pagenum);
			
		}
		else if(title=="" || s=="" || keyword=="" || content=="") {
			out.write("<script>alert('请保证输入的数据完全')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/ArticleServlet' "+ " </script>");
		}else {
			int category_id = Integer.parseInt(s);
			int member_id =  (int) request.getSession().getValue("user_id");
			Article p = new Article(member_id, category_id, title, content, keyword,judge);
			p.setId(Integer.parseInt(i));
			ArticleDaoImpl op = new ArticleDaoImpl();
			op.UpdateArticle(p);
			System.out.println("更新成功");
			response.sendRedirect(request.getContextPath()+"/ArticleServlet?pagenum="+pagenum);
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
