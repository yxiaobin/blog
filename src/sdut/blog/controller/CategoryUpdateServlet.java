package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.CategoryDaoImpl;
import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.Category;
import sdut.blog.domain.User;

/**
 * Servlet implementation class CategoryUpdateServlet
 */
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String h1 = request.getParameter("show");
		String h2 = request.getParameter("id");
		String h3 = request.getParameter("num");
		int num = Integer.parseInt(h3);
		int id = Integer.parseInt(h2);
		int show = Integer.parseInt(h1);
		System.out.println(id+" ### "+name+" "+show );
		if(name == "") {
			out.write("<script>alert('请保证输入的数据完全')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/CategoryServlet ' "+ " </script>");
		}else {
			Category category = new Category();
			category.setId(id);
			category.setName(name);
			category.setShow(show);
			category.setNum(num);
			
			CategoryDaoImpl categoryop = new CategoryDaoImpl();
			categoryop.UpdateCategory(category);
			response.sendRedirect(request.getContextPath()+"/CategoryServlet");
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
