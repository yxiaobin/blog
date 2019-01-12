package sdut.blog.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sdut.blog.dao.impl.ArticleDaoImpl;
import sdut.blog.utils.JDBCUtil;

public class Message {
private int id;
private String username;
private int articleId;
private String content;
private int judge;
private String email;
private String time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getArticleId() {
	return articleId;
}
public void setArticleId(int articleId) {
	this.articleId = articleId;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getJudge() {
	return judge;
}
public void setJudge(int judge) {
	this.judge = judge;
}
public String getEmail() {
	return email;
}
public String getArticleByArticleId() {
	ArticleDaoImpl op = new ArticleDaoImpl();
	Article p = op.SearchArticleByID(this.articleId);
	return p.getTitle();
	
	
	
	/*String name = "";
	JDBCUtil dbutil = new JDBCUtil();
	try {
		//1、连接数据库
		Connection con = dbutil.getConn();
		//2.查询语句
		String sql = "select title  from article where id = ?";
		PreparedStatement pstmt =con.prepareStatement(sql) ;
		pstmt.setInt(1, this.articleId);
		ResultSet rs =pstmt.executeQuery();
		//3.处理结果集
		rs.next();
		  name = rs.getString("title");
		//4.关闭数据库
		dbutil.closeConn(con);
		pstmt.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return name;*/
}
public void setEmail(String email) {
	this.email = email;
}
public Message() {
	
	
}

public Message(int article_id,String username,String email,String content) {
	this.articleId = article_id;
	this.content = content;
	this.email = email;
	this.username = username;
}

}
