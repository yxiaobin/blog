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
 * Servlet implementation class CategoryDownServlet
 */
public class CategoryDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//����UTF-8����ʾҳ������ͺ��ַ���
		PrintWriter out = response.getWriter();
		String s = request.getParameter("id");
		int id = Integer.parseInt(s);
		CategoryDaoImpl op = new CategoryDaoImpl();
//		��ȡ��ǰ�ķ������
		Category c1 =op.SearchCategoryByID(id);
//		��ѯc1��num-1����һ������
		Category c2 = op.SearchCategoryByNum(c1.getNum()+1);
		c1.setNum(c1.getNum()+1);
		c2.setNum(c2.getNum()-1);
		op.UpdateCategory(c1);
		op.UpdateCategory(c2);
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