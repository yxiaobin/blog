package sdut.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sdut.blog.daos.ArticleDao;
import sdut.blog.domain.Article;
import sdut.blog.domain.Category;
import sdut.blog.domain.User;
import sdut.blog.utils.DButils;

public class ArticleDaoImpl implements ArticleDao{

	@Override
	public int AddArticle(Article p) {
		// TODO Auto-generated method stub
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "insert into article(member_id,category_id,title,content,keyword,date) values(?,?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, p.getMember_id());
			pstmt.setInt(2, p.getCategory_id());
			pstmt.setString(3, p.getTitle());
			pstmt.setString(4, p.getContent());
			pstmt.setString(5, p.getKeyword());
			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			pstmt.setString(6, dateStr);
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int UpdateArticle(Article p) {
		// TODO Auto-generated method stub
		
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "update article set category_id=?,title=?,keyword=?,content=?,date=? where id=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, p.getCategory_id());
			pstmt.setString(2, p.getTitle());
			pstmt.setString(3, p.getKeyword());
			pstmt.setString(4, p.getContent());
			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			pstmt.setString(5, dateStr);
			pstmt.setInt(6, p.getId());
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int DelArticle(Article p) {
		// TODO Auto-generated method stub
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "delete from article where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, p.getId());
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<Article> SearchArticles() {
		DButils dbutil = new DButils();
		ArrayList<Article> list = new ArrayList<Article>(); 
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from article order by id desc";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				Article p = new Article();
				p.setId(rs.getInt(1));
				p.setMember_id(rs.getInt(2));
				p.setCategory_id(rs.getInt(3));
				p.setTitle(rs.getString(4));
				p.setContent(rs.getString(5));
				p.setCount(rs.getInt(6));
				p.setKeyword(rs.getString(7));
				p.setNowtime(rs.getString(8));
				list.add(p);
			}
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return list;
	}

	@Override
	public Article SearchArticleByID(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Article p = new Article();
				DButils dbutil = new DButils();
				try {
					//1、连接数据库
					Connection con = dbutil.getCon();
					//2.查询语句
					String sql = "select * from article where id=?";
					PreparedStatement pstmt =con.prepareStatement(sql) ;
					pstmt.setInt(1, id);
					ResultSet rs =pstmt.executeQuery();
					//3.处理结果集
					
					while(rs.next()) {
						p.setId(rs.getInt("id"));
						p.setMember_id(rs.getInt("member_id"));
						p.setCategory_id(rs.getInt("category_id"));
						p.setCount(rs.getInt("count"));
						
						p.setTitle(rs.getString("Title"));
						p.setContent(rs.getString("content"));
						p.setKeyword(rs.getString("keyword"));
	
						p.setNowtime(rs.getString("date"));
					}
					//4.关闭数据库
					dbutil.closeCon(con);
					pstmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return p;
	}

	@Override
	public ArrayList<Article> SearchArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> SearchArticleByCategoryID(Category p) {
		// TODO Auto-generated method stub
		return null;
	}

}
