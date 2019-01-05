package sdut.blog.domain;

import java.util.Date;

import sdut.blog.dao.impl.UserDaoImpl;

public class Article {
	private  int  id;
	private  int  member_id;
	private  int  category_id;
	private int count ;

	private String title;
	private String content;
	private String keyword;
	private String nowtime;
	public Article() {
		
	}
	public Article(int member_id, int category_id, String title, String content, String keyword) {
		this.member_id=member_id;
		this.category_id=category_id;
		this.title = title;
		this.content = content;
		this.keyword=keyword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMemberName() {
		User p = new User(); 
		UserDaoImpl op = new UserDaoImpl();
		p = op.SearchUserByID(this.member_id);
		return p.getName();
	}
	public String getCategoryName() {
		Category z = new Category();
		z.setId(this.getCategory_id());
		return z.getCategoryName();
		
	}
}
