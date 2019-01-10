package sdut.blog.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.FileDaoImpl;
import sdut.blog.domain.MyFile;

/**
 * Servlet implementation class FileDeleteServlet
 */
public class FileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String fileName = request.getParameter("filename");  //23239283-92489-������.avi
	        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
	        //�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
	        String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
	        //ͨ���ļ����ҳ��ļ�������Ŀ¼
	        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
	        //�õ�Ҫ���ص��ļ�
	        File file = new File(path + "\\" + fileName);
	        //����ļ�������
	        if(!file.exists()){
	            request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
	            request.getRequestDispatcher("/message.jsp").forward(request, response);
	            return;
	        }else {
	        	file.delete();
	        }
	        FileDaoImpl op = new  FileDaoImpl();
	        op.DeleteMyFileByName(fileName);
	       response.sendRedirect(request.getContextPath()+"/FileServlet?pagenum=1");
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //����Ŀ¼
            file.mkdirs();
        }
        return dir;
    }
}
