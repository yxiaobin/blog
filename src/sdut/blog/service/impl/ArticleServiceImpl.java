package sdut.blog.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.services.ArticleService;
import sdut.blog.utils.DButils;

public class ArticleServiceImpl implements ArticleService{

	@Override
	public ArrayList<Article> SearchArticleByCount() {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select  * from article order by count desc limit 5";
			PreparedStatement pstmt =con.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
			}
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Article> SearchArticleByCategoryId(int categoryid) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select  * from article where category_id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, categoryid);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
			}
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Article> SearchArticles() {
		// TODO Auto-generated method stub	
		ArrayList<Article> list = new ArrayList<Article>();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select  * from article";
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
			}
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
}
