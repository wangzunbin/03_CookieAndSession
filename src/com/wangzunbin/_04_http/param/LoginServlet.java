package com.wangzunbin._04_http.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 后来拿到username都是null, session应运而生
 * 
 * @author Administrator
 *
 */
@WebServlet("/param/login")
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
		if ("admin".equals(username) && "1234".equals(password)) {
			writer.print("欢迎:" + username + "<br/>");
			writer.print("<a href='/param/list'>收件箱</a>");
		}
	}
}
