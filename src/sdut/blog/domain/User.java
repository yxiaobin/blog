package sdut.blog.domain;

public class User {
	int id;
	String name;
	String username;
	String password;
	String email;
	public User() {
		/*nothing to do*/
		this.id = -1;
		this.name="";
		this.username="";
		this.password = "";
		this.email="";
	};
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
	
}
