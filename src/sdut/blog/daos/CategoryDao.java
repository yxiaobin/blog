package sdut.blog.daos;
import java.util.ArrayList;

import sdut.blog.domain.Category;
import sdut.blog.domain.User;
public interface CategoryDao {
	//添加分类
	public int AddCategory(int member_id, Category user);
	//修改分类
	public int UpdateCategory(int member_id, Category user);
	//删除分类
	public int DelCategory(int member_id ,Category user) ;
	//查找分类ByID
	public Category SearchCategoryByID(int member_id ,int id);
	//查找分类ByName
	public Category SearchCategoryByName(int member_id ,String name);
	//查找分类ByNum
	public Category SearchCategoryByNum(int member_id ,int Num);
		
	//查找所有分类
	public ArrayList<Category> SearchCategorys(int member_id );
}
