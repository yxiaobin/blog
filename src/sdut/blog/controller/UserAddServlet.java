package sdut.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.User;
import sdut.blog.utils.Encrypt;

/**
 * Servlet implementation class AddUserServlet
 */
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
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
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		int rank = Integer.parseInt(request.getParameter("rank"));
		System.out.println(" "+username+" "+name+" "+ password +" "+ email );
		if(username == "" || password == "" || email == "" || name == "" ) {
			out.write("<script>alert('请保证输入的数据完全')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/UserServlet ' "+ " </script>");
		}else {
			
			User user = new User();
			user.setEmail(email);
			user.setName(name);
			try {
				user.setPassword(Encrypt.encrypt(password));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setUsername(username);
			user.setRank(rank);
			UserDaoImpl  userop =  new UserDaoImpl();
			User judge = userop.SearchUserByUsername(username);
			if(judge.getId() != -1) {
				out.write("<script>alert('该账户已经存在了，请重新选择新的用户名')</script>");
				out.write("<script>window.location.href=' " +request.getContextPath()+"/UserServlet' "+ " </script>");
			}else {
				userop.AddUser(user);
				System.out.println("添加成功");
				response.sendRedirect(request.getContextPath()+"/UserServlet");
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
