package sdut.blog.daos;
import java.util.List;

import sdut.blog.domain.User;

public interface UserDao {
	//添加用户
	public int AddUser(User user);
	//修改用户
	public int UpdateUser(User user);
	//删除用户
	public int DelUser(User user) ;
	//查找用户ByID
	public User SearchUserByID(int id);
	//查找用户ByUsername
	public User SearchUserByUsername(String  username);
	//查找所有用户
	public List<User> SearchUsers();
}
