<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="com.readread.article.model.ArticleVO" %>
<%@ page language="java" import="com.readread.article.action.ArticleReadAction" %>
<%@ page language="java" import="com.readread.util.ReadUUID" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%

response.setContentType("text/html;charset=utf-8");
String strTitle = request.getParameter("title");
String strContent = request.getParameter("content");
out.println(strContent);
out.println(ReadUUID.getReadUUID());

ArticleVO objArticleVO = new ArticleVO();
objArticleVO.setTitle(strTitle);
objArticleVO.setContent(strContent);
ArticleReadAction.insertArticleVO(objArticleVO);
%>
</head>
<body>

</body>
</html>