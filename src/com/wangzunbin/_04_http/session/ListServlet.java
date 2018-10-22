package com.wangzunbin._04_http.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/list")
public class ListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -252178086608694992L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// 获取session的方法
		String username = (String) req.getSession().getAttribute("username");
		// 添加保存session的方法
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		out.print("欢迎:" + username + "<br/>");
		out.print("<a href='/session/content'>邮件一</a><br/>");
		out.print("<a href='/session/content'>邮件二</a><br/>");
		out.print("<a href='/session/content'>邮件三</a><br/>");
	}
}
