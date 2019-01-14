package sdut.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import sdut.blog.daos.UserDao;
import sdut.blog.domain.User;
import sdut.blog.utils.DButils;
import sdut.blog.utils.JDBCUtil;

public class UserDaoImpl implements UserDao{
	static JDBCUtil dbutil = new JDBCUtil(); 
	@Override
	public int AddUser(User user) {
	
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "insert into user(name,username,password,email,isrank) values(?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setInt(5,user.getRank());
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return 0;
	}

	@Override
	public int UpdateUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "update user set name=?,username=?,password=?,email=? ,img =? , isrank =? where id=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getImg());
			pstmt.setInt(6, user.getRank());
			pstmt.setInt(7, user.getId());
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
	public int DelUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "delete from user where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, user.getId());
			boolean rs =pstmt.execute();
			//3.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return 0;
	}

	@Override
	public User SearchUserByID(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from user where id=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setImg(rs.getString("img"));
				user.setRank(rs.getInt("isrank"));
			}
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return user;
	}

	@Override
	public User SearchUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from user where username=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, username);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setImg(rs.getString("img"));
				user.setRank(rs.getInt("isrank"));
			}
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return user;
	}

	@Override
	public List<User> SearchUsers() {
		// TODO Auto-generated method stub
		
		ArrayList<User> list = new ArrayList<User>(); 
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from user order by id desc";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setImg(rs.getString("img"));
				user.setRank(rs.getInt("isrank"));
				list.add(user);
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

}
