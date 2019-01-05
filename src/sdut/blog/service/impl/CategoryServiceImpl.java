package sdut.blog.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Category;
import sdut.blog.services.CategoryService;
import sdut.blog.utils.DButils;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public ArrayList<Category> SerarchCategoryShowTitle() {
		// TODO Auto-generated method stub
		ArrayList<Category> list = new ArrayList<Category>();
		DButils dbutil = new DButils();
		try {
			//1、连接数据库
			Connection con = dbutil.getCon();
			//2.查询语句
			String sql = "select  * from category  where isshow=1 limit 5";
			PreparedStatement pstmt =con.prepareStatement(sql);
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
		return list;
	}

}
