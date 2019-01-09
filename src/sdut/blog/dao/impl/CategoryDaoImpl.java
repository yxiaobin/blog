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
	public int AddCategory(Category category) {
		// TODO Auto-generated method stub
		Category cate = null;
		//在数据库中查找是否存在即将要添加的分类
		cate = SearchCategoryByName(category.getName());
		//若为空，则说明可以添加
		if(cate.getId()==-1) {
			DButils dbutil = new DButils();
			try {
				//1、连接数据库
				Connection con = dbutil.getCon();
				//2.查询语句
				String sql1 = "select count(*) as count from category";
				String sql2 = "insert into category(name,num,isshow) values(?,?,?)";
				PreparedStatement pstmt =con.prepareStatement(sql1) ;
				ResultSet rs = pstmt.executeQuery();
				
				//3.处理结果集
				int count;
				rs.next();
				count = rs.getInt("count");
				System.out.println(count+"hhh");
				pstmt =con.prepareStatement(sql2);
				pstmt.setString(1, category.getName());
				pstmt.setInt(2,count+1);
				pstmt.setInt(3, category.getShow());
				pstmt.executeUpdate();
				//4.关闭数据库
				dbutil.closeCon(con);
				pstmt.close();	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}else {
			System.out.println("不为空");
			return 0;
		}
	}

	@Override
	public int UpdateCategory(Category category) {
		// TODO Auto-generated method stub
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "Update category set name = ? ,isshow = ? , num = ? where id = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, category.getName());
			pstmt.setInt(2, category.getShow());
			pstmt.setInt(3, category.getNum());
			pstmt.setInt(4, category.getId());
			pstmt.executeUpdate();
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int DelCategory(Category category) {
		// TODO Auto-generated method stub
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql1 = "delete from category where id=?";
			PreparedStatement pstmt =con.prepareStatement(sql1) ;
			pstmt.setInt(1, category.getId());
			pstmt.executeUpdate();
			String sql2 = "update category set num = num-1 where num > ?";
		    pstmt =con.prepareStatement(sql2) ;
			pstmt.setInt(1, category.getId());
			pstmt.executeUpdate();
			//4.关闭数据库
			dbutil.closeCon(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				category.setShow(rs.getInt("isshow"));
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
			String sql = "select * from category where name = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setString(1, name);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setNum(rs.getInt("num"));
				category.setShow(rs.getInt("isshow"));
			}
			System.out.println(category.getId());
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
	public ArrayList<Category> SearchCategorys() {
		// TODO Auto-generated method stub
		DButils dbutil = new DButils();
		ArrayList<Category> list = new ArrayList<Category>(); 
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from category order by num ";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setNum(rs.getInt("num"));
				category.setShow(rs.getInt("isshow"));
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

	@Override
	public Category SearchCategoryByNum(int Num) {
		// TODO Auto-generated method stub
		Category category = new Category();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select * from category where num = ?";
			PreparedStatement pstmt =con.prepareStatement(sql) ;
			pstmt.setInt(1, Num);
			ResultSet rs =pstmt.executeQuery();
			//3.处理结果集
			
			while(rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setNum(rs.getInt("num"));
				category.setShow(rs.getInt("isshow"));
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


}
