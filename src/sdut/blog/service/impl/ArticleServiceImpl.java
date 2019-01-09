package sdut.blog.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Page;
import sdut.blog.services.ArticleService;
import sdut.blog.utils.DButils;
import sdut.blog.utils.JDBCUtil;

public class ArticleServiceImpl implements ArticleService{
	static JDBCUtil dbutil = new JDBCUtil(); 
	@Override
	public ArrayList<Article> SearchArticleByCount() {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
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
			dbutil.closeConn(con);
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
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select  * from article where category_id = ? order by id desc";
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
			dbutil.closeConn(con);
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
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select  * from article order by id desc";
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
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Article> SearchArticlesByCategoryIdandPage(int id, Page page) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
	
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select  * from article  where category_id = ? order by id desc limit ? , ? ";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, page.getStartindex());
			pstmt.setInt(3, page.getPagesize());
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
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Article> SearchArticlesandPage(Page page) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select  * from article order by id desc limit ? , ? ";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, page.getStartindex());
			pstmt.setInt(2, page.getPagesize());
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
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
}
