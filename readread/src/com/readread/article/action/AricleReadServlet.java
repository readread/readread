package com.readread.article.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AricleReadServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		String strArticle="";
		if(ArticleReadAction.getCountArticle()>5){
			strArticle= ArticleReadAction.getRandDateArticleJson();
		}else{
			strArticle= ArticleReadAction.getRandArticleJson();
		}
		PrintWriter out = response.getWriter();
			out.print(strArticle);
		out.close();
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doGet(request, response);
	}
}
