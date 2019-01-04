package sdut.blog.dao.impl;
import sdut.blog.domain.Category;
import sdut.blog.domain.User;
import sdut.blog.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sdut.blog.daos.CategoryDao;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public int AddCategory(Category user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateCategory(Category user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DelCategory(Category user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category SearchCategoryByID(int id) {
		// TODO Auto-generated method stub
		Category category = new Category();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from category where id=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setNum(rs.getInt("num"));
				category.setShow(rs.getInt("show"));
			}
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return category;
	}

	@Override
	public Category SearchCategoryByName(String name) {
		// TODO Auto-generated method stub
		Category category = new Category();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from category where name=?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, name);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setNum(rs.getInt("num"));
				category.setShow(rs.getInt("show"));
			}
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回
		return category;
	}
	
	@Override
	public List<Category> SearchCategorys() {
		// TODO Auto-generated method stub
		DButils dbutil = new DButils();
		ArrayList<Category> list = new ArrayList<Category>(); 
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from category";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setNum(rs.getInt("num"));
				category.setShow(rs.getInt("show"));
				list.add(category);
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
