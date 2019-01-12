package sdut.blog.daos;
import java.util.ArrayList;

import sdut.blog.domain.Category;
import sdut.blog.domain.User;
public interface CategoryDao {
	//��ӷ���
	public int AddCategory(int member_id, Category user);
	//�޸ķ���
	public int UpdateCategory(int member_id, Category user);
	//ɾ������
	public int DelCategory(int member_id ,Category user) ;
	//���ҷ���ByID
	public Category SearchCategoryByID(int member_id ,int id);
	//���ҷ���ByName
	public Category SearchCategoryByName(int member_id ,String name);
	//���ҷ���ByNum
	public Category SearchCategoryByNum(int member_id ,int Num);
		
	//�������з���
	public ArrayList<Category> SearchCategorys(int member_id );
}
