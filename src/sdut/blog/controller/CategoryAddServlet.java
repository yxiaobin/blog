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
 * Servlet implementation class CategoryAddServlet
 */
public class CategoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAddServlet() {
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
		String name= request.getParameter("name");
		String h = request.getParameter("show");
		
		if(name=="") {
			out.write("<script>alert('请保证输入的数据正确并完全')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/CategoryServlet ' "+ " </script>");
		}
	  else {
	    	CategoryDaoImpl categoryop = new CategoryDaoImpl();
			Category category = new Category();
	    	int show = Integer.parseInt(h);
	    	category.setName(name);
			category.setShow(show);
			int member_id = (int) request.getSession().getAttribute("user_id");
			int is = categoryop.AddCategory(member_id,category);
			if(is==1) {
				response.sendRedirect(request.getContextPath()+"/CategoryServlet");
			}
			else {
				out.write("<script>alert('添加分类失败')</script>");
				out.write("<script>window.location.href=' " +request.getContextPath()+"/CategoryServlet ' "+ " </script>");
			}
			
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
