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
		String h1 = request.getParameter("id");
		String  h2= request.getParameter("member_id");
		String h3= request.getParameter("pagenum");
		int category_id = Integer.parseInt(h1);
		int member_id = Integer.parseInt(h2);
		int pagenum = Integer.parseInt(h3);
		//id��Ϊ-1������ʾ���û��ķ������£�idΪ-1����ʾ���û�����������
		if(Integer.parseInt(h1)!=-1) {
			int id = Integer.parseInt(h1);
			ArticleDaoImpl op = new ArticleDaoImpl();
			ArrayList<Article> list = new ArrayList<Article>();
			int total = op.SearchArticleCountByCategoryId(member_id, category_id);
			//��ҳ
			Page page = new Page(pagenum,total);
//			��ѯlist
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
			//��ȡ��ǰ��������е�����
			//list = op.SearchArticleByCategoryId(id);
			int total = op.SearchMemberArticleCount(member_id);
			//��ҳ
			Page page = new Page(pagenum,total);
//			��ѯlist
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
