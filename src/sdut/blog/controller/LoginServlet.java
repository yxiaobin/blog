package sdut.blog.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.User;
import sdut.blog.utils.Encrypt;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("") || password.equals("")) {
			out.write("<script>alert('请输入用户名和密码后在尝试登录操作')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/view/login/login.jsp ' "+ " </script>");
		}else {
			//查找数据库中是否存在此用户
			UserDaoImpl  userop = new UserDaoImpl();
			User user = userop.SearchUserByUsername(username);
			if(user.getUsername().equals("")) {
				out.write("<script>alert('用户不存在')</script>");
				out.write("<script>window.location.href=' " +request.getContextPath()+"/view/login/login.jsp ' "+ " </script>");
			
			}else {
				try {
					if(user.getPassword().equals(Encrypt.encrypt(password))) {
						System.out.print("登陆成功");
						//添加全局用户session
						HttpSession session = request.getSession();
						session.setAttribute("usr_name", user.getName());
						session.setAttribute("user_id", user.getId());
						session.setAttribute("rank", user.getRank());
						//转存图片二进制流
						if(user.getImg() != null) {
							 FileInputStream in = new FileInputStream(user.getImg());
							 byte[] data = null;
							 data = new byte[in.available()];  
					         in.read(data);
					         in.close();
					         BASE64Encoder encoder = new BASE64Encoder();  
					         String base64Img =encoder.encode(data);
							session.setAttribute("user_img", base64Img);
							System.out.println(user.getImg());
						}
						
						//跳转到后台管理页面
						String url = request.getContextPath() + "/view/layout/manager.jsp";
						response.sendRedirect(url);
					}else {
						out.write("<script>alert('用户名或密码错误')</script>");
						out.write("<script>window.location.href=' " +request.getContextPath()+"/view/login/login.jsp ' "+ " </script>");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
