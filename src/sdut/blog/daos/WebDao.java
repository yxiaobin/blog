package sdut.blog.daos;

import sdut.blog.domain.Web;

public interface WebDao {
	//查询网站博客
	public Web SearchWebByMember_id(Web p);
	//更新网站博客
	public void UpdateWebByid(Web web);
	//添加网站博客
	public void AddWeb(Web web);
}
