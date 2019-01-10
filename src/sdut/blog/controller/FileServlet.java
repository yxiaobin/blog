package sdut.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.FileDaoImpl;
import sdut.blog.domain.MyFile;
import sdut.blog.domain.Page;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Servlet implementation class FileDownServlet
 */
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   //获取上传文件的目录
		String pagenum = request.getParameter("pagenum"); 
		int id = (int) request.getSession().getAttribute("user_id");
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        FileDaoImpl op = new FileDaoImpl();
        int total = op.SearchFileCount(id);
        Page page = new Page(Integer.parseInt(pagenum),total);
        ArrayList<MyFile> list = (ArrayList<MyFile>) op.SearchMyFileByStartIndex(id,Integer.parseInt(pagenum), page.getPagesize());
        request.setAttribute("file_list", list);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/view/file/index.jsp?pagenum="+pagenum).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void listfile(File file,Map<String,String> map){
	        //如果file代表的不是一个文件，而是一个目录
	        if(!file.isFile()){
	            //列出该目录下的所有文件和目录
	            File files[] = file.listFiles();
	            //遍历files[]数组
	            for(File f : files){
	                //递归
	                listfile(f,map);
	            }
	        }else{
	            /**
	             * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
	                file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
	                那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
	             */
	            String realName = file.getName().substring(file.getName().indexOf("_")+1);
	            //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
	            map.put(file.getName(), realName);
	        }
	    }
}
