package sdut.blog.daos;
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
}
