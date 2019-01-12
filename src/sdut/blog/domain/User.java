package sdut.blog.domain;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String img;
	private int  rank;
	public User() {
		/*nothing to do*/
		this.id = -1;
		this.name="";
		this.username="";
		this.password = "";
		this.email="";
		this.rank=-1;
	};
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
