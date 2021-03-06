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
import sdut.blog.utils.*;

public class ArticleDaoImpl implements ArticleDao{

	@Override
	public int AddArticle(Article p) {
		// TODO Auto-generated method stub
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "insert into article(member_id,category_id,title,content,keyword,date,judge) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, p.getMember_id());
			pstmt.setInt(2, p.getCategory_id());
			pstmt.setString(3, p.getTitle());
			pstmt.setString(4, p.getContent());
			pstmt.setString(5, p.getKeyword());
			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			pstmt.setString(6, dateStr);
			pstmt.setInt(7, 0);
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeConn(con);;
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
		
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "update article set category_id=?,title=?,keyword=?,content=?,count=?,judge=? where id=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, p.getCategory_id());
			pstmt.setString(2, p.getTitle());
			pstmt.setString(3, p.getKeyword());
			pstmt.setString(4, p.getContent());
			pstmt.setInt(5, p.getCount());
			pstmt.setInt(6, p.getJudge());
			pstmt.setInt(7, p.getId());
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeConn(con);
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
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "delete from article where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, p.getId());
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<Article> SearchArticles() {
		JDBCUtil dbutil = new JDBCUtil();
		ArrayList<Article> list = new ArrayList<Article>(); 
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from article order by id desc";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				Article p = new Article();
				p.setId(rs.getInt("id"));
				p.setMember_id(rs.getInt(2));
				p.setCategory_id(rs.getInt(3));
				p.setTitle(rs.getString(4));
				p.setContent(rs.getString(5));
				p.setCount(rs.getInt(6));
				p.setKeyword(rs.getString(7));
				p.setNowtime(rs.getString(8));
				p.setJudge(rs.getInt("judge"));
				list.add(p);
			}
			//4.关闭数据库
			dbutil.closeConn(con);
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
				JDBCUtil dbutil = new JDBCUtil();
				try {
					//1、连接数据库
					Connection con = dbutil.getConn();
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
						p.setJudge(rs.getInt("judge"));
						p.setTitle(rs.getString("Title"));
						p.setContent(rs.getString("content"));
						p.setKeyword(rs.getString("keyword"));
						p.setNowtime(rs.getString("date"));
					}
					//4.关闭数据库
					dbutil.closeConn(con);
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
	public int SearchArticleCount(int member_id) {
		// TODO Auto-generated method stub
		int count = 0;
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select count(0) as count1 from article where member_id = ? ";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, member_id);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			rs.next();
			 count = rs.getInt("count1");
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public ArrayList<Article> SearchArticleByStartIndex(int member_id, int startindex, int pagesize) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			Connection conn = dbutil.getConn();
			String sql = "select * from article where member_id = ? order by id desc limit ?,? ";
			PreparedStatement pstmt =conn.prepareStatement(sql);
		    pstmt.setInt(2, startindex);
		    pstmt.setInt(3, pagesize);
		    pstmt.setInt(1, member_id);
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setJudge(rs.getInt("judge"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
		    }
		    //关闭连接池
		    dbutil.closeConn(conn);;
			pstmt.close();
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int SearchMemberArticleCount(int member_id) {
		// TODO Auto-generated method stub
		
		int count = 0;
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select count(0) as count1 from article where member_id = ? and judge = 1";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, member_id);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			rs.next();
			 count = rs.getInt("count1");
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int SearchUnjudgeArticleCount() {
		// TODO Auto-generated method stub
		int count = 0;
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select count(0) as count1 from article where judge = 0";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			rs.next();
			 count = rs.getInt("count1");
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public ArrayList<Article> SearchUnjudgeArticleByStartIndex(int startindex, int pagesize) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			Connection conn = dbutil.getConn();
			String sql = "select * from article where judge = 0  limit ?,?";
			PreparedStatement pstmt =conn.prepareStatement(sql);
		    pstmt.setInt(1, startindex);
		    pstmt.setInt(2, pagesize);
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setJudge(rs.getInt("judge"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
		    }
		    //关闭连接池
		    dbutil.closeConn(conn);;
			pstmt.close();
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Article> SearchArticleByCategoryIdAndMemberIdAndStartIndex(int category_id, int member_id,
			int startindex, int pagesize) {
		ArrayList<Article> list = new ArrayList<Article>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			Connection conn = dbutil.getConn();
			String sql = "select * from article where judge = 1 and category_id = ? and member_id = ? order by id desc limit ?,? ";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, category_id);
			pstmt.setInt(2, member_id);
			pstmt.setInt(3, startindex);
		    pstmt.setInt(4, pagesize);
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setJudge(rs.getInt("judge"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
		    }
		    //关闭连接池
		    dbutil.closeConn(conn);;
			pstmt.close();
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Article> SearchArticleByMemberIdAndStartIndex(int member_id, int startindex, int pagesize) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			Connection conn = dbutil.getConn();
			String sql = "select * from article where judge = 1 and  member_id = ? order by id desc limit ?,?";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, member_id);
			pstmt.setInt(2, startindex);
		    pstmt.setInt(3, pagesize);
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setJudge(rs.getInt("judge"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
		    }
		    //关闭连接池
		    dbutil.closeConn(conn);;
			pstmt.close();
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int SearchArticleCountByCategoryId(int member_id, int category_id) {
		// TODO Auto-generated method stub
		int count = 0;
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select count(0) as count1 from article where judge = 1 and member_id = ? and category_id = ? ";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			rs.next();
			 count = rs.getInt("count1");
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<Article> SearchArticleByMemberIdAndStartIndexwithoutJudge(int member_id, int startindex, int pagesize) {
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			Connection conn = dbutil.getConn();
			String sql = "select * from article where  member_id = ? order by id desc limit ?,? ";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, member_id);
			pstmt.setInt(2, startindex);
		    pstmt.setInt(3, pagesize);
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setJudge(rs.getInt("judge"));
				article.setCategory_id(rs.getInt("category_id"));
				article.setContent(rs.getString("content"));
				article.setMember_id(rs.getInt("member_id"));
				article.setTitle(rs.getString("title"));
				article.setNowtime(rs.getString("date"));
				article.setKeyword(rs.getString("keyword"));
				article.setCount(rs.getInt("count"));
				list.add(article);
		    }
		    //关闭连接池
		    dbutil.closeConn(conn);;
			pstmt.close();
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
