package sdut.blog.daos;

import sdut.blog.domain.Web;

public interface WebDao {
	public Web SearchWebByid();
	public void UpdateWebByid(Web web);
}
