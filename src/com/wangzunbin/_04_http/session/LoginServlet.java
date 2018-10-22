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


/**
 * 1.session底层就是cookie
 * 2. sessionid保存的是cookie内存地址
 *
 */
@WebServlet("/session/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1012962764062426987L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 添加保存session的方法
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		if ("admin".equals(username) && "1234".equals(password)) {
			writer.print("欢迎:" + username + "<br/>");
			writer.print("<a href='/session/list'>收件箱</a>");
		}
	}
}
