package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.WebDaoImpl;
import sdut.blog.domain.Web;
import sdut.blog.utils.JDBCUtil;

/**
 * Servlet implementation class WebServler
 */
public class WebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebServlet() {
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
		String webname = request.getParameter("webname");
		String webkeyword = request.getParameter("webkeyword");
		String webdescription = request.getParameter("webdescription");
		String webstyle = request.getParameter("webstyle");
		Web web = new Web();
		web.setWebdescription(webdescription);
		web.setWebkeyword(webkeyword);
		web.setWebname(webname);
		web.setWebstyle(webstyle);
		web.setMember_id(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
		WebDaoImpl op = new WebDaoImpl();
		//查询是否存在
		Web judge = op.SearchWebByMember_id(web);
		if(judge.getId() != -1) {
			web.setId(judge.getId());
			op.UpdateWebByid(web);
		}else {
			op.AddWeb(web);
			op.UpdateWebByid(web);
		}
		out.write("<script>alert('修改成功')</script>");
		out.write("<script>window.location.href=' " +request.getContextPath()+"/view/web/index.jsp ' "+ " </script>");
		//response.sendRedirect(request.getContextPath()+"/view/web/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
