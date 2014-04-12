package com.readread.article.action;

import java.util.List;

import com.google.gson.Gson;
import com.readread.article.delegate.ArticleMan;
import com.readread.article.model.ArticleVO;
import com.readread.util.ReadUUID;

public final class ArticleReadAction {
	public static String getRandArticleJson(){
		ArticleMan objArticleMan = new ArticleMan();
		List<ArticleVO> lis = objArticleMan.getRandArticles();
		Gson gson = new Gson(); 
		String str=  gson.toJson(lis);
		return str;
	}
	public static void insertArticleVO(ArticleVO objArticleVO){
		ArticleMan objArticleMan = new ArticleMan();
		objArticleVO.setArticleKey(ReadUUID.getReadUUID());
		objArticleVO.setScore(100);
		objArticleMan.insertArticleVO(objArticleVO);
	}
	
	public static String getRandDateArticleJson(){
		ArticleMan objArticleMan = new ArticleMan();
		List<ArticleVO> lis = objArticleMan.getRandDateArticles();
		Gson gson = new Gson(); 
		String str=  gson.toJson(lis);
		return str;
	}
	
	public static int getCountArticle(){
		ArticleMan objArticleMan = new ArticleMan();
		return objArticleMan.getCountArticle();
	}
}
