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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String checkcode = request.getParameter("checkcode");
		int rank = 0;
		System.out.println(" "+username+" "+name+" "+ password +" "+ email );
		if(username == "" || password == "" || email == "" || name == "" ) {
			out.write("<script>alert('�뱣֤�����������ȫ')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/view/login/login.jsp ' "+ " </script>");
		}else {
			System.out.println("�������֤�룺"+ checkcode.toLowerCase());
			System.out.println("Ҫƥ�����֤�룺"+ request.getSession().getAttribute("checkcode").toString().toLowerCase());
			if(!checkcode.toLowerCase().equals(request.getSession().getAttribute("checkcode").toString().toLowerCase())  ) {
				out.write("<script>alert('��֤�����')</script>");
				out.write("<script>window.location.href=' " +request.getContextPath()+"/view/login/login.jsp ' "+ " </script>");
				return;
			}
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
				out.write("<script>alert('���˻��Ѿ������ˣ�������ѡ���µ��û���')</script>");
				
			}else {
				userop.AddUser(user);
				System.out.println("��ӳɹ�");
				out.write("<script>alert('ע��ɹ�')</script>");
				
			}
			out.write("<script>window.location.href=' " +request.getContextPath()+"/view/login/login.jsp ' "+ " </script>");
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
