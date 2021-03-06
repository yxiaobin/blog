package sdut.blog.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Category;
import sdut.blog.services.CategoryService;
import sdut.blog.utils.DButils;
import sdut.blog.utils.JDBCUtil;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public ArrayList<Category> SerarchCategoryShowTitle(int member_id) {
		// TODO Auto-generated method stub
		ArrayList<Category> list = new ArrayList<Category>();
		JDBCUtil dbutil = new JDBCUtil();
		try {
			//1、连接数据库
			Connection con = dbutil.getConn();
			//2.查询语句
			String sql = "select  * from category  where member_id = ? and  isshow=1 limit 5";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, member_id);
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
			dbutil.closeConn(con);
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
