package sdut.blog.daos;
import java.util.ArrayList;
import sdut.blog.domain.*;

public interface MessageDao {
	//将留言添加到数据库中
	public int AddMessage(Message message);
	//删除留言
	public int DelMessage(Message message);
	//通过文章id查询留言
	public ArrayList<Message> SearchMessageByArticleId(int articleId);
	//查询所有的留言
	public ArrayList<Message> SearchMessages(int member_id);
	//通过文章Id查询留言数目
	public int SearchMessageByArticleIdCount(int articleId);
	//通过留言id找到该条留言
	public void ModifyMessageJudge(int id);
	//通过索引和作者id找到留言
	public ArrayList<Message> SearchMessageByIndex(int index,int pagesize,int articleId);
}
