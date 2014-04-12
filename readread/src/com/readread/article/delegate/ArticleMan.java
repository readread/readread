package com.readread.article.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.readread.article.dao.ArticleDAO;
import com.readread.article.model.ArticleVO;

public class ArticleMan {

	final ArticleDAO objArticleDAO = new ArticleDAO();
	
	public List<ArticleVO>  getArticles(String strArticlesKey){
		List<ArticleVO> lis = new ArrayList<ArticleVO>();
		try {
			lis = objArticleDAO.getArticles(strArticlesKey);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lis;
	}
	
	public List<ArticleVO>  getRandArticles(){
		List<ArticleVO> lis = new ArrayList<ArticleVO>();
		try {
			lis = objArticleDAO.getRandArticles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lis;
	}
	
	public int insertArticleVO(ArticleVO objArticleVO){
		int result=0;
		try {
			result = objArticleDAO.insertArticleVO(objArticleVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
