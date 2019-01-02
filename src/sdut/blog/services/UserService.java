package sdut.blog.services;

import sdut.blog.domain.User;

public interface UserService {
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
