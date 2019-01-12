package sdut.blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.CategoryDaoImpl;
import sdut.blog.domain.Category;

/**
 * Servlet implementation class CategoryDeleteServlet
 */
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//����UTF-8����ʾҳ������ͺ��ַ���
		String s= request.getParameter("id");
		int id = Integer.parseInt(s);
		CategoryDaoImpl categoryop = new CategoryDaoImpl();
		Category category = new Category();
		int member_id = (int) request.getSession().getAttribute("user_id");
		category = categoryop.SearchCategoryByID(member_id, id);
		//ɾ����ѡ�ķ���
		categoryop.DelCategory(member_id,category);
		//���������ķ���
		ArrayList<Category> list = categoryop.SearchCategorys(member_id);
		int i =1;
		Iterator it1 = list.iterator();
	    while(it1.hasNext()){
	    	 Category category1 = (Category) it1.next();
	    	 category1.setNum(i);
	    	 categoryop.UpdateCategory(member_id, category1);
	    	 i++;
	     }
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
