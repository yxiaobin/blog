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
import sdut.blog.domain.Page;
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
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//����UTF-8����ʾҳ������ͺ��ַ���
		String h = request.getParameter("id");
		String pagenum = request.getParameter("pagenum");
		if(Integer.parseInt(h)!=-1) {
			int id = Integer.parseInt(h);
			ArticleServiceImpl op = new ArticleServiceImpl();
			ArrayList<Article> list = new ArrayList<Article>();
			ArrayList<Article> list1 = new ArrayList<Article>();
//			��ȡ��ǰ��������е�����
			//list = op.SearchArticleByCategoryId(id);
			int total = op.SearchArticleByCategoryId(id).size();
			//��ҳ
			Page page = new Page(Integer.parseInt(pagenum),total);
//			��ѯlist
			list = op.SearchArticlesByCategoryIdandPage(id, page);
			request.setAttribute("page", page);
			request.setAttribute("pagecategoryid", id);
			Category p = new Category();
			p.setId(id);
			request.setAttribute("categoryname", p.getCategoryName());
			request.setAttribute("pagenum", Integer.parseInt(pagenum));
			request.setAttribute("showarticlelist", list);
		}else {
			ArticleServiceImpl op = new ArticleServiceImpl();
			ArrayList<Article> list = new ArrayList<Article>();
			//��ȡ��ǰ��������е�����
			//list = op.SearchArticleByCategoryId(id);
			int total = op.SearchArticles().size();
			//��ҳ
			Page page = new Page(Integer.parseInt(pagenum),total);
//			��ѯlist
			list = op.SearchArticlesandPage( page);
			request.setAttribute("page", page);
			request.setAttribute("pagecategoryid", -1);
			request.setAttribute("pagenum", Integer.parseInt(pagenum));
			request.setAttribute("showarticlelist", list);
		}
		
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