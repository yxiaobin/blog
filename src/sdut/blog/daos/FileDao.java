package sdut.blog.daos;

import java.util.List;

import sdut.blog.domain.Category;
import sdut.blog.domain.MyFile;

public interface FileDao {
		//添加文件
		public int AddMyFile(MyFile user);
		//修改文件
		public int UpdateMyFile(MyFile user);
		//删除文件
		public int DelMyFile(MyFile user) ;
		//查找文件ByMemberID
		public List<MyFile> SearchMyFileByMemberID(int id);
		//查找文件ByID
		public MyFile SearchMyFileByID(int id);
		//删除文件Byname
		public void DeleteMyFileByName(String name);
		//通过作者id找到作者的名字
		public String SearchNameByMemberId(int id);
		//获取文件总数量
		public int SearchFileCount(int id);
		//根据索引，查取当前显示的文件的相关信息
		public List<MyFile> SearchMyFileByStartIndex(int id,int startIndex,int pagesize);
		//管理员权限查看所有的文件
		public List<MyFile> SearchAllFiles();
}
