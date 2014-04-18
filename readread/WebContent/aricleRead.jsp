<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.io.PrintWriter" %>
<%@ page language="java" import="com.readread.article.action.ArticleReadAction" %>

<%
response.setContentType("text/html;charset=utf-8");
String strArticle="";
if(ArticleReadAction.getCountArticle()>=5){
	strArticle= ArticleReadAction.getRandDateArticleJson();
}else{
	strArticle= ArticleReadAction.getRandArticleJson();
}
PrintWriter outPrint = response.getWriter();
outPrint.print(strArticle);
outPrint.close();
%>
