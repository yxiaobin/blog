package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.dao.impl.MessageDaoImpl;
import sdut.blog.domain.Article;
import sdut.blog.domain.Message;

/**
 * Servlet implementation class MessageAddServlet
 */
public class MessageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAddServlet() {
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
		
		String username = request.getParameter("username");
		String email  = request.getParameter("email");
		String content = request.getParameter("content");
		String h = request.getParameter("id");
		int id = Integer.parseInt(h);
		String member_id = request.getParameter("member_id");
		
		
		//int member_id =  (int) request.getSession().getValue("user_id");
		
		if(username=="" || email=="" || content=="") {
			out.write("<script>alert('请保证输入的数据完全')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/view/show/article.jsp?member_id="+member_id+"&id="+id+"&pagenum=1'"+ " </script>");
		}else {
			Message m = new Message(id, username, email, content);
			MessageDaoImpl op = new MessageDaoImpl();
			op.AddMessage(m);
			//out.print("留言添加成功！");
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#");
			//out.print(username+"#"+email+"#"+content);
			out.write("<script>alert('留言评论成功，请等待作者审核！')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/view/show/article.jsp?member_id="+member_id+"&id="+id+"&pagenum=1'"+ " </script>");
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
