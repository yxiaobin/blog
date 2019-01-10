package sdut.blog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.blog.dao.impl.FileDaoImpl;
import sdut.blog.dao.impl.UserDaoImpl;
import sdut.blog.domain.MyFile;
import sdut.blog.domain.User;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class ImgUpServlet
 */
public class ImgUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/img");
        //上传时生成的临时文件保存目录
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //创建临时目录
            tmpFile.mkdir();
        }
        MyFile file = new MyFile();
        MyFile myfile = file.Save(request, response, savePath , tempPath, tmpFile); 
        UserDaoImpl op  = new UserDaoImpl();
        int id = (int) request.getSession().getAttribute("user_id");
        User user =op.SearchUserByID(id);
        
        //上传的文件都是保存在/WEB-INF/img目录下的子目录当中
        String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/img");
        //通过文件名找出文件的所在目录
        String path = findFileSavePathByFileName(myfile.getName() ,fileSaveRootPath);
        
        user.setImg(path + "\\" + myfile.getName());
        op.UpdateUser(user);
        
      //转存图片二进制流
		 FileInputStream in = new FileInputStream(user.getImg());
		 byte[] data = null;
		 data = new byte[in.available()];  
        in.read(data);
        in.close();
        BASE64Encoder encoder = new BASE64Encoder();  
        String base64Img =encoder.encode(data); 
        
		request.getSession().setAttribute("user_img", base64Img);
        response.sendRedirect(request.getContextPath()+"/UserServlet?pagenum=1");
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
	            //创建目录
	            file.mkdirs();
	        }
	        return dir;
	    }
}
