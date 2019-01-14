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
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		String h1 = request.getParameter("id");
		String  h2= request.getParameter("member_id");
		String h3= request.getParameter("pagenum");
		int category_id = Integer.parseInt(h1);
		int member_id = Integer.parseInt(h2);
		int pagenum = Integer.parseInt(h3);
		//id不为-1，则显示该用户的分类文章，id为-1，显示该用户的所有文章
		if(Integer.parseInt(h1)!=-1) {
			int id = Integer.parseInt(h1);
			ArticleDaoImpl op = new ArticleDaoImpl();
			ArrayList<Article> list = new ArrayList<Article>();
			int total = op.SearchArticleCountByCategoryId(member_id, category_id);
			//分页
			Page page = new Page(pagenum,total);
//			查询list
			list = op.SearchArticleByCategoryIdAndMemberIdAndStartIndex(category_id, member_id, page.getStartindex(), page.getPagesize());
			request.setAttribute("page", page);
			request.setAttribute("pagecategoryid", id);
			Category p = new Category();
			p.setId(id);
			request.setAttribute("categoryname", p.getCategoryName());
			request.setAttribute("pagenum", pagenum);
			request.setAttribute("showarticlelist", list);
		}else {
			ArticleDaoImpl op = new ArticleDaoImpl();
			ArrayList<Article> list = new ArrayList<Article>();
			//获取当前分类的所有的文章
			//list = op.SearchArticleByCategoryId(id);
			int total = op.SearchMemberArticleCount(member_id);
			//分页
			Page page = new Page(pagenum,total);
//			查询list
			list = op.SearchArticleByMemberIdAndStartIndex(member_id, page.getStartindex(), page.getPagesize());
			request.setAttribute("page", page);
			request.setAttribute("pagecategoryid", -1);
			request.setAttribute("pagenum", pagenum);
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
