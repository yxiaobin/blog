package sdut.blog.daos;

import sdut.blog.domain.Web;

public interface WebDao {
	//��ѯ��վ����
	public Web SearchWebByMember_id(Web p);
	//������վ����
	public void UpdateWebByid(Web web);
	//�����վ����
	public void AddWeb(Web web);
}
