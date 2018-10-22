package com.wangzunbin._04_http.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 后来拿到username都是null, session应运而生
 * 1. 添加cookie给浏览器
 * 2. 获取cookie的方法
 * 3. 销毁cookie, 使用的是setMaxAge
 * 4. cookie不支持中文存储, 如果要储存的话需要用utf-8编码给浏览器, 之后拿到之后接着要进行utf-8编码
 * 5. 多应用使用cookie的话需要, cookie.setDomain();
 * 6. cookie在关闭应用之后会销毁cookie
 * @author Administrator
 *
 */
@WebServlet("/cookie/login")
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
		// 添加cookie的方法
		Cookie cookie = new Cookie("username", username);
		resp.addCookie(cookie);;
		if ("admin".equals(username) && "1234".equals(password)) {
			writer.print("欢迎:" + username + "<br/>");
			writer.print("<a href='/cookie/list'>收件箱</a>");
		}
	}
}
