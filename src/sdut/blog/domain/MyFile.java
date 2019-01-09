package sdut.blog.domain;

import sdut.blog.dao.impl.FileDaoImpl;

public class MyFile {
	private int  id=-1;
	private String name;
	private String  filepwd;
	private int member_id;
	private int isshare;
	private String nowtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilepwd() {
		return filepwd;
	}
	public void setFilepwd(String filepwd) {
		this.filepwd = filepwd;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getIsshare() {
		return isshare;
	}
	public void setIsshare(int isshare) {
		this.isshare = isshare;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	public  String getMemberName() {
		FileDaoImpl op =new FileDaoImpl();
		return op.SearchNameByMemberId(this.member_id);
		
	}
}
