package com.readread.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.readread.article.model.ArticleVO;



public class ArticleDAO extends BaseDAO{
	public List<ArticleVO>  getArticles(String strArticlesKey) throws SQLException {
		// 连续数据库
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<ArticleVO> lisArticleVO = new ArrayList<ArticleVO>();
		try {
			conn = this.readGetConnection();
		
        // statement用来执行SQL语句
        statement = conn.createStatement();
        
        // 要执行的SQL语句
        StringBuffer sql =new StringBuffer(256);
        			 sql.append("select * from read_article ra where ra.article_key in (");
        			 sql.append(strArticlesKey).append(")");
        			 
        // 结果集
        rs = statement.executeQuery(sql.toString());
        
        while(rs.next()) {
        	ArticleVO objArticleVO = rsToVO(rs);
        	lisArticleVO.add(objArticleVO);
        }
        	return lisArticleVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeCon(conn, statement, rs);
		}
		return lisArticleVO;
	}

	
	
	public List<ArticleVO>  getRandArticles() throws SQLException{
		// 连续数据库
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<ArticleVO> lisArticleVO = new ArrayList<ArticleVO>();
		try {
			conn = this.readGetConnection();
		
        // statement用来执行SQL语句
        statement = conn.createStatement();
        
        // 要执行的SQL语句
        StringBuffer sql =new StringBuffer(256);
        			 sql.append("SELECT * FROM read_article r  ORDER BY RAND() LIMIT 5");
        			 
        // 结果集
        rs = statement.executeQuery(sql.toString());
        
        while(rs.next()) {
        	ArticleVO objArticleVO = rsToVO(rs);
        	lisArticleVO.add(objArticleVO);
        }
        	return lisArticleVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeCon(conn, statement, rs);
		}
		return lisArticleVO;
	}
	
	public List<ArticleVO>  getRandDateArticles() throws SQLException{
		// 连续数据库
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<ArticleVO> lisArticleVO = new ArrayList<ArticleVO>();
		try {
			conn = this.readGetConnection();
		
        // statement用来执行SQL语句
        statement = conn.createStatement();
        
        // 要执行的SQL语句
        StringBuffer sql =new StringBuffer(256);
        			 sql.append("SELECT * FROM read_article r WHERE r.updateTime < DATE_SUB(CURDATE(),INTERVAL 1 DAY) AND r.updateTime >  DATE_SUB(CURDATE(),INTERVAL 2 DAY) ORDER BY RAND() LIMIT 5");
        			 
        // 结果集
        rs = statement.executeQuery(sql.toString());
        
        while(rs.next()) {
        	ArticleVO objArticleVO = rsToVO(rs);
        	lisArticleVO.add(objArticleVO);
        }
        	return lisArticleVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeCon(conn, statement, rs);
		}
		return lisArticleVO;
	}
	
	public int getCountArticle() throws SQLException{
		// 连续数据库
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        int iCount = 0;
		try {
			conn = this.readGetConnection();
		
        // statement用来执行SQL语句
        statement = conn.createStatement();
        
        // 要执行的SQL语句
        StringBuffer sql =new StringBuffer(256);
        			 sql.append("SELECT COUNT(1) FROM read_article r WHERE r.updateTime < DATE_SUB(CURDATE(),INTERVAL 1 DAY) AND r.updateTime >  DATE_SUB(CURDATE(),INTERVAL 2 DAY)");
        			 
        // 结果集
        rs = statement.executeQuery(sql.toString());
        
        if(rs.next()) {
        	iCount = rs.getInt(1);
        }
        	return iCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeCon(conn, statement, rs);
		}
		return iCount;
	}
	
	public int insertArticleVO(ArticleVO objArticleVO) throws SQLException{
		// 连续数据库
        Connection conn = null;
        PreparedStatement ps = null;
        try {
			conn = this.readGetConnection();
			// statement用来执行SQL语句
	        String insertSQL = "INSERT INTO read_article (article_key, title, content, submitTime, updateTime, score)VALUES(?, ?, ?, sysdate(), sysdate(), ?)";
	        ps=conn.prepareStatement(insertSQL);
	        ps.setString(1, objArticleVO.getArticleKey());
	        ps.setString(2, objArticleVO.getTitle());
	        ps.setString(3, objArticleVO.getContent());
	        ps.setInt(4, objArticleVO.getScore());
	        return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			this.closeCon(conn, ps);
		}
	}
	
	private ArticleVO rsToVO(ResultSet rs) throws SQLException {
		ArticleVO objArticleVO = new ArticleVO();
		objArticleVO.setArticleKey(rs.getString("article_key"));
		objArticleVO.setTitle(rs.getString("title"));
		objArticleVO.setContent(rs.getString("content"));
		objArticleVO.setSubmitTime(rs.getTimestamp("submitTime"));
		objArticleVO.setUpdateTime(rs.getTimestamp("updateTime"));
		objArticleVO.setScore(rs.getInt("score"));
		return objArticleVO;
	}
}
