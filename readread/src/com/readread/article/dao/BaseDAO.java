package com.readread.article.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.readread.article.constant.ReadConstant;



public class BaseDAO {

	public Connection readGetConnection() throws SQLException{
		try {
			Class.forName(ReadConstant.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(ReadConstant.URL, ReadConstant.USER,ReadConstant.PASSWORD);
		return conn;
	}
	
	public void closeCon(Connection conn,Statement statement,ResultSet rs) throws SQLException{
		if(conn!=null){
			conn.close();
		}
		if(statement!=null){
			statement.close();
		}
		if(rs!=null){
			rs.close();
		}		
	}
	
	public void closeCon(Connection conn,PreparedStatement ps) throws SQLException{
		if(conn!=null){
			conn.close();
		}
		if(ps!=null){
			ps.close();
		}
	}
}
