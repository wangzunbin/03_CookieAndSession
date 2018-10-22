package com.wangzunbin._04_http.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session/content")
public class ContentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -149492266509799955L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String username = (String) req.getSession().getAttribute("username");
		out.print("欢迎:" + username + "<br/>");
		out.print("<a href='#'>我饿了</a><br/>");
	}
}
