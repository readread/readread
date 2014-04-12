package com.readread.article.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readread.article.model.ArticleVO;

/**
 * Servlet implementation class AricleInsertServlet
 */
@WebServlet("/AricleInsertServlet")
public class AricleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AricleInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		String strTitle = request.getParameter("title");
		String strContent = request.getParameter("content");
		ArticleVO objArticleVO = new ArticleVO();
		objArticleVO.setTitle(strTitle);
		objArticleVO.setContent(strContent);
		ArticleReadAction.insertArticleVO(objArticleVO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
