package sdut.blog.daos;
import java.util.List;

import sdut.blog.domain.Category;
import sdut.blog.domain.User;
public interface CategoryDao {
	//添加分类
	public int AddCategory(Category user);
	//修改分类
	public int UpdateCategory(Category user);
	//删除分类
	public int DelCategory(Category user) ;
	//查找分类ByID
	public Category SearchCategoryByID(int id);
	//查找分类ByName
	public Category SearchCategoryByName(String name);
	//查找分类ByNum
	public Category SearchCategoryByNum(int Num);
		
	//查找所有分类
	public List<Category> SearchCategorys();
}
