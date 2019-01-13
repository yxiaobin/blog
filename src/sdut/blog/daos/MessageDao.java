package sdut.blog.daos;
import java.util.ArrayList;
import sdut.blog.domain.*;

public interface MessageDao {
	//��������ӵ����ݿ���
	public int AddMessage(Message message);
	//ɾ������
	public int DelMessage(Message message);
	//ͨ������id��ѯ����
	public ArrayList<Message> SearchMessageByArticleId(int articleId);
	//��ѯ���е�����
	public ArrayList<Message> SearchMessages(int member_id);
	//ͨ������Id��ѯ������Ŀ
	public int SearchMessageByArticleIdCount(int articleId);
	//ͨ������id�ҵ���������
	public void ModifyMessageJudge(int id);
	//ͨ������������id�ҵ�����
	public ArrayList<Message> SearchMessageByIndex(int index,int pagesize,int articleId);
}
