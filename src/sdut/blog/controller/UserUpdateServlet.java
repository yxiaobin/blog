package sdut.blog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.MyFile;
import sdut.blog.domain.User;
import sdut.blog.utils.Encrypt;

/**
 * Servlet implementation class UserUpdateServlet
 */
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		//�޸���Ϣ��û���޸����룬ֻ��Ҫ��������ܾͺ���
		if(password =="") {
			//���������
			try {
				password = request.getSession().getAttribute("password").toString();
				password = Encrypt.decrypt(password);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		String s = request.getParameter("id");
		int rank = Integer.parseInt(request.getParameter("rank"));
		int id = Integer.parseInt(s);
		
		if(username == "" || password == "" || email == "" || name == "" ) {
			out.write("<script>alert('�뱣֤�����������ȫ')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/UserServlet ' "+ " </script>");
		}else {
			User user = new User();
			user.setRank(rank);
			user.setEmail(email);
			user.setName(name);
			try {
				user.setPassword(Encrypt.encrypt(password));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setUsername(username);
			user.setId(id);
			UserDaoImpl  userop =  new UserDaoImpl();
			userop.UpdateUser(user);
			System.out.println("���³ɹ�");
			response.sendRedirect(request.getContextPath()+"/UserServlet");
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
