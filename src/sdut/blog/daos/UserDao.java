package sdut.blog.daos;
import java.util.List;

import sdut.blog.domain.User;

public interface UserDao {
	//����û�
	public int AddUser(User user);
	//�޸��û�
	public int UpdateUser(User user);
	//ɾ���û�
	public int DelUser(User user) ;
	//�����û�ByID
	public User SearchUserByID(int id);
	//�����û�ByUsername
	public User SearchUserByUsername(String  username);
	//���������û�
	public List<User> SearchUsers();
}
