package sdut.blog.daos;
import java.util.List;

import sdut.blog.domain.Category;
import sdut.blog.domain.User;
public interface CategoryDao {
	//��ӷ���
	public int AddCategory(Category user);
	//�޸ķ���
	public int UpdateCategory(Category user);
	//ɾ������
	public int DelCategory(Category user) ;
	//���ҷ���ByID
	public Category SearchCategoryByID(int id);
	//���ҷ���ByName
	public Category SearchCategoryByName(String name);
	//���ҷ���ByNum
	public Category SearchCategoryByNum(int Num);
		
	//�������з���
	public List<Category> SearchCategorys();
}
