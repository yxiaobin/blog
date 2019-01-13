package sdut.blog.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sdut.blog.daos.*;
import sdut.blog.domain.Article;
import sdut.blog.domain.Message;
import sdut.blog.utils.JDBCUtil;
public class MessageDaoImpl implements MessageDao{

	@Override
	public int AddMessage(Message m) {
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "insert into message(username,email,article_id,content,judge,date) values(?,?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, m.getUsername());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getArticleId());
			pstmt.setString(4, m.getContent());
			pstmt.setInt(5, 0);
			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			pstmt.setString(6, dateStr);
			boolean rs =pstmt.execute();
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#"+rs);
			//3.�ر����ݿ�
			dbutil.closeConn(con);;
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DelMessage(Message m) {
		// TODO Auto-generated method stub
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "delete from message where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, m.getId());
			boolean rs =pstmt.execute();
			//3.�ر����ݿ�
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<Message> SearchMessageByArticleId(int articleId) {
		// TODO Auto-generated method stub
		
		ArrayList<Message> list =new  ArrayList<Message>();
		
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "select * from message where article_id = ? and judge = 1";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, articleId);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				Message m = new Message();
				m.setArticleId(rs.getInt("article_id"));
				m.setContent(rs.getString("content"));
				m.setEmail(rs.getString("email"));
				m.setUsername(rs.getString("username"));
				m.setId(rs.getInt("id"));
				m.setJudge(rs.getInt("judge"));
				m.setTime(rs.getString("date"));
				list.add(m);
				
			}
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#"+rs);
			//3.�ر����ݿ�
			dbutil.closeConn(con);;
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ArrayList<Message> SearchMessages(int  member_id) {
		// TODO Auto-generated method stub
		ArrayList<Message> list =new  ArrayList<Message>();
		
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "select * from message";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				Message m = new Message();
				m.setArticleId(rs.getInt("article_id"));
				m.setContent(rs.getString("content"));
				m.setEmail(rs.getString("email"));
				m.setUsername(rs.getString("username"));
				m.setId(rs.getInt("id"));
				m.setJudge(rs.getInt("judge"));
				m.setTime(rs.getString("date"));
				//�������Ե�article_id �ҵ�article��Ȼ���ж�article�е�member_id�Ƿ���ڲ���memberid
				ArticleDaoImpl op = new ArticleDaoImpl();
				Article p =  op.SearchArticleByID(m.getArticleId());
				if(p.getMember_id() == member_id) {
					list.add(m);
				}
			}
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#"+rs);
			//3.�ر����ݿ�
			dbutil.closeConn(con);;
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int SearchMessageByArticleIdCount(int articleId) {
		// TODO Auto-generated method stub 
		int count1 = 0;
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "select count(0) as count1 from message where article_id = ? and judge = 1";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, articleId);
			ResultSet rs =pstmt.executeQuery();
			rs.next();
			count1 = rs.getInt("count1"); 
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#"+rs);
			//3.�ر����ݿ�
			dbutil.closeConn(con);;
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stu
		return count1;
	}

	@Override
	public void ModifyMessageJudge(int id) {
		// TODO Auto-generated method stub
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "update message set judge = 1 where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			boolean rs =pstmt.execute();
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#"+rs);
			//3.�ر����ݿ�
			dbutil.closeConn(con);;
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Message> SearchMessageByIndex(int index, int pagesize, int articleId) {
		// TODO Auto-generated method stub
        ArrayList<Message> list =new  ArrayList<Message>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1���������ݿ�
			Connection con = dbutil.getConn();
			//2.��ѯ���
			String sql = "select * from message where article_id = ? and judge = 1 limit ?,?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, articleId);
			pstmt.setInt(2, index);
			pstmt.setInt(3, pagesize);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				Message m = new Message();
				m.setArticleId(rs.getInt("article_id"));
				m.setContent(rs.getString("content"));
				m.setEmail(rs.getString("email"));
				m.setUsername(rs.getString("username"));
				m.setId(rs.getInt("id"));
				m.setJudge(rs.getInt("judge"));
				m.setTime(rs.getString("date"));
				list.add(m);
				
			}
			//System.out.println(m.getUsername()+"#"+m.getEmail()+"#"+m.getArticleId()+"#"+m.getContent()+"#"+rs);
			//3.�ر����ݿ�
			dbutil.closeConn(con);;
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}
	

}
