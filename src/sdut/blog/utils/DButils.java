package sdut.blog.utils;

import java.sql.*;

public class DButils {
	private String name = "root";
	private String password = "1";
	private String url = "jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
	private String jdbcname = "com.mysql.cj.jdbc.Driver";
	
//	�������ݿ�
	public Connection getCon() throws Exception{
		Class.forName(jdbcname);
		Connection con=DriverManager.getConnection(url,name,password);
		return con;
	}
//	�ر����ݿ�
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
}
