package com.wangzunbin._04_http.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie/list")
public class ListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -252178086608694992L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String username = null;
		// 获取cookie的方法
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
		}
		out.print("欢迎:" + username + "<br/>");
		Cookie cookie = new Cookie("username", username);
		// 销毁cookie
		cookie.setMaxAge(0);
		resp.addCookie(cookie);;
		out.print("<a href='/cookie/content'>邮件一</a><br/>");
		out.print("<a href='/cookie/content'>邮件二</a><br/>");
		out.print("<a href='/cookie/content'>邮件三</a><br/>");
	}
}
