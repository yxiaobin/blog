package sdut.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sdut.blog.daos.FileDao;
import sdut.blog.domain.Article;
import sdut.blog.domain.Category;
import sdut.blog.domain.MyFile;
import sdut.blog.utils.DButils;
import sdut.blog.utils.JDBCUtil;

public class FileDaoImpl implements FileDao{
	
	static JDBCUtil dbutil = new JDBCUtil();
	
	@Override
	public int AddMyFile(MyFile user) {
		// TODO Auto-generated method stub
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "insert into file(name,member_id,isshare,filepwd,time) values(?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getMember_id());
			pstmt.setInt(3, user.getIsshare());
			pstmt.setString(4, user.getFilepwd());
			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			pstmt.setString(5, dateStr);
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
	public int UpdateMyFile(MyFile user) {
		// TODO Auto-generated method stub
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "Update file set isshare = ?  where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, user.getIsshare());
			pstmt.setInt(2, user.getId());
			pstmt.executeUpdate();
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int DelMyFile(MyFile user) {
		// TODO Auto-generated method stub
		Connection coon = dbutil.getConn();
		dbutil.closeConn(coon);
		return 0;
	}

	@Override
	public List<MyFile> SearchMyFileByMemberID(int id) {
		// TODO Auto-generated method stub
		ArrayList<MyFile> list = new ArrayList<MyFile>();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from file where member_id = ? or isshare = 0";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				MyFile p = new MyFile();
				p.setId(rs.getInt("id"));
				p.setMember_id(rs.getInt("member_id"));
				p.setIsshare(rs.getInt("isshare"));
				p.setFilepwd(rs.getString("filepwd"));
				p.setNowtime(rs.getString("time"));
				p.setName(rs.getString("name"));
				list.add(p);
				
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
	public MyFile SearchMyFileByID(int id) {
		// TODO Auto-generated method stub
		MyFile p = new MyFile();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from file where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			while(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setMember_id(rs.getInt("member_id"));
				p.setIsshare(rs.getInt("isshare"));
				p.setFilepwd(rs.getString("filepwd"));
				p.setNowtime(rs.getString("time"));
				p.setName(rs.getString("name"));
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
	public void DeleteMyFileByName(String name) {
		// TODO Auto-generated method stub
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "delete  from file where name = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}

	@Override
	public String SearchNameByMemberId(int id) {
		// TODO Auto-generated method stub
		String name = "";
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select name from user where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			name = rs.getString("name");
			
			
			//4.关闭数据库
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}

	@Override
	public int SearchFileCount(int id) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select count(0) as count1 from file where member_id = ? or isshare = 0";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
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
	public List<MyFile> SearchMyFileByStartIndex(int id, int startIndex, int pagesize) {
		// TODO Auto-generated method stub
			ArrayList<MyFile> list = new ArrayList<MyFile>();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from file where member_id = ? or isshare = 0 limit ?,?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			pstmt.setInt(2, startIndex);
			pstmt.setInt(3, pagesize);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				MyFile p = new MyFile();
				p.setId(rs.getInt("id"));
				p.setMember_id(rs.getInt("member_id"));
				p.setIsshare(rs.getInt("isshare"));
				p.setFilepwd(rs.getString("filepwd"));
				p.setNowtime(rs.getString("time"));
				p.setName(rs.getString("name"));
				list.add(p);
				
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
	public List<MyFile> SearchAllFiles() {
		// TODO Auto-generated method stub
		ArrayList<MyFile> list = new ArrayList<MyFile>();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from file order by id desc";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集	
			while(rs.next()) {
				MyFile p = new MyFile();
				p.setId(rs.getInt("id"));
				p.setMember_id(rs.getInt("member_id"));
				p.setIsshare(rs.getInt("isshare"));
				p.setFilepwd(rs.getString("filepwd"));
				p.setNowtime(rs.getString("time"));
				p.setName(rs.getString("name"));
				list.add(p);
				
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
	public List<MyFile> SearchMyFileByStartIndex(int startIndex, int pagesize) {
		// TODO Auto-generated method stub
			ArrayList<MyFile> list = new ArrayList<MyFile>();
		
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select * from file limit ?,?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, pagesize);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				MyFile p = new MyFile();
				p.setId(rs.getInt("id"));
				p.setMember_id(rs.getInt("member_id"));
				p.setIsshare(rs.getInt("isshare"));
				p.setFilepwd(rs.getString("filepwd"));
				p.setNowtime(rs.getString("time"));
				p.setName(rs.getString("name"));
				list.add(p);
				
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
