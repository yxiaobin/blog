package sdut.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.FileDaoImpl;
import sdut.blog.domain.MyFile;

/**
 * Servlet implementation class FileUpdateServlet
 */
public class FileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("id");
		int id = Integer.parseInt(s);
		FileDaoImpl op = new FileDaoImpl();
		MyFile f = op.SearchMyFileByID(id);
		if(f.getId() >-1) {
			int key = f.getIsshare()+1;
			key = key%2;
			f.setIsshare(key);
			op.UpdateMyFile(f);
		}
		
		response.sendRedirect(request.getContextPath()+"/FileServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
