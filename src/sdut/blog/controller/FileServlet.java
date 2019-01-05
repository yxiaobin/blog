package sdut.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
		   //��ȡ�ϴ��ļ���Ŀ¼
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //�洢Ҫ���ص��ļ���
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //�ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
        listfile(new File(uploadFilePath),fileNameMap);//File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
        //��Map���Ϸ��͵�listfile.jspҳ�������ʾ
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/view/file/listfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void listfile(File file,Map<String,String> map){
	        //���file����Ĳ���һ���ļ�������һ��Ŀ¼
	        if(!file.isFile()){
	            //�г���Ŀ¼�µ������ļ���Ŀ¼
	            File files[] = file.listFiles();
	            //����files[]����
	            for(File f : files){
	                //�ݹ�
	                listfile(f,map);
	            }
	        }else{
	            /**
	             * �����ļ������ϴ�����ļ�����uuid_�ļ�������ʽȥ���������ģ�ȥ���ļ�����uuid_����
	                file.getName().indexOf("_")�����ַ����е�һ�γ���"_"�ַ���λ�ã�����ļ��������ڣ�9349249849-88343-8344_��_��_��.avi
	                ��ôfile.getName().substring(file.getName().indexOf("_")+1)����֮��Ϳ��Եõ���_��_��.avi����
	             */
	            String realName = file.getName().substring(file.getName().indexOf("_")+1);
	            //file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
	            map.put(file.getName(), realName);
	        }
	    }
}
