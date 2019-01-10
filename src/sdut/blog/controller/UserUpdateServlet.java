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
		String s = request.getParameter("id");
		System.out.println(s+"$$$$$$$$$$$$$");
		int id = Integer.parseInt(s);
		System.out.println(id+" ### "+username+" "+name+" "+ password +" "+ email );
		if(username == "" || password == "" || email == "" || name == "" ) {
			out.write("<script>alert('�뱣֤�����������ȫ')</script>");
			out.write("<script>window.location.href=' " +request.getContextPath()+"/UserServlet ' "+ " </script>");
		}else {
			User user = new User();
			/*String img = request.getParameter("img");
			if(img !=""){
				
				//�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		        String savePath = this.getServletContext().getRealPath("/WEB-INF/img");
		        //�ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		        File tmpFile = new File(tempPath);
		        if (!tmpFile.exists()) {
		            //������ʱĿ¼
		            tmpFile.mkdir();
		        }
		        MyFile file = new MyFile();
		        MyFile myfile = file.Save(request, response, savePath , tempPath, tmpFile);
		        user.setImg(myfile.getFilepwd());
			}*/
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);
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
