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
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//����UTF-8����ʾҳ������ͺ��ַ���
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
		WebDaoImpl op = new WebDaoImpl();
		op.UpdateWebByid(web);
		response.sendRedirect(request.getContextPath()+"/view/web/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
