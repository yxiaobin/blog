package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.CategoryDaoImpl;
import sdut.blog.domain.Category;

/**
 * Servlet implementation class CategoryUpServlet
 */
public class CategoryUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryUpServlet() {
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
		int member_id = (int) request.getSession().getAttribute("user_id");
		CategoryDaoImpl op = new CategoryDaoImpl();
//		获取当前的分类对象
		Category c1 =op.SearchCategoryByID(member_id,id);
//		查询c1的num-1是哪一个对象
		Category c2 = op.SearchCategoryByNum(member_id,c1.getNum()-1);
		c1.setNum(c1.getNum()-1);
		c2.setNum(c2.getNum()+1);
		op.UpdateCategory(member_id,c1);
		op.UpdateCategory(member_id,c2);
		response.sendRedirect(request.getContextPath()+"/CategoryServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
