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

public class UserDaoImpl implements UserDao{

	@Override
	public int AddUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DelUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User SearchUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User SearchUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
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
			}
			//4.关闭数据库
			dbutil.closeCon(con);
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
		DButils dbutil = new DButils();
		ArrayList<User> list = new ArrayList<User>(); 
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from user";
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
				list.add(user);
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

}
