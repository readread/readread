<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page language="java" import="java.io.PrintWriter" %>
<%@ page language="java" import="com.readread.article.action.ArticleReadAction" %>

<%
response.setContentType("text/html;charset=gbk");
String strArticle= ArticleReadAction.getRandArticleJson();
PrintWriter outPrint = response.getWriter();
outPrint.print(strArticle);
outPrint.close();
%>
