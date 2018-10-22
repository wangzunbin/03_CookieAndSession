package com.wangzunbin._04_http.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/param/list")
public class ListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -252178086608694992L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		out.print("欢迎:" + username + "<br/>");
		out.print("<a href='/param/content'>邮件一</a><br/>");
		out.print("<a href='/param/content'>邮件二</a><br/>");
		out.print("<a href='/param/content'>邮件三</a><br/>");
	}
}
