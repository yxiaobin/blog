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
	public Web SearchWebByMember_id(Web p) {
		// TODO Auto-generated method stub
		JDBCUtil util = new JDBCUtil();
		Connection con  = util.getConn();
		String sql = "select * from web  where member_id = ?";
		PreparedStatement pstmt = null;
		Web web = new Web();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getMember_id());
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				web.setWebdescription(rs.getString("webdescription"));
				web.setWebkeyword(rs.getString("webkeyword"));
				web.setWebstyle(rs.getString("webstyle"));
				web.setWebname(rs.getString("webname"));
				web.setId(rs.getInt("id"));
				web.setMember_id(rs.getInt("member_id"));
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
		String sql = "update web set webname = ?, webkeyword=? , webdescription=? , webstyle=? , member_id=? where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, web.getWebname());
			pstmt.setString(2, web.getWebkeyword());
			pstmt.setString(3, web.getWebdescription());
			pstmt.setString(4, web.getWebstyle());
			pstmt.setInt(5, web.getMember_id());
			pstmt.setInt(6, web.getId());
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		util.closeConn(con);
		
	}

	@Override
	public void AddWeb(Web web) {
		// TODO Auto-generated method stub
		JDBCUtil util = new JDBCUtil();
		Connection con  = util.getConn();
		String sql = "insert into web(member_id) values(?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, web.getMember_id());
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		util.closeConn(con);
		return ;
	}

}
