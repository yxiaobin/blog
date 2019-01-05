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
}
