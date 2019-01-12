package sdut.blog.daos;

import java.util.List;

import sdut.blog.domain.Category;
import sdut.blog.domain.MyFile;

public interface FileDao {
		//����ļ�
		public int AddMyFile(MyFile user);
		//�޸��ļ�
		public int UpdateMyFile(MyFile user);
		//ɾ���ļ�
		public int DelMyFile(MyFile user) ;
		//�����ļ�ByMemberID
		public List<MyFile> SearchMyFileByMemberID(int id);
		//�����ļ�ByID
		public MyFile SearchMyFileByID(int id);
		//ɾ���ļ�Byname
		public void DeleteMyFileByName(String name);
		//ͨ������id�ҵ����ߵ�����
		public String SearchNameByMemberId(int id);
		//��ȡ�ļ�������
		public int SearchFileCount(int id);
		//������������ȡ��ǰ��ʾ���ļ��������Ϣ
		public List<MyFile> SearchMyFileByStartIndex(int id,int startIndex,int pagesize);
		//����ԱȨ�޲鿴���е��ļ�
		public List<MyFile> SearchAllFiles();
}
