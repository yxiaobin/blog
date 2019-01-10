package sdut.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sdut.blog.daos.WebDao;
import sdut.blog.domain.Web;
import sdut.blog.utils.JDBCUtil;

public class WebDaoImpl implements WebDao{

	@Override
	public Web SearchWebByid() {
		// TODO Auto-generated method stub
		JDBCUtil util = new JDBCUtil();
		Connection con  = util.getConn();
		String sql = "select * from web  where id = 1";
		PreparedStatement pstmt = null;
		Web web = new Web();
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				web.setWebdescription(rs.getString("webdescription"));
				web.setWebkeyword(rs.getString("webkeyword"));
				web.setWebstyle(rs.getString("webstyle"));
				web.setWebname(rs.getString("webname"));
			}
			
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		util.closeConn(con);
		return web;
	}

	@Override
	public void UpdateWebByid(Web web) {
		// TODO Auto-generated method stub
		JDBCUtil util = new JDBCUtil();
		Connection con  = util.getConn();
		String sql = "update web set webname = ?, webkeyword=? , webdescription=? , webstyle=? where id = 1";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, web.getWebname());
			pstmt.setString(2, web.getWebkeyword());
			pstmt.setString(3, web.getWebdescription());
			pstmt.setString(4, web.getWebstyle());
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		util.closeConn(con);
		
	}

}
