package sdut.blog.domain;

public class Web {
	
	
	private String webname;
	private String webkeyword;
	private String webdescription;
	private String webstyle;
	private int id;
	private int member_id;
	public Web() {
		this.id = -1;
	}
	public String getWebname() {
		return webname;
	}
	public void setWebname(String webname) {
		this.webname = webname;
	}
	public String getWebkeyword() {
		return webkeyword;
	}
	public void setWebkeyword(String webkeyword) {
		this.webkeyword = webkeyword;
	}
	public String getWebdescription() {
		return webdescription;
	}
	public void setWebdescription(String webdescription) {
		this.webdescription = webdescription;
	}
	public String getWebstyle() {
		return webstyle;
	}
	public void setWebstyle(String webstyle) {
		this.webstyle = webstyle;
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
}
